CREATE TABLE usuarios (
                          id      VARCHAR(255) PRIMARY KEY,
                          nombre VARCHAR(255) NOT NULL,
                          apellidoPaterno VARCHAR(255) NOT NULL,
                          apellidoMaterno VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL,
                          password VARCHAR(255) NOT NULL,
                          usuario VARCHAR(255) NOT NULL
);