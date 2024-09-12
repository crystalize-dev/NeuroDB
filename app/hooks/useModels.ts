import { useState } from 'react';
import { Model } from '../types/ModelType';

export const useModels = () => {
    const [models, setModels] = useState<Model[]>([
        {
            id: '1',
            name: 'Model 1'
        },
        {
            id: '2',
            name: 'Model test'
        }
    ]);

    return { models };
};
