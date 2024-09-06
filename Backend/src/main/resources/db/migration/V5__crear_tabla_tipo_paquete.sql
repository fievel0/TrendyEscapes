CREATE TABLE Tipo_paquete (
    id_paquete bigint,
    id_tipo_paquete bigserial,
    descripcion VARCHAR(100) NOT NULL,
    PRIMARY KEY(id_tipo_paquete)
);