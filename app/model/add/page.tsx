'use client';
import Icon from '@/app/components/Icon/Icon';
import Button from '@/app/components/UI/Button';
import Input from '@/app/components/UI/Input';
import { ModelContext } from '@/app/context/ModelContext';
import React, {
    FormEvent,
    useContext,
    useEffect,
    useRef,
    useState
} from 'react';
import toast from 'react-hot-toast';

const ModelAddPage = () => {
    const { addNewModel } = useContext(ModelContext);

    const [fetching, setFetching] = useState(false);

    const [file, setFile] = useState<File | null>(null);
    const [name, setName] = useState('');

    const dropZoneRef = useRef<HTMLDivElement | null>(null);
    const [isDragging, setIsDragging] = useState(false);

    const handleDragEnter: React.DragEventHandler<HTMLDivElement> = (event) => {
        event.preventDefault();
        event.stopPropagation();
        setIsDragging(true);
    };

    const handleDragLeave: React.DragEventHandler<HTMLDivElement> = (event) => {
        event.preventDefault();
        event.stopPropagation();

        // Проверяем, что relatedTarget (элемент, к которому переместился курсор) находится вне зоны дропа
        if (
            dropZoneRef.current &&
            !dropZoneRef.current.contains(event.relatedTarget as Node)
        ) {
            setIsDragging(false); // Только если курсор вышел за пределы зоны дропа
        }
    };

    const handleDrop: React.DragEventHandler<HTMLDivElement> = (event) => {
        event.preventDefault();
        event.stopPropagation();

        setIsDragging(false);

        const files = event.dataTransfer.files;
        if (files.length > 0) {
            const droppedFile = files[0];
            if (droppedFile.name.endsWith('.java')) {
                setFile(droppedFile);
            } else {
                toast.error(
                    'Извините, но только файлы с расширением.java могут быть загружены!'
                );
            }
        }
    };

    const handleFileChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        // Проверяем, что e.target.files существует и содержит хотя бы один файл
        if (e.target.files && e.target.files.length > 0) {
            setFile(e.target.files[0]);
        } else {
            setFile(null); // Обработка случая, если файлов нет
        }
    };

    const submit = async (e: FormEvent) => {
        e.preventDefault();

        if (!file) {
            toast.error('Вы должны выбрать файл с расширением .java!');
            return;
        }

        const formData = new FormData();
        formData.append('file', file);

        if (name) {
            formData.append('modelName', name);
        }

        await addNewModel(formData, setFetching);
    };

    useEffect(() => {
        const handleWindowDragOver = (event: DragEvent) => {
            event.preventDefault();
        };

        const handleWindowDrop = (event: DragEvent) => {
            event.preventDefault();
        };

        window.addEventListener('dragover', handleWindowDragOver);
        window.addEventListener('drop', handleWindowDrop);

        return () => {
            window.removeEventListener('dragover', handleWindowDragOver);
            window.removeEventListener('drop', handleWindowDrop);
        };
    }, []);

    return (
        <div
            ref={dropZoneRef}
            className={`relative flex h-full grow flex-col gap-4 p-8`}
            onDragEnter={handleDragEnter}
            onDragLeave={handleDragLeave}
            onDrop={handleDrop}
        >
            <h1 className="text-4xl text-primary">Добавление новой модели</h1>

            <hr className="w-full border-primary" />

            <form
                onSubmit={submit}
                className="mt-8 flex w-[36rem] flex-col gap-6"
            >
                <div className="z-10 flex w-full items-center gap-4">
                    <Icon
                        icon={file ? 'ok' : 'close'}
                        className={`pointer-events-none !size-8 select-none rounded-full p-1 text-white ${file ? 'bg-green-500' : 'bg-red-500'}`}
                    />

                    <p className="text-lg font-bold">Файл: </p>

                    <label
                        id="inputFiles"
                        className={`hover:bg-primary-light grow cursor-pointer select-none rounded-md border-2 border-dashed border-primary p-4 transition-all ${isDragging && 'bg-primary-light absolute left-0 top-0 h-full w-full backdrop-blur-sm'}`}
                    >
                        {isDragging ? (
                            <div className="flex h-full items-center justify-center gap-4 text-white">
                                <Icon className="!size-40" icon="folder" />
                                <p className="text-4xl">Загрузка файла</p>
                            </div>
                        ) : file ? (
                            file.name
                        ) : (
                            'Добавьте файл модели (в формате .java)'
                        )}
                        <input
                            disabled={fetching}
                            className="hidden w-fit !appearance-none"
                            type="file"
                            accept=".java"
                            onChange={handleFileChange}
                        />
                    </label>
                </div>

                <div className="z-0 flex w-full items-center gap-4">
                    <Icon
                        icon={'comment'}
                        className={`pointer-events-none !size-8 min-w-8 select-none rounded-full bg-yellow-500 p-2 text-white`}
                    />

                    <p className="text-lg font-bold">Название: </p>

                    <Input
                        disabled={fetching}
                        type="text"
                        placeholder="Название модели (необязательно)"
                        onType={setName}
                        className="!w-[unset] !grow"
                        placeholderType="classic"
                    />
                </div>

                <Button
                    type="submit"
                    variant="colored"
                    className="!w-full"
                    disabled={fetching}
                >
                    Добавить
                </Button>
            </form>
        </div>
    );
};

export default ModelAddPage;
