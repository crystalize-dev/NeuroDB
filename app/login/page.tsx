'use client';
import React, { FormEvent, useState } from 'react';
import Button from '../components/UI/Button';
import Input from '../components/UI/Input';
import { useRouter } from 'next/navigation';
import logo from '../img/logo.png';
import Image from 'next/image';
import { signIn } from 'next-auth/react';
import toast from 'react-hot-toast';

const LoginPage = () => {
    const [fetching, setFetching] = useState(false);
    const router = useRouter();

    const submit = async (e: FormEvent) => {
        e.preventDefault();

        const form = new FormData(e.target as HTMLFormElement);
        const email = form.get('email');
        const password = form.get('password');

        if (!email || !password) {
            toast.error('Оба поля должны быть заполнены!');
            return;
        }

        setFetching(true);
        const promise = signIn('credentials', {
            email,
            password,
            redirect: false
        }).then((res) => {
            setFetching(false);

            if (res && res.ok) {
                router.push('/');
                return Promise.resolve('Успешный вход!');
            } else if (res?.error === 'Wrong email or password!') {
                return Promise.reject('Неверный пароль или email!');
            } else {
                return Promise.reject('Что-то пошло не так!');
            }
        });

        await toast.promise(promise, {
            loading: 'Подождите...',
            success: 'Успешно!',
            error: (err) => `${err}`
        });
    };

    return (
        <div className="flex h-full w-full items-center justify-center bg-primary">
            <form
                className="flex h-full min-h-96 w-full min-w-96 flex-col items-center justify-center gap-2 bg-white p-12 shadow-md lg:h-fit lg:w-fit lg:rounded-lg"
                onSubmit={submit}
            >
                <div className="size-16">
                    <Image
                        src={logo}
                        alt="logo"
                        width={500}
                        height={500}
                        priority
                        className="h-full w-full"
                    />
                </div>

                <h1 className="mb-8 text-4xl font-bold">Вход</h1>

                <Input
                    disabled={fetching}
                    name="email"
                    type="email"
                    required
                    inputClassName="bg-light"
                    placeholder="Логин (E-mail)"
                />

                <Input
                    disabled={fetching}
                    name="password"
                    type="password"
                    required
                    inputClassName="bg-light"
                    placeholder="Пароль"
                />

                <Button
                    disabled={fetching}
                    type="submit"
                    variant="colored"
                    className="mt-8 w-full"
                >
                    Войти
                </Button>
            </form>
        </div>
    );
};

export default LoginPage;
