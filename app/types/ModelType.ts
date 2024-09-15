export type Model = {
    id: string;
    filename: string;
    filepath: String;
    variables: Variables;
};

export type CategoricalVariable = {
    name: string;
    values: string[];
};

export type Variables = {
    categoricalVariables: CategoricalVariable[];
    continous: string[];
};
