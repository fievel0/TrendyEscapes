CREATE TABLE tipo_pago (
    id_tipo_pago bigserial,
    descripcion VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY(id_tipo_pago)
);