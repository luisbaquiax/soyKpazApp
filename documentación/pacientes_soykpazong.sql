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
    carne VARCHAR(15) NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    edad INT,
    dpi_encargado VARCHAR(15) NOT NULL,
    tipo_programa VARCHAR(20) NOT NULL,
    enfermedad_cronica VARCHAR(100) NOT NULL,
    dpi_terapista VARCHAR(15) NOT NULL,
    terapia VARCHAR(100),
    tipo_archivo VARCHAR(10),
    archivo BLOB,
    horario VARCHAR(100) NOT NULL,
    PRIMARY KEY(carne),
    FOREIGN KEY(dpi_encargado) REFERENCES encargado(dpi),
    FOREIGN KEY(dpi_terapista) REFERENCES terapista(dpi)
);

CREATE TABLE IF NOT EXISTS condicion_paciente(
    carne_paciente VARCHAR(15) NOT NULL,
    nombre_condicion VARCHAR(45) NOT NULL,
    PRIMARY KEY(carne_paciente, nombre_condicion),
    FOREIGN KEY(carne_paciente) REFERENCES paciente(carne) ON UPDATE CASCADE,
    FOREIGN KEY(nombre_condicion) REFERENCES condicion(nombre) ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS reporte(
    id INT NOT NULL AUTO_INCREMENT,
    fecha DATE NOT NULL,
    carne_paciente VARCHAR(15) NOT NULL,
    reporte VARCHAR(250) NOT NULL,
    PRIMARY KEY(id)
);
INSERT INTO condicion(nombre) VALUES("Autismo");
INSERT INTO condicion(nombre) VALUES("Síndrome de Down");
INSERT INTO condicion(nombre) VALUES("Retraso evolutivo");
INSERT INTO condicion(nombre) VALUES("Problemas de habla");
INSERT INTO condicion(nombre) VALUES("Parálisis parcial");
INSERT INTO condicion(nombre) VALUES("Parálisis total");
