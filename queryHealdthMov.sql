CREATE TABLE persona(
	id serial primary key,
	nombre varchar(30),
	apellido varchar(30),
	telefono varchar(30),
	direccion varchar(60),
	email varchar(50),
	ciudad varchar(30),
	usuario varchar(30),
	contrasenia text
);


CREATE TABLE discapacidad(
	id serial primary key,
	tipo varchar(30),
	disabled boolean
);

ALTER TABLE persona ADD COLUMN id_discapacidad integer ;
ALTER TABLE "persona" 
   ADD CONSTRAINT fk_discapacidad
   FOREIGN KEY (id_discapacidad) 
   REFERENCES "discapacidad"(id);

insert into discapacidad (tipo, disabled) values('Silla de ruedas', true);
insert into discapacidad (tipo, disabled) values('Visual', true);
insert into discapacidad (tipo, disabled) values('Auditiva', true);
insert into discapacidad (tipo, disabled) values('Movilidad', true);
insert into discapacidad (tipo, disabled) values('Otra', true);

alter table persona ALTER column contrasenia TYPE text;

select * from persona;
select * from discapacidad;

CREATE TABLE lugar(
	id serial primary key,
	nombre varchar(30),
	latitud integer,
	longitud integer,
	mensaje text,
	megusta integer
);

CREATE TABLE categoria(
	id serial primary key,
	nombre varchar(30),
	disabled boolean 
);
alter table categoria add column nombre_html  varchar(30);
CREATE TABLE categoria_lugar(
	id_lugar integer,
	id_categoria integer,
	FOREIGN KEY (id_lugar) REFERENCES lugar(id),
	FOREIGN KEY (id_categoria) REFERENCES categoria(id)	
);

insert into categoria (nombre, disabled, nombre_html) values('Restaurantes', true, 'restauran');
insert into categoria (nombre, disabled, nombre_html) values('Parques', true, 'park');
insert into categoria (nombre, disabled, nombre_html) values('Museos', true, 'museo');
insert into categoria (nombre, disabled, nombre_html) values('Teatros', true, 'teatro');
insert into categoria (nombre, disabled, nombre_html) values('Centros comerciales', true, 'cc_comercial');


alter table lugar ALTER column nombre TYPE text;
SELECT * from categoria_lugar;
SELECT * from lugar;
SELECT * from categoria;
insert into lugar (nombre, latitud, longitud, mensaje,megusta) values('Leo Cocina y Cava','4.614441001281722','-74.06905600000005','Una manifestación de la vida de montaña, bosque, páramo, valle, mar, isla, manglar, selva tropical y río.',0);
insert into lugar (nombre, latitud, longitud, mensaje,megusta) values('Pasión Peruana','4.614960210112264','-74.06602937044887','Pasión Peruana.',0);
insert into lugar (nombre, latitud, longitud, mensaje,megusta) values('Museo Exposición del Hombre','4.615975030971612','-74.07730057034499','Museo Exposición del Hombre.',0);
insert into lugar (nombre, latitud, longitud, mensaje,megusta) values('Parque Distrital Barrio Ricaute','4.6089810964225455','-74.09414484295851','Parque Distrital Barrio Ricaute.',0);
insert into lugar (nombre, latitud, longitud, mensaje,megusta) values('Calima Centro Comercial','4.618642230053939','-74.08593288017192','Calima Centro Comercial',0);
insert into lugar (nombre, latitud, longitud, mensaje,megusta) values('Corferias','4.626616264115877','-74.09300135590927','Corferias',0);
insert into lugar (nombre, latitud, longitud, mensaje,megusta) values('Centro Comercial Galerias','4.6431695591437805','-74.0750020748295','Centro Comercial Galerias',0);
insert into lugar (nombre, latitud, longitud, mensaje,megusta) values('Estadio el Campin','4.6459498963820005','-74.0773624187626','Estadio el Campin',0);
insert into lugar (nombre, latitud, longitud, mensaje,megusta) values('Movistar Arena','4.649457639554529','-74.07727671672336','Movistar Arena',0);
insert into lugar (nombre, latitud, longitud, mensaje,megusta) values('Casino Dragones','4.660621596827871','-74.06372641986017','Casino Dragones',0);

insert into categoria_lugar (id_lugar,id_categoria) values(1,1); --restaurante
insert into categoria_lugar (id_lugar,id_categoria) values(4,1); --restaurante
insert into categoria_lugar (id_lugar,id_categoria) values(6,2); --parques
insert into categoria_lugar (id_lugar,id_categoria) values(5,3); --Museos
insert into categoria_lugar (id_lugar,id_categoria) values(8,4); --Teatros
insert into categoria_lugar (id_lugar,id_categoria) values(10,4); --Teatros
insert into categoria_lugar (id_lugar,id_categoria) values(11,4); --Teatros
insert into categoria_lugar (id_lugar,id_categoria) values(7,5); --Centros comerciales
insert into categoria_lugar (id_lugar,id_categoria) values(9,5); --Centros comerciales

