/** @type {import('tailwindcss').Config} */
const config = {
    content: [
        './pages/**/*.{js,ts,jsx,tsx,mdx}',
        './components/**/*.{js,ts,jsx,tsx,mdx}',
        './app/**/*.{js,ts,jsx,tsx,mdx}'
    ],
    darkMode: 'selector',
    theme: {
        extend: {
            colors: {
                primary: {
                    DEFAULT: 'var(--primary)',
                    dark: 'var(--primary-dark)',
                    light: 'var(--primary-light)'
                },
                light: {
                    DEFAULT: 'var(--bg-full)',
                    object: 'var(--bg-object)'
                },
                dark: {
                    DEFAULT: 'var(--bg-full-dark)',
                    object: 'var(--bg-object-dark)'
                }
            }
        }
    },
    plugins: ['prettier-plugin-tailwindcss']
};

export default config;
