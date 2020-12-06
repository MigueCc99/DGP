CREATE DATABASE vale;

USE vale;
-- *****************************************************************************
CREATE TABLE facilitadores(
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    contrasena VARCHAR(50) NOT NULL,
    centro BOOLEAN NOT NULL,
    correo VARCHAR(50) NOT NULL PRIMARY KEY,
    telefono VARCHAR(50) NOT NULL,
    nacimiento VARCHAR(50)
);

CREATE TABLE socios(
    id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    nacimiento VARCHAR(50),
    contrasena VARCHAR(50)
);

CREATE TABLE objetivos(
    id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(50),
    imagen VARCHAR(50)
);  

CREATE TABLE actividades(
    id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(50),
    imagen VARCHAR(50),
    multimedia VARCHAR(50)
);

CREATE TABLE actividad_pertenece_objetivo(
    id_actividad INT(11) REFERENCES actividades(id) ON DELETE CASCADE,
    id_objetivo INT(11) REFERENCES objetivos(id) ON DELETE CASCADE,
    PRIMARY KEY(id_objetivo,id_actividad)
);

CREATE TABLE actividad_asignada_socio(
    id_actividad INT(11) REFERENCES actividad(id) ON DELETE CASCADE,
    id_socio INT(11) REFERENCES socio(id) ON DELETE CASCADE,
    solucion_texto VARCHAR(200),
    multimedia_solucion MEDIUMBLOB,
    aceptada BOOLEAN,
    es_util BOOLEAN,
    es_dificil BOOLEAN,
    es_gustado BOOLEAN,
    comentario VARCHAR(200),
    PRIMARY KEY (id_actividad, id_socio)
);

-- *****************************************************************************
INSERT INTO facilitadores(nombre,apellidos,contrasena,centro,correo,telefono,nacimiento) VALUES ('david','baez','0123',false,'david@vale.org','612345678','23/07/1995');
INSERT INTO facilitadores(nombre,apellidos,contrasena,centro,correo,telefono,nacimiento) VALUES ('ana','baez','0123',true,'ana@vale.org','612345678','23/07/1995');

INSERT INTO objetivos(nombre,descripcion) VALUES ('Matemáticas', 'Desarrollar habilidades matemáticas para el manejo de situaciones de la vida cotidiana');
INSERT INTO objetivos(nombre,descripcion) VALUES ('Inglés', 'Hablar y entender inglés correctamente');
INSERT INTO objetivos(nombre,descripcion) VALUES ('Vida adulta', 'Independencia para poder vivir sin necesitar a nadie');
INSERT INTO objetivos(nombre,descripcion) VALUES ('Comunicación', 'Hablar en voz alta delante de un público y en situaciones de la vida real');
INSERT INTO objetivos(nombre,descripcion) VALUES ('Cocina', 'Desarrollar habilidades para mezclar ingredientes y usar utensilios básicos de cocina');
INSERT INTO objetivos(nombre,descripcion) VALUES ('Música', 'Aprender a diferenciar los instrumentos y a tocar uno');
INSERT INTO objetivos(nombre,descripcion) VALUES ('Ofimática', 'Habilidades para manejar programas básicos del ordenador');
INSERT INTO objetivos(nombre,descripcion) VALUES ('Dibujo', 'Habilidades para distinguir figuras y dibujar objetos simples para crear escenas');
INSERT INTO objetivos(nombre,descripcion) VALUES ('Deporte', 'Habilidad para jugar a deportes de equipo y constancia constatada');
INSERT INTO objetivos(nombre,descripcion) VALUES ('Lectura', 'Constancia para leer todos los días y uso de diccionario');
INSERT INTO objetivos(nombre,descripcion) VALUES ('Meditación', 'Poder tranquilizarse en situaciones de presión');

INSERT INTO actividades(nombre,descripcion) VALUES ('Lavarse las manos', 'Debes lavarte las manos que está el coronavirus');
INSERT INTO actividades(nombre,descripcion) VALUES ('Hacerse la cama', 'Debes hacerte la cama todos los días al levantarte');
INSERT INTO actividades(nombre,descripcion) VALUES ('Sacar a pasear al perro', 'Debes sacar a pasear al perro todos los días');
INSERT INTO actividades(nombre,descripcion) VALUES ('Ir a comprar', 'Debes hacer la compra de tu casa');
INSERT INTO actividades(nombre,descripcion) VALUES ('Beber 2 litros de agua', 'Debes beber agua para estar hidratado');
INSERT INTO actividades(nombre,descripcion) VALUES ('Leer un libro', 'Debes leer todos los días 30 minutos el libro que te guste');
INSERT INTO actividades(nombre,descripcion) VALUES ('Hacer un dibujo de tu familia', 'Debes pintar y colorear en una cartulina a tu familia');
INSERT INTO actividades(nombre,descripcion) VALUES ('Hacer una foto de tu lugar favorito', 'Debes sacar una foto, por ejemplo con el móvil');
INSERT INTO actividades(nombre,descripcion) VALUES ('Ver una película en inglés', 'Debes seleccionar el idioma: inglés/English. Puedes activar los subtítulos si lo necesitas');
INSERT INTO actividades(nombre,descripcion) VALUES ('Hacer una videollamada con tu mejor amigo', 'Debes llamar a tu mejor amigo porque hay que cuidarlo');
INSERT INTO actividades(nombre,descripcion) VALUES ('Hacer un dibujo con el programa: paint', 'Debes abrir tu ordenador y usar el programa ');

INSERT INTO actividad_pertenece_objetivo (id_actividad,id_objetivo) VALUES ('4','1');
INSERT INTO actividad_pertenece_objetivo (id_actividad,id_objetivo) VALUES ('9','2');
INSERT INTO actividad_pertenece_objetivo (id_actividad,id_objetivo) VALUES ('1','3');
INSERT INTO actividad_pertenece_objetivo (id_actividad,id_objetivo) VALUES ('2','3');
INSERT INTO actividad_pertenece_objetivo (id_actividad,id_objetivo) VALUES ('3','3');
INSERT INTO actividad_pertenece_objetivo (id_actividad,id_objetivo) VALUES ('4','3');
INSERT INTO actividad_pertenece_objetivo (id_actividad,id_objetivo) VALUES ('5','3');
INSERT INTO actividad_pertenece_objetivo (id_actividad,id_objetivo) VALUES ('4','4');
INSERT INTO actividad_pertenece_objetivo (id_actividad,id_objetivo) VALUES ('10','4');
INSERT INTO actividad_pertenece_objetivo (id_actividad,id_objetivo) VALUES ('4','5');
INSERT INTO actividad_pertenece_objetivo (id_actividad,id_objetivo) VALUES ('10','7');
INSERT INTO actividad_pertenece_objetivo (id_actividad,id_objetivo) VALUES ('11','7');
INSERT INTO actividad_pertenece_objetivo (id_actividad,id_objetivo) VALUES ('11','8');

INSERT INTO actividad_asignada_socio (id_actividad, id_socio, aceptada) VALUES ('1','1', 'false');
INSERT INTO actividad_asignada_socio (id_actividad, id_socio, aceptada) VALUES ('2','1', 'false');
INSERT INTO actividad_asignada_socio (id_actividad, id_socio, aceptada) VALUES ('3','1', 'false');
INSERT INTO actividad_asignada_socio (id_actividad, id_socio, aceptada) VALUES ('4','1', 'false');
INSERT INTO actividad_asignada_socio (id_actividad, id_socio, aceptada) VALUES ('5','1', 'false');
INSERT INTO actividad_asignada_socio (id_actividad, id_socio, aceptada) VALUES ('5','2', 'false');
INSERT INTO actividad_asignada_socio (id_actividad, id_socio, aceptada) VALUES ('2','2', 'false');



