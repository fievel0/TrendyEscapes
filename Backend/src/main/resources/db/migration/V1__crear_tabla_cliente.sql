CREATE TABLE Cliente (
    id_c bigserial,
    id_tipodocumento bigint,
    id_pais bigint,
    id_formapago bigint,
    id_autenticacion bigint,
    nombre VARCHAR(100),
    num_documento VARCHAR(50),
    fecha_nacimiento date,
    edad INT,
    direccion VARCHAR(255),
    telefono VARCHAR(50),
    email VARCHAR(100),
    PRIMARY KEY(id_c)
);



