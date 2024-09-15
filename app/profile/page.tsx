'use client';
import React from 'react';
import Button from '../components/UI/Button';
import { signOut } from 'next-auth/react';

const ProfilePage = () => {
    return (
        <div className={`relative flex h-full grow flex-col gap-4 p-8`}>
            <h1 className="text-4xl text-primary">Профиль</h1>

            <hr className="w-full border-primary" />

            <Button
                type="button"
                variant="colored"
                onClick={() => signOut()}
                buttonClassName="bg-red-500 text-white hover:!border-red-500 hover:bg-transparent hover:text-red-500"
                className="w-fit"
            >
                Выйти
            </Button>
        </div>
    );
};

export default ProfilePage;
