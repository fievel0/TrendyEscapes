CREATE TABLE paquete_ciudad (
    id_paquete BIGINT NOT NULL,
    id_ciudad BIGINT NOT NULL,
    PRIMARY KEY (id_paquete, id_ciudad),
    FOREIGN KEY (id_paquete) REFERENCES paquete(id_paquete) ON DELETE CASCADE,
    FOREIGN KEY (id_ciudad) REFERENCES ciudad(id_ciudad) ON DELETE CASCADE
);