CREATE SCHEMA IF NOT EXISTS pacientes;
USE pacientes;
CREATE TABLE IF NOT EXISTS encargado(
    dpi VARCHAR(15) NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    telefono VARCHAR(8) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    condicion_economica VARCHAR(50) NOT NULL,
    tipo_archivo VARCHAR(10),
    archivo BLOB,
    PRIMARY KEY(dpi)
);

CREATE TABLE IF NOT EXISTS terapista(
    dpi VARCHAR(15) NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    PRIMARY KEY(dpi)
);

CREATE TABLE IF NOT EXISTS condicion(
    nombre VARCHAR(45) NOT NULL,
    PRIMARY KEY(nombre)
);

CREATE TABLE IF NOT EXISTS paciente(
    carne INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    edad INT,
    dpi_encargado VARCHAR(15) NOT NULL,
    tipo_programa VARCHAR(20) NOT NULL,
    enfermedad_cronica VARCHAR(100) NOT NULL,
    dpi_terapista VARCHAR(15) NOT NULL,
    terapia VARCHAR(100),
    tipo_archivo VARCHAR(10),
    archivo LONGBLOB,
    horario VARCHAR(100) NOT NULL,
    condicion VARCHAR(100) NOT NULL,
    activo BOOLEAN NOT NULL,
    monto DOUBLE NOT NULL,
    PRIMARY KEY(carne),
    FOREIGN KEY(dpi_encargado) REFERENCES encargado(dpi)  ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(dpi_terapista) REFERENCES terapista(dpi)  ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS reporte(
    id INT NOT NULL AUTO_INCREMENT,
    fecha DATE NOT NULL,
    carne_paciente VARCHAR(15) NOT NULL,
    reporte VARCHAR(250) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS cuota(
    id INT NOT NULL AUTO_INCREMENT UNIQUE,
    carne INT NOT NULL,
    año VARCHAR(4) NOT NULL,
    mes VARCHAR(20) NOT NULL,
    dpi_encargado VARCHAR(15) NOT NULL,
    fecha_limite DATE NOT NULL,
    tipo_pago VARCHAR(20),
    archivo LONGBLOB,
    tipo_archivo VARCHAR(15),
    estado VARCHAR(20) NOT NULL,
    monto DOUBLE NOT NULL,
    PRIMARY KEY(carne,año,mes),
    FOREIGN KEY(dpi_encargado) REFERENCES encargado(dpi) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(carne) REFERENCES paciente(carne)
);

INSERT INTO condicion(nombre) VALUES("Autismo");
INSERT INTO condicion(nombre) VALUES("Síndrome de Down");
INSERT INTO condicion(nombre) VALUES("Retraso evolutivo");
INSERT INTO condicion(nombre) VALUES("Problemas de habla");
INSERT INTO condicion(nombre) VALUES("Parálisis parcial");
INSERT INTO condicion(nombre) VALUES("Parálisis total");
