'use client';
import React, { ChangeEvent, useState, useCallback } from 'react';
import classNames from 'classnames';
import { IconType } from '../Icon/icon-database';
import Icon from '../Icon/Icon';

interface InputProps extends React.HTMLAttributes<HTMLInputElement> {
    type: 'email' | 'password' | 'text';
    disabled?: boolean;
    placeholder?: string;
    placeholderType?: 'inner' | 'classic';
    passwordSetup?: boolean;
    onType?: (value: string) => void;
    name?: string;
    required?: boolean;
    icon?: IconType;
    layoutId?: string;
    inputClassName?: string;
    restrictedLength?: boolean;
    forgotPassword?: boolean;
}

const Input = ({
    placeholderType = 'inner',
    passwordSetup = false,
    forgotPassword = false,
    icon,
    type,
    className,
    inputClassName,
    defaultValue = '',
    disabled,
    layoutId,
    placeholder,
    hidden,
    required,
    onType,
    restrictedLength = false,
    ...otherProps
}: InputProps) => {
    const [value, setValue] = useState(defaultValue);
    const [isVisiblePassword, setVisiblePassword] = useState(false);
    const [error, setError] = useState(' ');

    const changeValue = useCallback(
        (e: ChangeEvent<HTMLInputElement>) => {
            const newValue = e.target.value;

            if (restrictedLength && newValue.length > 10) return;
            if (required && newValue.length > 0) setError(' ');

            setValue(newValue);
            onType && onType(newValue);
        },
        [restrictedLength, required, onType]
    );

    const inputType = type === 'password' && isVisiblePassword ? 'text' : type;

    const handleBlur = useCallback(() => {
        if (required) setError(!value ? 'Required!' : ' ');
    }, [required, value]);

    // Stylization
    const focusStyles =
        'outline outline-2 outline-transparent focus:outline-primary focus:bg-white';
    const disabledStyles = 'cursor-not-allowed opacity-50';

    const containerClassNames = classNames(
        'relative flex h-fit w-full flex-col gap-2 text-sm',
        {
            'items-center': icon,
            [className || '']: !!className
        }
    );

    const inputClassNames = classNames(
        'bg-light-object dark:bg-dark-object h-11 w-full rounded-md p-4 !text-base transition-all',
        focusStyles,
        { [disabledStyles]: disabled },
        { 'pr-10': icon },
        inputClassName,
        { '!outline-red-500': error === 'Required!' },
        { '!pr-12': passwordSetup }
    );

    const iconClassNames = classNames(
        'pointer-events-none absolute right-4 select-none text-zinc-400',
        {
            'top-1/2 -translate-y-1/2': placeholderType === 'classic',
            'bottom-[2.1rem]': placeholderType !== 'classic'
        }
    );

    const passwordSetupClassNames = classNames(
        'absolute right-4 text-zinc-400',
        {
            'top-1/2 -translate-y-1/2': placeholderType === 'classic',
            'bottom-[0.9rem]': placeholderType !== 'classic'
        }
    );

    return (
        <div className={containerClassNames}>
            {placeholderType === 'inner' && (
                <p className="self-start font-semibold text-inherit">
                    {placeholder}
                </p>
            )}

            <input
                {...otherProps}
                type={inputType}
                required={required}
                onBlur={handleBlur}
                autoComplete="off"
                disabled={disabled}
                placeholder={
                    placeholderType === 'classic' ? placeholder : undefined
                }
                hidden={hidden}
                value={value}
                onChange={changeValue}
                className={inputClassNames}
            />

            {icon && type !== 'password' && (
                <Icon icon={icon} className={iconClassNames} />
            )}

            {passwordSetup && type === 'password' && (
                <Icon
                    icon={isVisiblePassword ? 'eye' : 'eye-closed'}
                    className={passwordSetupClassNames}
                    onClick={() => setVisiblePassword(!isVisiblePassword)}
                />
            )}
        </div>
    );
};

export default Input;
