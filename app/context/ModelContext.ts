import { createContext } from 'react';
import { Model } from '../types/ModelType';

type ModelContextType = {
    models: Model[];
    addNewModel: (
        data: FormData,
        setFetching: React.Dispatch<React.SetStateAction<boolean>>
    ) => void;
};

export const ModelContext = createContext<ModelContextType>({
    models: [],
    addNewModel: () => {}
});
