CREATE TABLE historial_compra (
    id_historial bigserial,
    id_paquete bigint NOT NULL,
    id_tipo_pago bigint NOT NULL,
    id_cliente bigint NOT NULL,
    PRIMARY KEY(id_historial)
);