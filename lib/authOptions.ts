import {
    NextAuthOptions,
    User as NextAuthUser,
    Session as NextAuthSession
} from 'next-auth';

import bcrypt from 'bcrypt';
import CredentialsProvider from 'next-auth/providers/credentials';

import { PrismaClient } from '@prisma/client';
import { PrismaAdapter } from '@next-auth/prisma-adapter';

const prisma = new PrismaClient();

export const authConfig: NextAuthOptions = {
    secret: process.env.SECRET,
    adapter: PrismaAdapter(prisma),
    providers: [
        CredentialsProvider({
            name: 'Credentials',
            id: 'credentials',
            credentials: {
                email: {
                    type: 'email'
                },
                password: { type: 'password' }
            },
            async authorize(credentials) {
                const email = credentials?.email;
                const password = credentials?.password;
                if (!email || !password) return null;

                const user = await prisma.user.findUnique({
                    where: { email: email }
                });
                if (!user) throw new Error('Wrong email or password!');

                const passwordMatch = await bcrypt.compare(
                    password,
                    user.hashedPassword as string
                );

                if (!passwordMatch) throw new Error('Wrong email or password!');

                return user;
            }
        })
    ],
    session: { strategy: 'jwt' },
    pages: {
        signIn: '/login',
        error: '/login'
    },
    callbacks: {
        async session({ token, session }) {
            if (token) {
                session.user = session.user || {}; // Ensure session.user is always defined
                session.user.name = token.name;
                session.user.email = token.email;
            }

            return session;
        },
        async jwt({ token, user }) {
            const email = token.email;

            const dbUser = await prisma.user.findUnique({
                where: { email: email as string }
            });

            if (!dbUser) {
                token.id = user?.id;
                return token;
            }

            return {
                id: dbUser.id,
                name: dbUser.name,
                email: dbUser.email
            };
        }
    }
};
