'use client';
import { SessionProvider } from 'next-auth/react';
import React from 'react';
import { Aside } from './components/Aside';
import { Toaster } from 'react-hot-toast';
import { ModelContext } from './context/ModelContext';
import { useModels } from './hooks/useModels';

export const LayoutProvider = ({ children }: { children: React.ReactNode }) => {
    const { models } = useModels();

    return (
        <SessionProvider>
            <ModelContext.Provider value={{ models }}>
                <Toaster />

                <Aside />

                <main className="h-full grow">{children}</main>
            </ModelContext.Provider>
        </SessionProvider>
    );
};
