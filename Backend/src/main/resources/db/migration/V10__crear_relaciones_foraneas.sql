-- Agregar claves foráneas a la tabla historial_compra

ALTER TABLE historial_compra
    ADD CONSTRAINT fk_paquete
    FOREIGN KEY (id_paquete) REFERENCES paquete(id_paquete);

ALTER TABLE historial_compra
    ADD CONSTRAINT fk_tipo_pago
    FOREIGN KEY (id_tipo_pago) REFERENCES tipo_pago(id_tipo_pago);

ALTER TABLE historial_compra
    ADD CONSTRAINT fk_cliente
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente);

-- Agregar clave foránea a la tabla paquete para la relación con pais

ALTER TABLE paquete
    ADD CONSTRAINT fk_pais
    FOREIGN KEY (id_pais) REFERENCES pais(id_pais);

-- Agregar clave foránea a la tabla paquete para la relación con tipo_paquete

ALTER TABLE paquete
    ADD CONSTRAINT fk_tipo_paquete
    FOREIGN KEY (id_tipo_paquete) REFERENCES tipo_paquete(id_tipo_paquete);

