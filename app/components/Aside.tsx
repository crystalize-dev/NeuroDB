import { signOut, useSession } from 'next-auth/react';
import React, { useContext, useEffect, useState } from 'react';
import Button from './UI/Button';
import Icon from './Icon/Icon';
import { ModelContext } from '../context/ModelContext';
import Image from 'next/image';
import logoWhite from '../img/logoWhite.png';
import Input from './UI/Input';
import Link from 'next/link';
import ModelLink from './ModelLink';

export const Aside = () => {
    const session = useSession();

    const { models } = useContext(ModelContext);
    const [search, setSearch] = useState('');
    const [modelsToView, setModelsToView] = useState(models);

    useEffect(() => {
        if (!search) setModelsToView(models);
        else
            setModelsToView(
                models.filter((model) =>
                    model.name.toLowerCase().includes(search.toLowerCase())
                )
            );
    }, [search, models]);

    return (
        <div
            className={`flex h-full w-80 flex-col gap-4 bg-primary p-8 ${session.status !== 'authenticated' && '!hidden'}`}
        >
            <div className="flex h-fit items-center gap-2">
                <Image
                    src={logoWhite}
                    alt="logo"
                    width={500}
                    height={500}
                    className="size-8"
                    priority
                />
                <h1 className="text-2xl !font-bold text-white">NeuroDB</h1>
            </div>

            <hr className="w-full border-gray-400" />

            <Link className="w-full" href={'new-model'}>
                <Button
                    type="button"
                    variant="colored"
                    className="w-full"
                    buttonClassName="flex justify-center items-center gap-4 bg-white text-primary hover:bg-transparent hover:border-white hover:text-white"
                >
                    <Icon icon="plus" />
                    Добавить модель
                </Button>
            </Link>

            <hr className="w-full border-gray-400" />

            <h2 className="text-md text-center text-white">
                Список готовых моделей
            </h2>

            <hr className="w-full border-gray-400" />

            <Input
                type="text"
                onType={(value) => setSearch(value)}
                icon="search"
                placeholder="Найти"
                placeholderType="classic"
            />

            <div className="scrollable flex w-full grow flex-col">
                {modelsToView.length > 0 ? (
                    modelsToView.map((model) => (
                        <ModelLink key={model.id} model={model} />
                    ))
                ) : (
                    <p className="text-center text-sm text-gray-300">
                        Пока ничего нет!
                    </p>
                )}
            </div>
            <Button
                type="button"
                variant="transparent"
                onClick={() => signOut()}
                className="mt-auto w-fit font-semibold text-white transition-none hover:text-red-500"
                buttonClassName="flex w-full items-center gap-2 text-center"
            >
                Выйти
                <Icon icon="quit" className="!text-inherit transition-none" />
            </Button>
        </div>
    );
};
