CREATE TABLE cliente (
    id_cliente BIGSERIAL PRIMARY KEY,
    id_pais BIGINT,
    id_formapago BIGINT,
    id_autenticacion BIGINT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    num_documento VARCHAR(50) NOT NULL UNIQUE,
    fecha_nacimiento DATE NOT NULL,
    direccion VARCHAR(255),
    telefono VARCHAR(50)
);



