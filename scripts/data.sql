CREATE TABLE usuarios(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255),
    login VARCHAR(255),
    senha VARCHAR(255),
    ultima_alteracao DATE,
    tipo_usuario VARCHAR(255)
);

CREATE TABLE clientes(
    id SERIAL PRIMARY KEY,
    id_usuario BIGINT,
    rua VARCHAR(255),
    bairro VARCHAR(255),
    numero VARCHAR(255),
    cep VARCHAR(255),
    complemento VARCHAR(255),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

CREATE TABLE dono_restaurante(
    id SERIAL PRIMARY KEY,
    id_usuario BIGINT,
    nome_restaurante VARCHAR(255),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);