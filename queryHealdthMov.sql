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

CREATE TABLE categoria_lugar(
	id_lugar integer,
	id_categoria integer,
	FOREIGN KEY (id_lugar) REFERENCES lugar(id),
	FOREIGN KEY (id_categoria) REFERENCES categoria(id)	
);

insert into categoria (nombre, disabled) values('');

