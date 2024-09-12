CREATE TABLE Autenticacion (
    Id_Autenticacion INT PRIMARY KEY IDENTITY,
    Id_C INT,
    UserName NVARCHAR(100),
    Password NVARCHAR(100)
);

ALTER TABLE Autenticacion
ADD FOREIGN KEY (Id_C) REFERENCES Cliente(Id_C);
