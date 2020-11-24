CREATE DATABASE vale;

USE vale;

CREATE TABLE users(
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(50)
);

INSERT INTO users(username,password) VALUES ('ana','0123');

CREATE TABLE objetivos(
    id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    descripcion VARCHAR(50),
    imagen VARCHAR(50)
);  
