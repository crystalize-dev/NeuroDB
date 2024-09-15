'use client';
import Icon from '@/app/components/Icon/Icon';
import Button from '@/app/components/UI/Button';
import Input from '@/app/components/UI/Input';
import { ModelContext } from '@/app/context/ModelContext';
import { Model } from '@/app/types/ModelType';
import { useParams } from 'next/navigation';
import React, { FormEvent, useContext, useEffect, useState } from 'react';
import { InfinitySpin } from 'react-loader-spinner';

const ModelPage = () => {
    const { id } = useParams();
    const { models, renameModel } = useContext(ModelContext);

    const [renamingModel, setRenamingModel] = useState(false);

    const [model, setModel] = useState<Model | undefined>();
    const [fetching, setFetching] = useState(false);

    const renameModelSubmit = async (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();

        if (!model) return;

        const form = new FormData(e.target as HTMLFormElement);
        const newFilename = form.get('newFilename') as string;

        if (newFilename === model.filename) {
            setRenamingModel(false);
            return;
        }

        await renameModel(model.id, newFilename);

        setRenamingModel(false);
    };

    useEffect(() => {
        setTimeout(() => {}, 3000);

        setFetching(true);
        setModel(models.find((model) => model.id === id));
        setFetching(false);
    }, [id, models]);

    return (
        <div
            className={`relative flex h-full grow flex-col gap-4 p-8 ${!model && 'items-center justify-center'}`}
        >
            {fetching ? (
                <InfinitySpin color="var(--primary)" />
            ) : !model ? (
                <p className="select-none text-4xl text-gray-400">
                    Модель не найдена!
                </p>
            ) : (
                <>
                    {!renamingModel ? (
                        <h1 className="flex items-center gap-2 text-4xl text-primary">
                            Модель - {model.filename}
                            <Icon
                                icon="pen"
                                onClick={() => setRenamingModel(true)}
                            />
                        </h1>
                    ) : (
                        <form
                            onSubmit={renameModelSubmit}
                            className="flex items-center gap-2"
                        >
                            <Input
                                type="text"
                                name="newFilename"
                                defaultValue={model.filename}
                                required
                                placeholderType="classic"
                                className="!w-fit"
                            />

                            <Button type="submit" variant="colored">
                                Подтвердить
                            </Button>
                        </form>
                    )}

                    <hr className="w-full border-primary" />
                </>
            )}
        </div>
    );
};

export default ModelPage;
