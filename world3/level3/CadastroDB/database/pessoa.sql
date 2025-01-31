CREATE DATABASE lojas;
USE lojas;

CREATE TABLE Pessoa (
    id INT PRIMARY KEY IDENTITY(1,1),
    nome VARCHAR(100),
    logradouro VARCHAR(150),
    cidade VARCHAR(50),
    estado VARCHAR(50),
    telefone VARCHAR(15),
    email VARCHAR(100)
);

CREATE TABLE PessoaFisica (
    id INT PRIMARY KEY,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    FOREIGN KEY (id) REFERENCES Pessoa(id) ON DELETE CASCADE
);

CREATE TABLE PessoaJuridica (
    id INT PRIMARY KEY,
    cnpj VARCHAR(18) UNIQUE NOT NULL,
    FOREIGN KEY (id) REFERENCES Pessoa(id) ON DELETE CASCADE
);
