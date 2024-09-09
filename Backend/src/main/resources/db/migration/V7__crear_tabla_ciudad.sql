CREATE TABLE ciudad (
    id_ciudad bigserial,
    id_pais bigint NOT NULL,  -- Corregido para reflejar la relación con la tabla `pais`
    nombre_ciudad VARCHAR(100) NOT NULL,
    PRIMARY KEY(id_ciudad),
    FOREIGN KEY (id_pais) REFERENCES pais(id_pais)  -- Añadido para establecer la clave foránea
);

