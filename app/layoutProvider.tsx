'use client';
import { SessionProvider } from 'next-auth/react';
import React from 'react';
import { Aside } from './components/Aside';
import { Toaster } from 'react-hot-toast';
import { ModelContext } from './context/ModelContext';
import { useModels } from './hooks/useModels';
import { InfinitySpin } from 'react-loader-spinner';

export const LayoutProvider = ({ children }: { children: React.ReactNode }) => {
    const { models, dataFetching, addNewModel } = useModels();

    return (
        <SessionProvider>
            <ModelContext.Provider value={{ models, addNewModel }}>
                <Toaster />

                <Aside />

                <main className="h-full grow">
                    {dataFetching ? (
                        <div className="absolute left-0 top-0 flex h-full w-full items-center justify-center">
                            <InfinitySpin color="var(--primary)" />
                        </div>
                    ) : (
                        children
                    )}
                </main>
            </ModelContext.Provider>
        </SessionProvider>
    );
};
