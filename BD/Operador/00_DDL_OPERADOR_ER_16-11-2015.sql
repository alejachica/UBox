-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ubox
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ubox`;
-- -----------------------------------------------------
-- Schema ubox
-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `ubox` DEFAULT CHARACTER SET utf8 ;
USE `ubox` ;

-- -----------------------------------------------------
-- Table `ubox`.`Forma_Comparticion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ubox`.`Forma_Comparticion` (
  `id_forma_comparticion` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nombre` VARCHAR(45) NOT NULL COMMENT '',
  `descripcion` VARCHAR(200) NOT NULL COMMENT '',
  `mismoubox` TINYINT(1) NULL DEFAULT NULL COMMENT '',
  `entreuboxes` TINYINT(1) NULL DEFAULT NULL COMMENT '',
  `entidadesPublicasaUsuario` TINYINT(1) NULL DEFAULT NULL COMMENT '',
  `entidadesPrivadasaUsuario` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `simple` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_forma_comparticion`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ubox`.`ZONA_GEOGRAFICA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ubox`.`ZONA_GEOGRAFICA` (
  `id_zona_geografica` INT(11) NOT NULL COMMENT '',
  `nombre` VARCHAR(50) NOT NULL COMMENT '',
  `id_padre` INT(11) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_zona_geografica`)  COMMENT '',
  INDEX `fk_padre_idx` (`id_padre` ASC)  COMMENT '',
  CONSTRAINT `fk_padre`
    FOREIGN KEY (`id_padre`)
    REFERENCES `ubox`.`ZONA_GEOGRAFICA` (`id_zona_geografica`)
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ubox`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ubox`.`usuario` (
  `id_usuario` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `id_stormpath` VARCHAR(50) NOT NULL COMMENT '',
  `login` VARCHAR(50) NOT NULL COMMENT '',
  `password` VARCHAR(50) NOT NULL COMMENT '',
  `correo` VARCHAR(50) NOT NULL COMMENT '',
  `identificacion` VARCHAR(50) NOT NULL COMMENT '',
  `activo` TINYINT(1) NULL DEFAULT NULL COMMENT '',
  `primer_nombre` VARCHAR(50) NOT NULL COMMENT '',
  `segundo_nombre` VARCHAR(50) NULL DEFAULT NULL COMMENT '',
  `primer_apellido` VARCHAR(50) NOT NULL COMMENT '',
  `segundo_apellido` VARCHAR(50) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_usuario`)  COMMENT '',
  UNIQUE INDEX `id_stormpath_UNIQUE` (`id_stormpath` ASC)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ubox`.`carpeta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ubox`.`carpeta` (
  `id_carpeta` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `id_usuario` INT(11) NOT NULL COMMENT '',
  `nombre_carpeta` VARCHAR(50) NOT NULL COMMENT '',
  `descripcion` VARCHAR(500) NULL DEFAULT NULL COMMENT '',
  `id_carpeta_padre` INT(11) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_carpeta`)  COMMENT '',
  INDEX `FK_Carpeta_Padre1` (`id_carpeta_padre` ASC)  COMMENT '',
  INDEX `fk_carpeta_usuario1_idx` (`id_usuario` ASC)  COMMENT '',
  CONSTRAINT `carpeta_ibfk_1`
    FOREIGN KEY (`id_carpeta_padre`)
    REFERENCES `ubox`.`carpeta` (`id_carpeta`),
  CONSTRAINT `fk_carpeta_usuario1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `ubox`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ubox`.`plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ubox`.`plan` (
  `id_plan` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nombre` VARCHAR(50) NULL DEFAULT NULL COMMENT '',
  `id_tipo_plan` DECIMAL(10,2) NULL DEFAULT NULL COMMENT '',
  `activo` TINYINT(1) NULL DEFAULT NULL COMMENT '',
  `caracteristicas` TEXT NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_plan`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ubox`.`contrato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ubox`.`contrato` (
  `id_contrato` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `fk_usuario` INT(11) NULL DEFAULT NULL COMMENT '',
  `fk_plan` INT(11) NULL DEFAULT NULL COMMENT '',
  `fecha_inicio` DATE NOT NULL COMMENT '',
  `fecha_fin` DATE NOT NULL COMMENT '',
  `activo` TINYINT(1) NULL DEFAULT NULL COMMENT '',
  `descripcion` TEXT NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_contrato`)  COMMENT '',
  INDEX `IXFK_Contrato_Plan` (`fk_plan` ASC)  COMMENT '',
  INDEX `IXFK_Contrato_Usuario` (`fk_usuario` ASC)  COMMENT '',
  CONSTRAINT `fk_contrato_plan`
    FOREIGN KEY (`fk_plan`)
    REFERENCES `ubox`.`plan` (`id_plan`),
  CONSTRAINT `fk_contrato_usuario`
    FOREIGN KEY (`fk_usuario`)
    REFERENCES `ubox`.`usuario` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ubox`.`documento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ubox`.`documento` (
  `id_documento` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `fk_carpeta` INT(11) NOT NULL COMMENT '',
  `fk_usuario` INT(11) NOT NULL COMMENT '',
  `nombre` VARCHAR(50) NOT NULL COMMENT '',
  `id_tipo_documento` INT(10) NOT NULL COMMENT '',
  `id_tipo_mime` VARCHAR(20) NULL DEFAULT NULL COMMENT '',
  `palabras_clave` VARCHAR(50) NOT NULL COMMENT '',
  `fecha` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '',
  `version` VARCHAR(50) NOT NULL COMMENT '',
  `firmado` TINYINT(1) NULL DEFAULT NULL COMMENT '',
  `papelera` TINYINT(1) NOT NULL COMMENT 'Columna para identificar si un documento esta en la papelera de reciclaje o no.',
  `ruta` VARCHAR(500) NULL DEFAULT NULL COMMENT '',
  `documento` BLOB NOT NULL COMMENT '',
  `size` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id_documento`)  COMMENT '',
  INDEX `FK_Documento_Carpeta_idx` (`fk_carpeta` ASC)  COMMENT '',
  INDEX `fk_documento_usuario1_idx` (`fk_usuario` ASC)  COMMENT '',
  CONSTRAINT `fk_documento_carpeta`
    FOREIGN KEY (`fk_carpeta`)
    REFERENCES `ubox`.`carpeta` (`id_carpeta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_documento_usuario`
    FOREIGN KEY (`fk_usuario`)
    REFERENCES `ubox`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ubox`.`documento_x_usuario_compartido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ubox`.`documento_x_usuario_compartido` (
  `id_compartido` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `fk_documento` INT(11) NOT NULL COMMENT '',
  `fk_usuario` INT(11) NOT NULL COMMENT '',
  `fk_forma_comparticion` INT(11) NOT NULL COMMENT '',
  `lectura` BIT(1) NULL DEFAULT NULL COMMENT '',
  `escritura` BIT(1) NULL DEFAULT NULL COMMENT '',
  `descarga` BIT(1) NULL DEFAULT NULL COMMENT '',
  `compartir` BIT(1) NULL DEFAULT NULL COMMENT '',
  `link` VARCHAR(128) NULL DEFAULT NULL COMMENT '',
  `permiso_acitvo` TINYINT(1) NULL DEFAULT NULL COMMENT '',
  `fecha_expiracion` DATE NULL DEFAULT NULL COMMENT '',
  `identificacionComparticion` VARCHAR(50) NULL DEFAULT NULL COMMENT 'Numero de identificación a quien se le comparte el documento o de quien compartio el documento con un usuario.',
  `uboxComparticion` VARCHAR(45) NULL DEFAULT NULL COMMENT 'Identificador del ubox al cual pertenece el usuario que comparte el documento',
  `enviado` BIT(1) NULL DEFAULT NULL COMMENT 'Indica que el documento fue enviado o compartido a otro usuario',
  `recibido` BIT(1) NULL DEFAULT NULL COMMENT 'Indica que el documento fue recibido de otro usuario',
  PRIMARY KEY (`id_compartido`)  COMMENT '',
  INDEX `fk_documento_compartido_documento_idx` (`fk_documento` ASC)  COMMENT '',
  INDEX `fk_documento_x_usuario_compartido_usuario1_idx` (`fk_usuario` ASC)  COMMENT '',
  INDEX `fk_forma_comparticion_idx` (`fk_forma_comparticion` ASC)  COMMENT '',
  CONSTRAINT `fk_documento_compartido_documento`
    FOREIGN KEY (`fk_documento`)
    REFERENCES `ubox`.`documento` (`id_documento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_documento_compartido_usuario`
    FOREIGN KEY (`fk_usuario`)
    REFERENCES `ubox`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_documento_forma_comparticion`
    FOREIGN KEY (`fk_forma_comparticion`)
    REFERENCES `ubox`.`Forma_Comparticion` (`id_forma_comparticion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ubox`.`factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ubox`.`factura` (
  `id_factura` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `fk_contrato` INT(11) NULL DEFAULT NULL COMMENT '',
  `numero_factura` VARCHAR(50) NOT NULL COMMENT '',
  `fecha` DATETIME NOT NULL COMMENT '',
  `estado` VARCHAR(50) NOT NULL COMMENT '',
  PRIMARY KEY (`id_factura`)  COMMENT '',
  INDEX `IXFK_Factura_Contrato` (`fk_contrato` ASC)  COMMENT '',
  CONSTRAINT `fk_factura_contrato`
    FOREIGN KEY (`fk_contrato`)
    REFERENCES `ubox`.`contrato` (`id_contrato`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ubox`.`factura_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ubox`.`factura_detalle` (
  `id_detalle` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `fk_factura` INT(11) NULL DEFAULT NULL COMMENT '',
  `concepto` VARCHAR(50) NOT NULL COMMENT '',
  `valor_bruto` DECIMAL(10,2) NOT NULL COMMENT '',
  `impuesto` DECIMAL(10,2) NOT NULL COMMENT '',
  `valor_neto` DECIMAL(10,2) NOT NULL COMMENT '',
  `cantidad` DECIMAL(10,2) NOT NULL COMMENT '',
  PRIMARY KEY (`id_detalle`)  COMMENT '',
  INDEX `IXFK_Factura_Detalle_Factura` (`fk_factura` ASC)  COMMENT '',
  CONSTRAINT `fk_factura_detalle_factura`
    FOREIGN KEY (`fk_factura`)
    REFERENCES `ubox`.`factura` (`id_factura`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ubox`.`historial_documento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ubox`.`historial_documento` (
  `id_historial` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `fk_documento` INT(11) NULL DEFAULT NULL COMMENT '',
  `fecha` DATE NOT NULL COMMENT '',
  `operacion` VARCHAR(50) NOT NULL COMMENT '',
  `id_tipo_operacion` VARCHAR(50) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_historial`)  COMMENT '',
  INDEX `IXFK_Historial_documento_Documento` (`fk_documento` ASC)  COMMENT '',
  CONSTRAINT `fk_historial_documento_documento`
    FOREIGN KEY (`fk_documento`)
    REFERENCES `ubox`.`documento` (`id_documento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ubox`.`institucion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ubox`.`institucion` (
  `id_institucion` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nombre` VARCHAR(50) NOT NULL COMMENT '',
  `nit` VARCHAR(50) NOT NULL COMMENT '',
  `sitio_web` VARCHAR(50) NOT NULL COMMENT '',
  `activa` TINYINT(1) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_institucion`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ubox`.`lista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ubox`.`lista` (
  `id_lista` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nombre` VARCHAR(50) NOT NULL COMMENT '',
  `activo` TINYINT(1) NULL DEFAULT NULL COMMENT '',
  `descripcion` VARCHAR(256) NOT NULL COMMENT '',
  PRIMARY KEY (`id_lista`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ubox`.`lista_valor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ubox`.`lista_valor` (
  `id_lista_valor` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `fk_lista` INT(11) NOT NULL COMMENT '',
  `valor` VARCHAR(50) NOT NULL COMMENT '',
  `activo` TINYINT(1) NULL DEFAULT NULL COMMENT '',
  `descripcion` VARCHAR(256) NOT NULL COMMENT '',
  `codigo_externo` VARCHAR(20) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_lista_valor`)  COMMENT '',
  INDEX `IXFK_Lista_Valor_Lista` (`fk_lista` ASC)  COMMENT '',
  CONSTRAINT `fk_lista_valor_lista`
    FOREIGN KEY (`fk_lista`)
    REFERENCES `ubox`.`lista` (`id_lista`))
ENGINE = InnoDB
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ubox`.`notificacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ubox`.`notificacion` (
  `id_notificacion` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `fk_usuario` INT(11) NOT NULL COMMENT '',
  `fk_documento` INT(11) NOT NULL COMMENT '',
  `emisor` VARCHAR(50) NOT NULL COMMENT '',
  `receptor` VARCHAR(50) NOT NULL COMMENT '',
  `fecha` DATE NOT NULL COMMENT '',
  `asunto` VARCHAR(50) NOT NULL COMMENT '',
  `texto` VARCHAR(50) NOT NULL COMMENT '',
  PRIMARY KEY (`id_notificacion`)  COMMENT '',
  INDEX `IXFK_Notificacion_Documento` (`fk_documento` ASC)  COMMENT '',
  INDEX `IXFK_Notificacion_Usuario` (`fk_usuario` ASC)  COMMENT '',
  CONSTRAINT `fk_notificacion_documento`
    FOREIGN KEY (`fk_documento`)
    REFERENCES `ubox`.`documento` (`id_documento`),
  CONSTRAINT `fk_notificacion_usuario`
    FOREIGN KEY (`fk_usuario`)
    REFERENCES `ubox`.`usuario` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ubox`.`pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ubox`.`pago` (
  `id_pago` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `fk_documento` INT(11) NULL DEFAULT NULL COMMENT '',
  `monto` DECIMAL(10,2) NOT NULL COMMENT '',
  `id_estado_pago` DECIMAL(10,2) NOT NULL COMMENT '',
  `id_medio_pago` DECIMAL(10,2) NOT NULL COMMENT '',
  `fecha` DATE NOT NULL COMMENT '',
  `comprobante` VARCHAR(50) NOT NULL COMMENT '',
  PRIMARY KEY (`id_pago`)  COMMENT '',
  INDEX `FK_Pago_Documento_idx` (`fk_documento` ASC)  COMMENT '',
  CONSTRAINT `fk_pago_documento`
    FOREIGN KEY (`fk_documento`)
    REFERENCES `ubox`.`documento` (`id_documento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ubox`.`pqr`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ubox`.`pqr` (
  `id_pqr` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `fk_usuario` INT(11) NULL DEFAULT NULL COMMENT '',
  `id_tipo_pqr` DECIMAL(10,2) NULL DEFAULT NULL COMMENT '',
  `descripcion` TEXT NOT NULL COMMENT '',
  `id_estado_pqr` DECIMAL(10,2) NOT NULL COMMENT '',
  `fecha` DATE NOT NULL COMMENT '',
  PRIMARY KEY (`id_pqr`)  COMMENT '',
  INDEX `IXFK_PQR_Usuario` (`fk_usuario` ASC)  COMMENT '',
  CONSTRAINT `fk_pqr_suario`
    FOREIGN KEY (`fk_usuario`)
    REFERENCES `ubox`.`usuario` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ubox`.`tipocarpeta_x_permisos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ubox`.`tipocarpeta_x_permisos` (
  `id_tipo_carpeta_x_permisos` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `id_tipo_carpeta` VARCHAR(50) NOT NULL COMMENT '',
  `id_permiso` VARCHAR(50) NOT NULL COMMENT '',
  PRIMARY KEY (`id_tipo_carpeta_x_permisos`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ubox`.`tipodoc_x_permisos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ubox`.`tipodoc_x_permisos` (
  `id_tipo_doc_x_permisos` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `id_tipo_doc` VARCHAR(50) NOT NULL COMMENT '',
  `id_permiso` VARCHAR(50) NOT NULL COMMENT 'en esta columna se tendra en cuenta si el doc puede ser compartido, firmado, eliminado, etc',
  PRIMARY KEY (`id_tipo_doc_x_permisos`)  COMMENT '',
  INDEX `IXUQ_TIPODOC_PERMISO` (`id_tipo_doc` ASC, `id_permiso` ASC)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ubox`.`tramite`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ubox`.`tramite` (
  `id_tramite` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `fk_institucion` INT(11) NOT NULL COMMENT '',
  `nombre` VARCHAR(50) NOT NULL COMMENT '',
  `id_tipo_tramite` DECIMAL(10,2) NOT NULL COMMENT '',
  `activo` TINYINT(1) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_tramite`)  COMMENT '',
  INDEX `IXFK_Tramite_Institucion` (`fk_institucion` ASC)  COMMENT '',
  CONSTRAINT `fk_tramite_institucion`
    FOREIGN KEY (`fk_institucion`)
    REFERENCES `ubox`.`institucion` (`id_institucion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ubox`.`tramite_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ubox`.`tramite_usuario` (
  `id_estado_tramite` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `fk_tramite` INT(11) NULL DEFAULT NULL COMMENT '',
  `fk_usuario` INT(11) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_estado_tramite`)  COMMENT '',
  INDEX `IXFK_Tramite_Usuario_Tramite` (`fk_tramite` ASC)  COMMENT '',
  INDEX `IXFK_Tramite_Usuario_Usuario` (`fk_usuario` ASC)  COMMENT '',
  CONSTRAINT `fk_tramite_usuario_tramite`
    FOREIGN KEY (`fk_tramite`)
    REFERENCES `ubox`.`tramite` (`id_tramite`),
  CONSTRAINT `fk_tramite_usuario_usuario`
    FOREIGN KEY (`fk_usuario`)
    REFERENCES `ubox`.`usuario` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
