CREATE TABLE paquete (
    id_paquete BIGSERIAL PRIMARY KEY,
    id_pais BIGINT NOT NULL,
    id_tipo_paquete BIGINT NOT NULL,
    nombre_paquete VARCHAR(100) NOT NULL UNIQUE,
    costo_paquete INTEGER,
    hotel VARCHAR(255),
    foto BYTEA
);