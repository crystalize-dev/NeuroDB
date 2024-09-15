'use client';
import React, { FormEvent, useState } from 'react';
import Button from '../components/UI/Button';
import { signOut, useSession } from 'next-auth/react';
import Input from '../components/UI/Input';
import { InfinitySpin } from 'react-loader-spinner';
import toast from 'react-hot-toast';
import { customAxios } from '../axios/customAxios';

const ProfilePage = () => {
    const [changingPassword, setChangingPassword] = useState(false);
    const [fetching, setFetching] = useState(false);

    const session = useSession();

    console.log(session);

    const submit = async (e: FormEvent) => {
        e.preventDefault();

        if (!changingPassword) return;

        if (!session || !session.data || !session.data.user) return;

        const form = new FormData(e.target as HTMLFormElement);
        const password = form.get('password') as string;
        const passwordRepeat = form.get('passwordRepeat') as string;

        if (!password || !passwordRepeat) return;

        if (password !== passwordRepeat) {
            toast.error('Пароли не совпадают!');
            return;
        }

        if (password.length < 6) {
            toast.error('Пароль должен быть не менее 6 символов!');
            return;
        }

        await customAxios('POST', 'reset-password', setFetching, {
            data: { password, email: session.data.user.email },
            loadingString: 'Обновляем...',
            successString: 'Пароль успешно обновлён!',
            actionOnSuccess: () => {
                setChangingPassword(false);
            }
        });
    };

    return (
        <div className={`relative flex h-full grow flex-col gap-4 p-8`}>
            <h1 className="text-4xl text-primary">Профиль</h1>

            <hr className="w-full border-primary" />

            {session?.data?.user ? (
                <form
                    onSubmit={submit}
                    className="flex h-fit w-72 flex-col gap-4"
                >
                    <Input
                        type="text"
                        defaultValue={session.data.user.email as string}
                        className="!w-72"
                        placeholder="Логин"
                        disabled
                    />

                    {changingPassword ? (
                        <>
                            <Input
                                name="password"
                                type="password"
                                className="!w-72"
                                required
                                passwordSetup
                                placeholder="Новый пароль"
                            />

                            <Input
                                required
                                name="passwordRepeat"
                                type="password"
                                className="!w-72"
                                placeholder="Подтвердите пароль"
                            />
                        </>
                    ) : (
                        <Input
                            type="text"
                            defaultValue={'******'}
                            className="!w-72"
                            placeholder="Пароль"
                            disabled
                        />
                    )}

                    {changingPassword ? (
                        <Button
                            type="submit"
                            variant="colored"
                            className="mt-4 !w-72"
                        >
                            Изменить
                        </Button>
                    ) : (
                        <Button
                            type="button"
                            variant="colored"
                            className="mt-4 !w-72"
                            onClick={() => setChangingPassword(true)}
                        >
                            Изменить пароль
                        </Button>
                    )}

                    <Button
                        type="button"
                        variant="colored"
                        onClick={() => signOut()}
                        buttonClassName="bg-red-500 text-white hover:!border-red-500 hover:bg-transparent hover:text-red-500"
                        className="!w-72 w-fit"
                    >
                        Выйти
                    </Button>
                </form>
            ) : (
                <div className="h-full w-full">
                    <InfinitySpin color="var(--primary)" />
                </div>
            )}
        </div>
    );
};

export default ProfilePage;
