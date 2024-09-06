CREATE TABLE Pais (
    id_pais bigint,
    id_paquete bigserial,
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY(id_pais)
);