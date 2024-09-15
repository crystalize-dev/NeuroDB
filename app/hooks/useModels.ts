import { useEffect, useState } from 'react';
import { Model } from '../types/ModelType';
import { customAxios } from '../axios/customAxios';
import { useRouter } from 'next/navigation';

export const useModels = () => {
    const router = useRouter();

    const [dataFetching, setDataFetching] = useState(false);
    const [models, setModels] = useState<Model[]>([]);

    const addNewModel = async (
        data: FormData,
        setFetching: React.Dispatch<React.SetStateAction<boolean>>
    ) => {
        await customAxios('POST', 'models', setFetching, {
            filesToUpload: true,
            data: data,
            loadingString: 'Загрузка...',
            successString: 'Успешно!',
            actionOnSuccess: (data) => {
                const newModel = data as Model;
                setModels((prevModels) => [...prevModels, newModel]);
                router.push(`/model/${newModel.id}`);
            }
        });
    };

    const renameModel = async (id: string, newFilename: string) => {
        await customAxios('PUT', `models`, setDataFetching, {
            data: { id, newFilename },
            loadingString: 'Изменение...',
            successString: 'Изменения сохранены!',
            actionOnSuccess: (data) => {
                const updatedModel = data as Model;
                setModels((prevModels) =>
                    prevModels.map((model) =>
                        model.id === id ? updatedModel : model
                    )
                );
            }
        });
    };

    useEffect(() => {
        customAxios('GET', 'models', setDataFetching, {
            actionOnSuccess: (res) => {
                setModels((res as { models: Model[] }).models);
            }
        });
    }, []);

    return { models, dataFetching, addNewModel, renameModel };
};
