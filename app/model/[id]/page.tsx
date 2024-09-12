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

    useEffect(() => {
        setTimeout(() => {}, 3000);

        setModel(models.find((model) => model.id === id));
    }, [id, models]);

    return (
        <div
            className={`flex h-full grow flex-col ${!model && 'items-center justify-center'}`}
        >
            {model ? (
                <div>{model.name}</div>
            ) : (
                <InfinitySpin color="var(--primary)" />
            )}
        </div>
    );
};

export default ModelPage;
