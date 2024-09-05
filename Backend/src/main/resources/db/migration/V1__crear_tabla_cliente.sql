CREATE TABLE Cliente (
    id_cliente bigserial,
    id_pais bigint,
    id_formapago bigint,
    id_autenticacion bigint,
    nombre VARCHAR(100),
    num_documento VARCHAR(50),
    fecha_nacimiento date,
    direccion VARCHAR(255),
    telefono VARCHAR(50),
    PRIMARY KEY(id_cliente)
);



