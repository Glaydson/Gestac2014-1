CREATE TABLE `funcionarios` (
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
INSERT INTO `gestac`.`funcionarios` (`matricula`, `nome`, `deficiente`, `idUsuario`) VALUES (15, "Carlos Alberto", 0, 3);
INSERT INTO `gestac`.`funcionarios` (`matricula`, `nome`, `deficiente`, `idUsuario`) VALUES (16, "Roberto Carlos", 1, 4);
CREATE TABLE `gestac`.`funcionarioveiculos` (
  `idfuncionario` int(11) NOT NULL,
  `idveiculo` int(11) NOT NULL,
  PRIMARY KEY  (`idfuncionario`,`idveiculo`),
  KEY `fkveiculos_idx` (`idveiculo`),
  CONSTRAINT `fkveiculos` FOREIGN KEY (`idveiculo`) REFERENCES `veiculos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkfuncionario` FOREIGN KEY (`idfuncionario`) REFERENCES `funcionarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

