
CREATE SCHEMA IF NOT EXISTS banco;

USE banco;

CREATE TABLE IF NOT EXISTS usuario(
usuario VARCHAR(100),
password VARCHAR(1000),
tipo VARCHAR(30),

PRIMARY KEY(usuario)
);


CREATE TABLE IF NOT EXISTS turno(
turno VARCHAR(30),
hora1 TIME NOT NULL,
hora2 TIME NOT NULL,

PRIMARY KEY(turno)
);


CREATE TABLE IF NOT EXISTS gerente(

codigo VARCHAR(100) NOT NULL,
nombre VARCHAR(100) NOT NULL,
turno VARCHAR(40) NOT NULL,
dpi VARCHAR(40) NOT NULL,
direccion VARCHAR(170) NOT NULL,
sexo VARCHAR(30) NOT NULL,
password VARCHAR(3000) NOT NULL,

PRIMARY KEY(codigo),
FOREIGN KEY(turno) REFERENCES turno(turno)
);


CREATE TABLE IF NOT EXISTS cajero(

codigo VARCHAR(100) NOT NULL,
nombre VARCHAR(100) NOT NULL,
turno VARCHAR(40) NOT NULL,
dpi VARCHAR(40) NOT NULL,
direccion VARCHAR(170) NOT NULL,
sexo VARCHAR(30) NULL,
password VARCHAR(3000) NOT NULL,

PRIMARY KEY(codigo),
FOREIGN KEY(turno) REFERENCES turno(turno)
);

CREATE TABLE IF NOT EXISTS cliente(

codigo VARCHAR(100) NOT NULL,
nombre VARCHAR(100) NOT NULL,
dpi VARCHAR(100) NOT NULL,
cumple VARCHAR(100) NOT NULL,
direccion VARCHAR(170) NOT NULL,
sexo VARCHAR(30) NOT NULL,
pathdpi LONGBLOB,
password VARCHAR(1500) NOT NULL,

PRIMARY KEY(codigo)
);

CREATE TABLE IF NOT EXISTS cuenta(
codigo INT NOT NULL AUTO_INCREMENT,
cliente VARCHAR(100) NOT NULL,
creada VARCHAR(60)  NOT NULL,
credito DOUBLE NOT NULL,

PRIMARY KEY(codigo),
FOREIGN KEY(cliente) REFERENCES cliente(codigo)

);

CREATE TABLE IF NOT EXISTS transaccion(

codigo INT NOT NULL AUTO_INCREMENT,
cuenta INT NOT NULL,
fecha VARCHAR(50) NOT NULL,
hora VARCHAR(50) NOT NULL,
tipo VARCHAR(60) NOT NULL,
monto DOUBLE NOT NULL,
cajero VARCHAR(100) NOT NULL,

PRIMARY KEY(codigo),
FOREIGN KEY(cuenta) REFERENCES cuenta(codigo),
FOREIGN KEY(cajero) REFERENCES cajero(codigo)
);

CREATE TABLE IF NOT EXISTS limites(
codigo INT NOT NULL AUTO_INCREMENT,
gerente VARCHAR(100) NOT NULL,
limite1 DOUBLE NOT NULL,
limite2 DOUBLE NOT NULL,

PRIMARY KEY(codigo),
FOREIGN KEY(gerente) REFERENCES gerente(codigo)
);

CREATE TABLE IF NOT EXISTS historial(
codigo INT NOT NULL AUTO_INCREMENT,
cuenta INT NOT NULL,
transaccion INT NOT NULL,
fecha DATE NOT NULL,
hora VARCHAR(25) NOT NULL,
credito DOUBLE,
debito DOUBLE,
total DOUBLE NOT NULL,

PRIMARY KEY(codigo),
FOREIGN KEY(cuenta) REFERENCES cuenta(codigo),
FOREIGN KEY(transaccion) REFERENCES transaccion(codigo)
);

CREATE TABLE IF NOT EXISTS historial_cambio(
codigo INT AUTO_INCREMENT NOT NULL,
usuario  VARCHAR(150) NOT NULL,
nombre VARCHAR (150) NOT NULL,
turno VARCHAR(40),
cumple VARCHAR(50),
pathdpi VARCHAR(180),
dpi VARCHAR(40),
direccion VARCHAR(200),
sexo VARCHAR(30),
fecha VARCHAR(45),
gerenteID varchar(110),

PRIMARY KEY(codigo),
FOREIGN KEY(usuario) REFERENCES usuario(usuario)
);

CREATE TABLE IF NOT EXISTS asociacion(
codigo INT NOT NULL AUTO_INCREMENT,
cliente VARCHAR(100) NOT NULL,
clienteRe VARCHAR(100),
cuenta INT NOT NULL,
estado VARCHAR(100) NOT NULL,

PRIMARY KEY(codigo,cliente,cuenta),
FOREIGN KEY(cuenta) REFERENCES cuenta(codigo),
FOREIGN KEY(cliente) REFERENCES cliente(codigo)
);


INSERT INTO `banco`.`turno` (`turno`, `hora1`, `hora2`) VALUES ('MATUTINO', '6:00:00', '14:00:00');
INSERT INTO `banco`.`turno` (`turno`, `hora1`, `hora2`) VALUES ('VESPERTINO', '14:00:00', '22:00:00');
INSERT INTO `banco`.`turno` (`turno`, `hora1`, `hora2`) VALUES ('TODAHORA', '00:00:00', '24:00:00');
INSERT INTO `banco`.`turno` (`turno`, `hora1`, `hora2`) VALUES ('FULL', '00:00:00', '24:00:00');