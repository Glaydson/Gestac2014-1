CREATE TABLE `gestac`.`funcionarios` (
  `idfuncionarios` INT NOT NULL AUTO_INCREMENT,
  `matricula` INT NULL,
  `nome` VARCHAR(45) NULL,
  `deficiente` VARCHAR(45) NULL,
  PRIMARY KEY (`idfuncionarios`),
  UNIQUE INDEX `idfuncionarios_UNIQUE` (`idfuncionarios` ASC));