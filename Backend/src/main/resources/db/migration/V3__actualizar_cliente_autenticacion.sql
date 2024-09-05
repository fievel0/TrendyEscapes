ALTER TABLE Cliente
ADD CONSTRAINT fk_cliente_autenticacion
FOREIGN KEY (id_autenticacion) REFERENCES Autenticacion(id_auth);