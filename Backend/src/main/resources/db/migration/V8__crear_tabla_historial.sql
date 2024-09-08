CREATE TABLE Historial (
    id_historial bigserial,

    id_paquete bigint,
    id_pago bigint,
    id_cliente bigint,
    
    PRIMARY KEY(id_historial)
);