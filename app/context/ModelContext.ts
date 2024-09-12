import { createContext } from 'react';
import { Folder, Model } from '../types/ModelType';

type ModelContextType = {
    models: Model[];
};

export const ModelContext = createContext<ModelContextType>({
    models: []
});
