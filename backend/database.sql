CREATE DATABASE vale;

USE vale;

CREATE TABLE users(
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(50)
);

INSERT INTO users(username,password) VALUES ('david','0123');

CREATE TABLE objetivos(
    id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    descripcion VARCHAR(50),
    imagen VARCHAR(50)
);



/*

CREATE TABLE reposiciones(
    matricula INT(5),
    fecha DATE,
    expediente VARCHAR(10),
    entregadoPor VARCHAR(30),
    idCalle INT(5),
    numCalle VARCHAR(10),
    idActividad VARCHAR(3),
    numOrden VARCHAR(6),
    causa VARCHAR(50),
    DNIS VARCHAR(10),
    receptor VARCHAR(25),
    DNIR VARCHAR(10),
    asignatario VARCHAR(25),
    DNIA VARCHAR(10),
    FOREIGN KEY (matricula) REFERENCES contenedores(matricula)
);

CREATE TABLE bajas(
    matricula INT(5),
    fechabaja DATE,
    causa VARCHAR(15),
    expediente VARCHAR(300),
    observaciones VARCHAR(300),
    FOREIGN KEY (matricula) REFERENCES contenedores(matricula)
);

CREATE TABLE pedidos(
    capacidad INT(3),
    cantidad INT(5)
);

CREATE TABLE stock(
    capacidad INT(3) NOT NULL,
    cantidad INT(5) NOT NULL,
    fecha DATE
);

CREATE TABLE certificacion(
    capacidad INT(3) NOT NULL,
    cantidad INT(5) NOT NULL
);

INSERT INTO certificacion(capacidad, cantidad) VALUES (120,0);
INSERT INTO certificacion(capacidad, cantidad) VALUES (240,0);
INSERT INTO certificacion(capacidad, cantidad) VALUES (360,0);
INSERT INTO certificacion(capacidad, cantidad) VALUES (800,0);
INSERT INTO certificacion(capacidad, cantidad) VALUES (1000,0);

CREATE TABLE calles(
    codigo INT(6),
    denominacion VARCHAR(50)
);

CREATE TABLE numberpdf(
    numberpdf INT(5) AUTO_INCREMENT PRIMARY KEY
);

INSERT INTO numberpdf VALUES (0);
*/