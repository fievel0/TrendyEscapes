CREATE TABLE Autenticacion (
    id_auth bigserial,
    id_cliente bigint,
    email VARCHAR(100),
    contrasena VARCHAR(100),
    PRIMARY KEY(id_auth),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_c)
);
