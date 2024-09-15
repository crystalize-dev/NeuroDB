import { PrismaClient } from '@prisma/client';
import fs from 'fs';
import path from 'path';
import { NextRequest, NextResponse } from 'next/server';

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

    // Save file info to the database
    return await prisma.model.create({
        data: {
            filename: modelName || file.name || 'Без имени',
            filepath: relativeFilePath
        }
    });
};

export async function GET() {
    try {
        await updateDatabaseWithNewFiles();

        await removeMissingFiles();

        const models = await prisma.model.findMany();

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
            await prisma.model.create({
                data: {
                    filename: file,
                    filepath: relativeFilePath
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
                where: { id: model.id }
            });
        }
    }
}

export async function PUT(req: NextRequest) {
    const { id, newFilename } = await req.json();

    const model = await prisma.model.findUnique({ where: { id } });

    console.log(model);

    if (!model) {
        return NextResponse.json(
            { error: 'Модель не найдена!' },
            { status: 404 }
        );
    }

    return NextResponse.json(
        await prisma.model.update({
            where: { id },
            data: { filename: newFilename }
        }),
        {
            status: 200
        }
    );
}
