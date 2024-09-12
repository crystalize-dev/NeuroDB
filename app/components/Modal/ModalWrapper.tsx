import React, { FormEvent } from 'react';
import Icon from '../Icon/Icon';

interface ModalWrapperProps {
    visible: boolean;
    setVisible: React.Dispatch<React.SetStateAction<boolean>>;
    submitFunc: (e: FormEvent) => void;
    children: React.ReactNode;
}

export const ModalWrapper = ({
    visible,
    setVisible,
    submitFunc,
    children
}: ModalWrapperProps) => {
    return (
        <div
            className={`absolute left-0 top-0 flex h-full w-screen items-center justify-center bg-black/70 ${!visible && 'hidden'}`}
            onMouseDown={() => setVisible(false)}
        >
            <form
                onSubmit={submitFunc}
                onMouseDown={(e) => e.stopPropagation()}
                className="relative flex h-full w-full flex-col items-center gap-4 bg-white p-8 lg:h-fit lg:w-fit lg:rounded-lg"
            >
                <Icon
                    icon="close"
                    className="absolute -right-6 text-white lg:-top-6"
                    onClick={() => setVisible(false)}
                />

                {children}
            </form>
        </div>
    );
};
