import React from 'react';
import { Model } from '../types/ModelType';
import Link from 'next/link';

interface ModelLinkProps {
    model: Model;
}

const ModelLink = ({ model }: ModelLinkProps) => {
    return (
        <Link
            href={`/model/${model.id}`}
            className="w-full rounded-md px-4 py-2 text-white hover:bg-white/10"
        >
            {model.filename}
        </Link>
    );
};

export default ModelLink;
