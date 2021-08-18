drop database utnbank;
USE utnbank;

CREATE TABLE `usuarios` (
  `DNI` varchar(8) NOT NULL,
  `CUIL` varchar(20) NOT NULL UNIQUE,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `genero` varchar(10) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `localidad` varchar(100) NOT NULL,
  `provincia` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL UNIQUE,
  `tel` varchar(20) NOT NULL,
  `telAlt` varchar(20) DEFAULT NULL,
  `usuario` varchar(50) NOT NULL UNIQUE,
  `contraseña` varchar(50) NOT NULL,
  `rango` tinyint(1) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`DNI`)
) ;

CREATE TABLE `cuenta` (
  `cliente` varchar(8) NOT NULL,
  `tipo` tinyint(1) NOT NULL,
  `creacion` date NOT NULL,
  `NCuenta` smallint NOT NULL AUTO_INCREMENT,
  `cbu` varchar(30) NOT NULL UNIQUE,
  `saldo` float NOT NULL,
  PRIMARY KEY (`NCuenta`),
  KEY `cliente` (`cliente`),
  FOREIGN KEY (`cliente`) REFERENCES `usuarios` (`DNI`)
);

CREATE TABLE movimientos(
id INT AUTO_INCREMENT not null,
fecha DATE not null,
detalle varchar(30) not null,
importe float not null,
tipo tinyint(1) not null,
NCO smallint not null,
NCD smallint not null,
PRIMARY KEY (id),
CONSTRAINT `FK_NCO` FOREIGN KEY (`NCO`) REFERENCES `cuenta` (`NCuenta`),
CONSTRAINT `FK_NCD` FOREIGN KEY (`NCD`) REFERENCES `cuenta` (`NCuenta`)
);

CREATE PROCEDURE SP_Report()
BEGIN 
Select count(DNI) as 'Usuarios Activos', 
(select count(dni) where estado = 0) as 'Usuario Inactivos',
(select count(id) from movimientos) as 'transferencias',
(select SUM(saldo) from cuenta) as 'Saldo Total',
(select count(ncuenta)from cuenta) as 'Cuentas Totales',
(select count(tipo) from Cuenta where tipo=1) as 'Cuentas Corrientes',
(select count(tipo) from Cuenta where tipo=0) as 'Cajas de Ahorro' ,
(select avg(importe) from movimientos) as 'Monto Promedio Transferencia'
from usuarios as u where estado =1
END

select * from cuenta
select * from movimientos

