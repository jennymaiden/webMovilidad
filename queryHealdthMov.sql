CREATE TABLE persona(
	id serial primary key,
	nombre varchar(30),
	apellido varchar(30),
	telefono varchar(30),
	direccion varchar(60),
	email varchar(50),
	ciudad varchar(30),
	usuario varchar(30),
	contrasenia varchar(30)
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

select * from persona;
select * from discapacidad;




