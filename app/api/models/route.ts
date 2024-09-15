import { PrismaClient } from '@prisma/client';
import fs from 'fs';
import path from 'path';
import { NextRequest, NextResponse } from 'next/server';
import { CategoricalVariable, Variables } from '@/app/types/ModelType';

const prisma = new PrismaClient();
const directoryToWatch = path.join(process.cwd(), 'models');

export async function POST(req: NextRequest) {
    try {
        const formData = await req.formData();

        return NextResponse.json(await handleFileUpload(formData), {
            status: 201
        });
    } catch (error) {
        console.error('Ошибка при обработке файла:', error);

        return NextResponse.json({ error: String(error) }, { status: 500 });
    }
}

// Function to handle file upload from FormData
const handleFileUpload = async (formData: FormData) => {
    const file = formData.get('file') as File;
    const modelName = formData.get('modelName') as string;

    if (!file) {
        throw new Error('Файл не загружен!');
    }

    // Generate file path and check if file exists in the database
    const filePath = path.join(directoryToWatch, file.name);
    const relativeFilePath = path.relative(process.cwd(), filePath);

    const existingFile = await prisma.model.findUnique({
        where: { filepath: relativeFilePath }
    });

    if (existingFile) {
        throw new Error('Файл уже есть в Базе данных!');
    }

    // Save file to disk
    const arrayBuffer = await file.arrayBuffer();
    const buffer = Buffer.from(arrayBuffer);
    fs.writeFileSync(filePath, buffer);

    const variables = await parseModel(relativeFilePath);

    // Save file info to the database
    return await prisma.model.create({
        data: {
            filename: modelName || file.name || 'Без имени',
            filepath: relativeFilePath,
            variables: {
                create: {
                    categoricalVariables: {
                        createMany: {
                            data: variables.categoricalVariables.map((cv) => ({
                                name: cv.name,
                                values: cv.values
                            }))
                        }
                    },
                    continous: variables.continous
                }
            }
        }
    });
};

export async function GET() {
    try {
        await updateDatabaseWithNewFiles();

        await removeMissingFiles();

        const models = await prisma.model.findMany({
            include: {
                variables: {
                    select: {
                        categoricalVariables: true,
                        continous: true
                    }
                }
            }
        });

        return NextResponse.json({ models }, { status: 200 });
    } catch (error) {
        return NextResponse.json(
            {
                message: 'Ошибка при обработке GET запроса на API - models!'
            },
            { status: 500 }
        );
    }
}

async function updateDatabaseWithNewFiles() {
    const filesInDirectory = fs.readdirSync(directoryToWatch);

    for (const file of filesInDirectory) {
        const absoluteFilePath = path.join(directoryToWatch, file);
        const relativeFilePath = path.relative(process.cwd(), absoluteFilePath);

        const existingFile = await prisma.model.findUnique({
            where: { filepath: relativeFilePath }
        });

        if (!existingFile) {
            const variables = (await parseModel(relativeFilePath)) as Variables;

            await prisma.model.create({
                data: {
                    filename: file,
                    filepath: relativeFilePath,
                    variables: {
                        create: {
                            categoricalVariables: {
                                createMany: {
                                    data: variables.categoricalVariables.map(
                                        (cv) => ({
                                            name: cv.name,
                                            values: cv.values
                                        })
                                    )
                                }
                            },
                            continous: variables.continous
                        }
                    }
                }
            });
        }
    }
}

async function removeMissingFiles() {
    const allModels = await prisma.model.findMany();

    for (const model of allModels) {
        const absoluteFilePath = path.join(process.cwd(), model.filepath);

        if (!fs.existsSync(absoluteFilePath)) {
            await prisma.model.delete({
                where: { id: model.id },
                include: {
                    variables: {
                        select: {
                            categoricalVariables: true,
                            continous: true
                        }
                    }
                }
            });
        }
    }
}

async function parseModel(filepath: string): Promise<Variables> {
    const continousRegex = new RegExp(
        '^(?!.*categories\\s+are).*?(\\w+)\\s+Type\\s*-\\s*[^(\\n]+',
        'gm'
    );

    const categoricalRegex = new RegExp(
        '(\\w+)\\s+Type\\s*-\\s*String\\s*\\(categories\\s+are\\s*(\\{[^}]+\\})\\s*\\)',
        'gm'
    );

    // Read the file content
    const fileContent = fs.readFileSync(filepath, 'utf-8');

    // Find all matches for continous variables
    const continousVariables: string[] = [];
    let continousMatch;
    while ((continousMatch = continousRegex.exec(fileContent)) !== null) {
        continousVariables.push(continousMatch[1]);
    }

    // Find all matches for categorical variables
    const categoricalVariables: CategoricalVariable[] = [];
    let categoricalMatch;
    while ((categoricalMatch = categoricalRegex.exec(fileContent)) !== null) {
        const name = categoricalMatch[1];
        const valuesString = categoricalMatch[2];

        // Remove curly braces and split by spaces to extract values
        let values = valuesString
            .replace(/[{}]/g, '') // Remove curly braces
            .replace(/\"/g, '') // Remove double quotes if present
            .trim()
            .replaceAll('\\', '')
            .split(/\s+/); // Split by one or more spaces

        categoricalVariables.push({ name, values });
    }

    return {
        categoricalVariables: categoricalVariables,
        continous: continousVariables
    };
}

export async function PUT(req: NextRequest) {
    const { id, newFilename } = await req.json();

    const model = await prisma.model.findUnique({ where: { id } });

    if (!model) {
        return NextResponse.json(
            { error: 'Модель не найдена!' },
            { status: 404 }
        );
    }

    return NextResponse.json(
        await prisma.model.update({
            where: { id },
            data: { filename: newFilename },
            include: {
                variables: {
                    select: {
                        categoricalVariables: true,
                        continous: true
                    }
                }
            }
        }),
        {
            status: 200
        }
    );
}
