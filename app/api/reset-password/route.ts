import { PrismaClient } from '@prisma/client';
import { NextRequest, NextResponse } from 'next/server';
import bcrypt from 'bcrypt';

const prisma = new PrismaClient();

export async function POST(req: NextRequest) {
    try {
        const { password, email } = await req.json();

        if (!password || !email) {
            return NextResponse.json(
                { error: 'Сервером не получен пароль или email пользователя!' },
                { status: 400 }
            );
        }

        // Хэширование пароля
        const hashedPassword = await bcrypt.hash(
            password,
            await bcrypt.genSalt(10)
        );

        // Обновление пользователя
        const userUpdated = await prisma.user.update({
            where: { email },
            data: {
                hashedPassword
            }
        });

        return NextResponse.json(userUpdated, { status: 200 });
    } catch (err) {
        return NextResponse.json(
            { error: 'Что-то пошло не так!' },
            { status: 500 }
        );
    }
}
