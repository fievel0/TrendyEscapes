CREATE TABLE paquete (
    id_paquete BIGSERIAL PRIMARY KEY,
    id_pais BIGINT NOT NULL,
    id_tipo_paquete BIGINT NOT NULL,
    nombre_paquete VARCHAR(100) NOT NULL,
    descripcion VARCHAR(500),
    costo_paquete INTEGER,
    hotel BOOLEAN,
    foto TEXT
);