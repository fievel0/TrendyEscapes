CREATE TABLE Paquete (
    id_pais bigint,
    id_tipo_paquete bigint,
    id_paquete bigserial PRIMARY KEY,
    nombre_paquete VARCHAR(100) NOT NULL,
    costo INTEGER,
    hotel VARCHAR(255),
    foto BYTEA,
    PRIMARY KEY(id_paquete)
);