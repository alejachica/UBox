

--LISTA

insert into lista values(1,'Tipo Documento',1,'');
insert into lista values(2,'Tipo Carpeta',1,'');
insert into lista values(3,'Permisos Documento',1,'');
insert into lista values(4,'Permisos Carpeta',1,'');
insert into lista values(5,'Tipo PQR',1,'');
insert into lista values(6,'Tipo Tramite',1,'');
insert into lista values(7, 'Tipo Identificacion', 1,'');
insert into lista values(8,'Nacionalidad',1,'');

--LISTAVALOR

INSERT INTO `lista_valor` (`fk_lista`, `valor`, `activo`, `descripcion`, `codigo_externo`) VALUES ('1', 'Personales', '1', 'Documentos Personales', 'TD0001');
INSERT INTO `lista_valor` (`fk_lista`, `valor`, `activo`, `descripcion`, `codigo_externo`) VALUES ('1', 'Gubernamentales', '1', 'Documentos gubernamentales', 'TD0002');

insert into lista_valor (FK_LISTA, valor,activo,descripcion,codigo_externo)values (7,'CC',1,'CEDULA CIUDADANIA','TI0001');
insert into lista_valor (FK_LISTA, valor,activo,descripcion,codigo_externo) values(7,'EXT',1,'CEDULA EXTRANJERIA','TI0002');
insert into lista_valor (FK_LISTA, valor,activo,descripcion,codigo_externo) values(7,'TI',1,'TARJETA IDENTIDAD','TI0003');
insert into lista_valor (FK_LISTA, valor,activo,descripcion,codigo_externo) values(7,'NIT',1,'NIT','TI0004');

insert into lista_valor (FK_LISTA, valor,activo,descripcion,codigo_externo)values (8,'COLOMBIANA',1,'','N0001');

commit;