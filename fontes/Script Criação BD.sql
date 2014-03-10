/* APAGA O SCHEMA */
DROP DATABASE `gestac`;
/* CRIAÇÃO DO BANCO DE DADOS GESTAC */
CREATE DATABASE `gestac` /*!40100 DEFAULT CHARACTER SET utf8 */;
/* CRIAÇÃO DA TABELA TIPOVAGA */
CREATE TABLE `gestac`.`tipovaga` (
  `idTipoVaga` int(11) NOT NULL,
  `nome` varchar(11) default NULL,
  PRIMARY KEY  (`idTipoVaga`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/* PREENCHIMENTO DA TABELA TIPOVAGA */
INSERT INTO `gestac`.`tipovaga` (`idTipoVaga`,`nome`) VALUES (1,'DEFICIENTE');
INSERT INTO `gestac`.`tipovaga` (`idTipoVaga`,`nome`) VALUES (2,'EMPRESA');
INSERT INTO `gestac`.`tipovaga` (`idTipoVaga`,`nome`) VALUES (3,'FUNCIONÁRIO');
/*  CRIAÇÃO DA TABELA DE VAGAS  */
CREATE TABLE `gestac`.`vagas` (
  `numero` int(11) NOT NULL auto_increment,
  `livre` tinyint(4) NOT NULL,
  `tipovaga` int(11) NOT NULL,
  PRIMARY KEY  (`numero`),
  KEY `TipoVaga_idx` (`tipovaga`),
  CONSTRAINT `TipoVaga` FOREIGN KEY (`tipovaga`) REFERENCES `tipovaga` (`idTipoVaga`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/* PREENCHIMENTO DA TABELA DE VAGAS   */
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (1,0,1);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (2,0,1);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (3,0,1);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (4,0,1);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (5,0,1);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (6,0,1);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (7,0,1);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (8,0,1);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (9,0,1);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (10,0,1);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (11,0,2);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (12,0,2);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (13,0,2);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (14,0,2);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (15,0,2);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (16,0,2);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (17,0,2);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (18,0,2);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (19,0,2);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (20,0,2);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (21,0,2);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (22,0,2);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (23,0,2);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (24,0,2);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (25,0,2);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (26,0,3);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (27,0,3);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (28,0,3);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (29,0,3);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (30,0,3);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (31,0,3);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (32,0,3);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (33,0,3);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (34,0,3);
INSERT INTO `gestac`.`vagas` (`numero`,`livre`,`tipovaga`) VALUES (35,0,3);
/* CRIAÇÃO DA TABELA TIPOUSUARIO */
CREATE TABLE `gestac`.`tipousuario` (
  `idtipousuario` int(11) NOT NULL,
  `nome` varchar(15) NOT NULL,
  PRIMARY KEY  (`idtipousuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/* PREENCHIMENTO DA TABELA TIPOUSUARIO */
INSERT INTO `gestac`.`tipousuario` (`idtipousuario`, `nome`) VALUES ('1', 'ADMINISTRATIVO');
INSERT INTO `gestac`.`tipousuario` (`idtipousuario`, `nome`) VALUES ('2', 'FUNCIONÁRIO');
INSERT INTO `gestac`.`tipousuario` (`idtipousuario`, `nome`) VALUES ('3', 'GESTOR');
/* CRIAÇÃO DA TABELA USUARIOS */
CREATE TABLE `gestac`.`usuarios` (
  `id` int(11) NOT NULL auto_increment,
  `login` varchar(10) NOT NULL,
  `senha` varchar(10) NOT NULL,
  `tipoUsuario` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  KEY `tipousuario_idx` (`tipoUsuario`),
  CONSTRAINT `tipousuario` FOREIGN KEY (`tipoUsuario`) REFERENCES `tipousuario` (`idtipousuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/* PREENCHIMENTO DA TABELA DE USUÁRIOS */
INSERT INTO `gestac`.`usuarios` (`login`,`senha`,`tipoUsuario`) VALUES ('adm1', '123',1);
INSERT INTO `gestac`.`usuarios` (`login`,`senha`,`tipoUsuario`) VALUES ('adm2', '123',1);
INSERT INTO `gestac`.`usuarios` (`login`,`senha`,`tipoUsuario`) VALUES ('funci1', '123',2);
INSERT INTO `gestac`.`usuarios` (`login`,`senha`,`tipoUsuario`) VALUES ('funci2', '123',2);
INSERT INTO `gestac`.`usuarios` (`login`,`senha`,`tipoUsuario`) VALUES ('gestor1', '123',3);
INSERT INTO `gestac`.`usuarios` (`login`,`senha`,`tipoUsuario`) VALUES ('gestor2', '123',3);
/*CRIAÇÃO DA TABELA MARCAS */
CREATE TABLE `gestac`.`marcas` (
  `id` int(11) NOT NULL auto_increment,
  `nome` varchar(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/* PREENCHIMENTO DA TABELA DE MARCAS */
INSERT INTO `gestac`.`marcas`(`nome`) VALUES('Chevrolet');
INSERT INTO `gestac`.`marcas`(`nome`) VALUES('Citroen');
INSERT INTO `gestac`.`marcas`(`nome`) VALUES('Fiat');
INSERT INTO `gestac`.`marcas`(`nome`) VALUES('Ford');
INSERT INTO `gestac`.`marcas`(`nome`) VALUES('Kia');
INSERT INTO `gestac`.`marcas`(`nome`) VALUES('Renault');
INSERT INTO `gestac`.`marcas`(`nome`) VALUES('Volkswagen');
/* CRIAÇÃO DA TABELA MODELOS */
CREATE TABLE `gestac`.`modelos` (
  `id` int(11) NOT NULL auto_increment,
  `nome` varchar(20) NOT NULL,
  `marca` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `marca_idx` (`marca`),
  CONSTRAINT `marca` FOREIGN KEY (`marca`) REFERENCES `marcas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/* PREENCHIMENTO DA TABELA MODELOS */
INSERT INTO `gestac`.`modelos`(`nome`, `marca`) VALUES ('Corsa', 1);
INSERT INTO `gestac`.`modelos`(`nome`, `marca`) VALUES ('Cobalt', 1);
INSERT INTO `gestac`.`modelos`(`nome`, `marca`) VALUES ('Prisma', 1);
INSERT INTO `gestac`.`modelos`(`nome`, `marca`) VALUES ('Cruze', 1);
INSERT INTO `gestac`.`modelos`(`nome`, `marca`) VALUES ('C3', 2);
INSERT INTO `gestac`.`modelos`(`nome`, `marca`) VALUES ('AirCross', 2);
INSERT INTO `gestac`.`modelos`(`nome`, `marca`) VALUES ('Palio', 3);
INSERT INTO `gestac`.`modelos`(`nome`, `marca`) VALUES ('Siena', 3);
INSERT INTO `gestac`.`modelos`(`nome`, `marca`) VALUES ('Punto', 3);
INSERT INTO `gestac`.`modelos`(`nome`, `marca`) VALUES ('Fiesta', 4);
INSERT INTO `gestac`.`modelos`(`nome`, `marca`) VALUES ('Ka', 4);
INSERT INTO `gestac`.`modelos`(`nome`, `marca`) VALUES ('Picanto', 5);
INSERT INTO `gestac`.`modelos`(`nome`, `marca`) VALUES ('Sportage', 5);
INSERT INTO `gestac`.`modelos`(`nome`, `marca`) VALUES ('Logan', 6);
INSERT INTO `gestac`.`modelos`(`nome`, `marca`) VALUES ('Sandero', 6);
INSERT INTO `gestac`.`modelos`(`nome`, `marca`) VALUES ('Duster', 6);
INSERT INTO `gestac`.`modelos`(`nome`, `marca`) VALUES ('Gol', 7);
INSERT INTO `gestac`.`modelos`(`nome`, `marca`) VALUES ('Fox', 7);
INSERT INTO `gestac`.`modelos`(`nome`, `marca`) VALUES ('Up', 7);
/* CRIAÇÃO DA TABELA VEÍCULOS */
CREATE TABLE `gestac`.`veiculos` (
  `id` int(11) NOT NULL auto_increment,
  `placa` varchar(7) NOT NULL,
  `cor` varchar(20) NOT NULL,
  `tipo` varchar(1) NOT NULL,
  `modelo` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `placa_UNIQUE` (`placa`),
  KEY `modelo_idx` (`modelo`),
  CONSTRAINT `modelo` FOREIGN KEY (`modelo`) REFERENCES `modelos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/* CRIAÇÃO DA TABELA FUNCIONÁRIOS */
CREATE TABLE `gestac`.`funcionarios` (
  `id` int(11) NOT NULL auto_increment,
  `matricula` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `deficiente` tinyint(4) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fkusuario_idx` (`idUsuario`),
  CONSTRAINT `fkusuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/* PREENCHIMENTO DA TABELA FUNCIONARIOS */
INSERT INTO `gestac`.`funcionarios` (`matricula`, `nome`, `deficiente`, `idUsuario`) VALUES (15, "Carlos Alberto", 0, 3);
INSERT INTO `gestac`.`funcionarios` (`matricula`, `nome`, `deficiente`, `idUsuario`) VALUES (16, "Roberto Carlos", 1, 4);
/* CRIAÇÃO DA TABELA FUNCIONARIOVEICULOS */
CREATE TABLE `gestac`.`funcionarioveiculos` (
  `idfuncionario` int(11) NOT NULL,
  `idveiculo` int(11) NOT NULL,
  PRIMARY KEY  (`idfuncionario`,`idveiculo`),
  KEY `fkveiculos_idx` (`idveiculo`),
  CONSTRAINT `fkveiculos` FOREIGN KEY (`idveiculo`) REFERENCES `veiculos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkfuncionario` FOREIGN KEY (`idfuncionario`) REFERENCES `funcionarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



