import type { Metadata } from 'next';
import './globals.css';
import { LayoutProvider } from './layoutProvider';

export const metadata: Metadata = {
    title: 'Neuro DB',
    description: '🧠'
};

export default function RootLayout({
    children
}: Readonly<{
    children: React.ReactNode;
}>) {
    return (
        <html lang="en" className="h-full max-h-full w-full max-w-full">
            <body className="flex h-full max-h-full w-full max-w-full">
                <LayoutProvider>{children}</LayoutProvider>
            </body>
        </html>
    );
}
