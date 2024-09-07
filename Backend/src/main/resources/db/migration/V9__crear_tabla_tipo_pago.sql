CREATE TABLE Tipo_pago (
    id_historial bigint,
    id_cliente bigint,
    id_tipo_pago bigserial,
    nombre_tp VARCHAR(100),
    PRIMARY KEY(id_tipo_pago)
);