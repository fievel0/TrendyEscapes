CREATE TABLE Cliente (
    Id_C INT PRIMARY KEY IDENTITY,
    Id_Tipodocumento INT,
    Id_Pais INT,
    Id_FormaPago INT,
    Name NVARCHAR(100),
    NumDocumento NVARCHAR(50),
    Fecha_Nacimiento DATETIME,
    Age INT,
    adres NVARCHAR(255),
    Phone NVARCHAR(50),
    mail NVARCHAR(100)
);

--despues de crear autenticacion --

ALTER TABLE Cliente
ADD Id_Autenticacion INT;

ALTER TABLE Cliente
ADD FOREIGN KEY (Id_Autenticacion) REFERENCES Autenticacion(Id_Autenticacion);

