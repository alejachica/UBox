-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema centralizador
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema centralizador
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `centralizador` DEFAULT CHARACTER SET utf8 ;
USE `centralizador` ;

-- -----------------------------------------------------
-- Table `centralizador`.`CONTRATO_OPERADOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `centralizador`.`CONTRATO_OPERADOR` ;

CREATE TABLE IF NOT EXISTS `centralizador`.`CONTRATO_OPERADOR` (
  `id_operador` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nro_contrato` DECIMAL(10,2) NOT NULL COMMENT '',
  `fecha_inicio` DATE NOT NULL COMMENT '',
  `fecha_fin` DATE NULL DEFAULT NULL COMMENT '',
  `estado` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`nro_contrato`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_operador_idx` ON `centralizador`.`CONTRATO_OPERADOR` (`id_operador` ASC)  COMMENT '';


-- -----------------------------------------------------
-- Table `centralizador`.`ZONA_GEOGRAFICA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `centralizador`.`ZONA_GEOGRAFICA` ;

CREATE TABLE IF NOT EXISTS `centralizador`.`ZONA_GEOGRAFICA` (
  `id_zona_geografica` INT(11) NOT NULL COMMENT '',
  `nombre` VARCHAR(50) NOT NULL COMMENT '',
  `id_padre` INT(11) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_zona_geografica`)  COMMENT '',
  CONSTRAINT `fk_padre`
    FOREIGN KEY (`id_padre`)
    REFERENCES `centralizador`.`ZONA_GEOGRAFICA` (`id_zona_geografica`)
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_padre_idx` ON `centralizador`.`ZONA_GEOGRAFICA` (`id_padre` ASC)  COMMENT '';


-- -----------------------------------------------------
-- Table `centralizador`.`OPERADOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `centralizador`.`OPERADOR` ;

CREATE TABLE IF NOT EXISTS `centralizador`.`OPERADOR` (
  `id_operador` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nit` VARCHAR(50) NOT NULL COMMENT '',
  `razon_social` VARCHAR(50) NOT NULL COMMENT '',
  `direccion` VARCHAR(50) NULL DEFAULT NULL COMMENT '',
  `telefono` VARCHAR(50) NULL DEFAULT NULL COMMENT '',
  `email` VARCHAR(50) NOT NULL COMMENT '',
  PRIMARY KEY (`id_operador`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `UQ_OPERADOR_id_operador` ON `centralizador`.`OPERADOR` (`id_operador` ASC)  COMMENT '';


-- -----------------------------------------------------
-- Table `centralizador`.`USUARIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `centralizador`.`USUARIO` ;

CREATE TABLE IF NOT EXISTS `centralizador`.`USUARIO` (
  `id_usuario` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `id_tipo_identificacion` VARCHAR(50) NOT NULL COMMENT '',
  `nro_identificacion` VARCHAR(50) NOT NULL COMMENT '',
  `id_municipio_expedicion_identificacion` INT(11) NULL DEFAULT NULL COMMENT '',
  `fecha_expediciion_identificacion` DATE NULL DEFAULT NULL COMMENT '',
  `primer_apellido` VARCHAR(50) NOT NULL COMMENT '',
  `segundo_apellido` VARCHAR(50) NULL DEFAULT NULL COMMENT '',
  `primer_nombre` VARCHAR(50) NOT NULL COMMENT '',
  `segundo_nombre` VARCHAR(50) NULL DEFAULT NULL COMMENT '',
  `genero` VARCHAR(2) NOT NULL COMMENT '',
  `fecha_nacimiento` DATE NOT NULL COMMENT '',
  `id_municipio_nacimiento` INT(11) NOT NULL COMMENT '',
  `id_nacionalidad` INT(11) NOT NULL COMMENT '',
  `id_municipio_residencia` INT(11) NOT NULL COMMENT '',
  `id_direccion_residencia` VARCHAR(50) NOT NULL COMMENT '',
  `direccion_notificacion` VARCHAR(50) NOT NULL COMMENT '',
  `id_municipio_notificacion` INT(11) NOT NULL COMMENT '',
  `telefono` INT(11) NOT NULL COMMENT '',
  `email_personal` VARCHAR(50) NULL DEFAULT NULL COMMENT '',
  `id_municipio_laboral` INT(11) NOT NULL COMMENT '',
  `id_estado_civil` INT(11) NOT NULL COMMENT '',
  `id_operador_actual` INT(11) NULL DEFAULT NULL COMMENT '',
  `id_operador` INT(11) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_usuario`)  COMMENT '',
  CONSTRAINT `fk_municipio_Expedicion`
    FOREIGN KEY (`id_municipio_expedicion_identificacion`)
    REFERENCES `centralizador`.`ZONA_GEOGRAFICA` (`id_zona_geografica`)
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_municipio_laboral`
    FOREIGN KEY (`id_municipio_laboral`)
    REFERENCES `centralizador`.`ZONA_GEOGRAFICA` (`id_zona_geografica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_municipio_nacimiento`
    FOREIGN KEY (`id_municipio_nacimiento`)
    REFERENCES `centralizador`.`ZONA_GEOGRAFICA` (`id_zona_geografica`)
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_municipio_notificacion`
    FOREIGN KEY (`id_municipio_notificacion`)
    REFERENCES `centralizador`.`ZONA_GEOGRAFICA` (`id_zona_geografica`)
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_municipio_residencia`
    FOREIGN KEY (`id_municipio_residencia`)
    REFERENCES `centralizador`.`ZONA_GEOGRAFICA` (`id_zona_geografica`)
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_operador`
    FOREIGN KEY (`id_operador_actual`)
    REFERENCES `centralizador`.`OPERADOR` (`id_operador`)
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `constraint1` ON `centralizador`.`USUARIO` (`id_tipo_identificacion` ASC, `nro_identificacion` ASC)  COMMENT '';

CREATE INDEX `IXFK_USUARIO_OPERADOR` ON `centralizador`.`USUARIO` (`id_operador_actual` ASC)  COMMENT '';

CREATE INDEX `IXFK_USUARIO_OPERADOR_02` ON `centralizador`.`USUARIO` (`id_operador` ASC)  COMMENT '';

CREATE INDEX `fk_municipio_nacimiento_idx` ON `centralizador`.`USUARIO` (`id_municipio_nacimiento` ASC)  COMMENT '';

CREATE INDEX `fk_municipio_Expedicion_idx` ON `centralizador`.`USUARIO` (`id_municipio_expedicion_identificacion` ASC)  COMMENT '';

CREATE INDEX `fk_municipio_residencia_idx` ON `centralizador`.`USUARIO` (`id_municipio_residencia` ASC)  COMMENT '';

CREATE INDEX `fk_municipio_notificacion_idx` ON `centralizador`.`USUARIO` (`id_municipio_notificacion` ASC)  COMMENT '';

CREATE INDEX `fk_municipio_laboral_idx` ON `centralizador`.`USUARIO` (`id_municipio_laboral` ASC)  COMMENT '';


-- -----------------------------------------------------
-- Table `centralizador`.`HISTORICO_OPERADORES_USUARIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `centralizador`.`HISTORICO_OPERADORES_USUARIO` ;

CREATE TABLE IF NOT EXISTS `centralizador`.`HISTORICO_OPERADORES_USUARIO` (
  `id_usuario` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `id_operador_origen` INT(11) NOT NULL COMMENT '',
  `fecha` DATE NOT NULL COMMENT '',
  `id_historico` INT(11) NOT NULL COMMENT '',
  `id_operador_destino` INT(11) NULL DEFAULT NULL COMMENT '',
  `id_tipo_operacion` INT(11) NOT NULL COMMENT '',
  `num_formulario` VARCHAR(50) NOT NULL COMMENT '',
  CONSTRAINT `fk_usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `centralizador`.`USUARIO` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_operador_Destino`
    FOREIGN KEY (`id_operador_destino`)
    REFERENCES `centralizador`.`OPERADOR` (`id_operador`)
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_operador_original`
    FOREIGN KEY (`id_operador_origen`)
    REFERENCES `centralizador`.`OPERADOR` (`id_operador`)
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_operador_idx` ON `centralizador`.`HISTORICO_OPERADORES_USUARIO` (`id_operador_origen` ASC)  COMMENT '';

CREATE INDEX `fk_usuario_idx` ON `centralizador`.`HISTORICO_OPERADORES_USUARIO` (`id_usuario` ASC)  COMMENT '';

CREATE INDEX `fk_operador_Destino_idx` ON `centralizador`.`HISTORICO_OPERADORES_USUARIO` (`id_operador_destino` ASC)  COMMENT '';


-- -----------------------------------------------------
-- Table `centralizador`.`LISTA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `centralizador`.`LISTA` ;

CREATE TABLE IF NOT EXISTS `centralizador`.`LISTA` (
  `id_lista` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nombre` VARCHAR(50) NOT NULL COMMENT '',
  `activo` TINYINT(1) NULL DEFAULT NULL COMMENT '',
  `descripcion` VARCHAR(256) NOT NULL COMMENT '',
  PRIMARY KEY (`id_lista`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `centralizador`.`MUNICIPIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `centralizador`.`MUNICIPIO` ;

CREATE TABLE IF NOT EXISTS `centralizador`.`MUNICIPIO` (
  `ID_DEPARTAMENTO` DECIMAL(10,0) NOT NULL COMMENT '',
  `DEPARTAMENTO` VARCHAR(50) NULL DEFAULT NULL COMMENT '',
  `ID_MUNICIPIO` DECIMAL(10,0) NOT NULL COMMENT '',
  `MUNICIPIO` VARCHAR(50) NULL DEFAULT NULL COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `centralizador`.`SERVICIOS_OPERADOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `centralizador`.`SERVICIOS_OPERADOR` ;

CREATE TABLE IF NOT EXISTS `centralizador`.`SERVICIOS_OPERADOR` (
  `id_servicio_operador` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `id_operador` INT(11) NOT NULL COMMENT '',
  `url` VARCHAR(50) NOT NULL COMMENT '',
  `id_tipo_servicio` INT(11) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_servicio_operador`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_operador_idx` ON `centralizador`.`SERVICIOS_OPERADOR` (`id_operador` ASC)  COMMENT '';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
