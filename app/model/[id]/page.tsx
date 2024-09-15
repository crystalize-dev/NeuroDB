'use client';
import { ModelContext } from '@/app/context/ModelContext';
import { Model } from '@/app/types/ModelType';
import { useParams } from 'next/navigation';
import React, { useContext, useEffect, useState } from 'react';
import { InfinitySpin } from 'react-loader-spinner';

const ModelPage = () => {
    const { id } = useParams();
    const { models } = useContext(ModelContext);

    const [model, setModel] = useState<Model | undefined>();
    const [fetching, setFetching] = useState(false);

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
                    <h1 className="text-4xl text-primary">
                        Модель - {model.filename}
                    </h1>

                    <hr className="w-full border-primary" />
                </>
            )}
        </div>
    );
};

export default ModelPage;
