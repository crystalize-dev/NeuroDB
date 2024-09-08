'use client';
import { SessionProvider } from 'next-auth/react';
import React from 'react';

export const LayoutProvider = ({ children }: { children: React.ReactNode }) => {
    return (
        <SessionProvider>
            <main className="">{children}</main>
        </SessionProvider>
    );
};
