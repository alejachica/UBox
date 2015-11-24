

--LISTA

insert into lista values(1,'Tipo Documento',1,'');
insert into lista values(2,'Tipo Carpeta',1,'');
insert into lista values(3,'Permisos Documento',1,'');
insert into lista values(4,'Permisos Carpeta',1,'');
insert into lista values(5,'Tipo PQR',1,'');
insert into lista values(6,'Tipo Tramite',1,'');
insert into lista values(7, 'Tipo Identificacion', 1,'');
insert into lista values(8,'Nacionalidad',1,'');
insert into lista values(9,'Extension Documento',1,'');

--LISTAVALOR

INSERT INTO `lista_valor` (`fk_lista`, `valor`, `activo`, `descripcion`, `codigo_externo`) VALUES ('1', 'Personales', '1', 'Documentos Personales', 'TD0001');
INSERT INTO `lista_valor` (`fk_lista`, `valor`, `activo`, `descripcion`, `codigo_externo`) VALUES ('1', 'Gubernamentales', '1', 'Documentos gubernamentales', 'TD0002');

insert into lista_valor (FK_LISTA, valor,activo,descripcion,codigo_externo)values (7,'CC',1,'CEDULA CIUDADANIA','TI0001');
insert into lista_valor (FK_LISTA, valor,activo,descripcion,codigo_externo) values(7,'EXT',1,'CEDULA EXTRANJERIA','TI0002');
insert into lista_valor (FK_LISTA, valor,activo,descripcion,codigo_externo) values(7,'TI',1,'TARJETA IDENTIDAD','TI0003');
insert into lista_valor (FK_LISTA, valor,activo,descripcion,codigo_externo) values(7,'NIT',1,'NIT','TI0004');

insert into lista_valor (FK_LISTA, valor,activo,descripcion,codigo_externo)values (8,'COLOMBIANA',1,'','N0001');

insert into lista_valor (FK_LISTA, valor,activo,descripcion,codigo_externo)values (9,'txt',1,'TXT','EX0001');
insert into lista_valor (FK_LISTA, valor,activo,descripcion,codigo_externo)values (9,'rtf',1,'RTF','EX0002');
insert into lista_valor (FK_LISTA, valor,activo,descripcion,codigo_externo)values (9,'doc',1,'DOC','EX0003');
insert into lista_valor (FK_LISTA, valor,activo,descripcion,codigo_externo)values (9,'docx',1,'DOCX','EX0004');
insert into lista_valor (FK_LISTA, valor,activo,descripcion,codigo_externo)values (9,'pdf',1,'PDF','EX0005');
insert into lista_valor (FK_LISTA, valor,activo,descripcion,codigo_externo)values (9,'avi',1,'AVI','EX0006');
insert into lista_valor (FK_LISTA, valor,activo,descripcion,codigo_externo)values (9,'mpeg',1,'MPEG','EX0007');
insert into lista_valor (FK_LISTA, valor,activo,descripcion,codigo_externo)values (9,'mp3',1,'MP3','EX0008');
insert into lista_valor (FK_LISTA, valor,activo,descripcion,codigo_externo)values (9,'bmp',1,'BMP','EX0009');
insert into lista_valor (FK_LISTA, valor,activo,descripcion,codigo_externo)values (9,'gif',1,'GIF','EX0010');
insert into lista_valor (FK_LISTA, valor,activo,descripcion,codigo_externo)values (9,'jpg',1,'JPG','EX0011');
insert into lista_valor (FK_LISTA, valor,activo,descripcion,codigo_externo)values (9,'png',1,'PNG','EX0012');

commit;