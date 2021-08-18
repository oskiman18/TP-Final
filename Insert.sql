INSERT INTO `utnbank`.`usuarios`(`DNI`,`CUIL`,`nombre`,`apellido`,`genero`,`direccion`,`localidad`,`provincia`,`email`,`tel`,`telAlt`,`usuario`,`contraseña`,`rango`,`estado`)
VALUES('38427808','2038427808','Oscar Alberto','Bianchi','Masculino','Java 637','Pilar','Buenos Aires','Oski@gmail.com','1122112233','','oski18','java123',1,1),
	  ('37200162','27372001629','Rocio Del Mar','Mendoza','Femenino','Java 637','Pilar','Buenos Aires','rmendoza@gmail.com','1121212233','','rmend','pichi123',1,1),
	  ('31241904','21312419043','Rodrigo Pablo','Vergara','Masculino','Viena 1275','Jose C Paz','Buenos Aires','rpvergara@gmail.com','1127812233','','rpver','sofy123',0,1),
	  ('10232906','20102329068','Oski Albert','Bianchi','Masculino','Oliden 2245','Tortuguitas','Buenos Aires','oab@gmail.com','112254233','','oab22','takuma',0,1),
      ('40082123','21400821239','Leandro Emanuel','Vergara','Masculino','Charcas 948','Jose C Paz','Buenos Aires','lev@gmail.com','1124422334','1166448899','lev06','terry',0,1),
	  ('36823121','20368231219','Sofia Natasha','Cirger','Femenino','Florida 45','Jose C Paz','Buenos Aires','snc@gmail.com','1155112233','','snc14','porito',0,1);
      
INSERT INTO `utnbank`.`cuenta` (`cliente`,`tipo`,`creacion`,`cbu`,`saldo`)
VALUES('38427808',0,now(),'487984654874',10000),
('37200162',0,now(),'321234654874',7000),
('31241904',0,now(),'447854654874',5000),
('31241904',0,now(),'421484654874',2000),
('40082123',0,now(),'466384654874',6000),
('40082123',0,now(),'479484654874',3000),
('63823121',0,now(),'454484654874',4000);
