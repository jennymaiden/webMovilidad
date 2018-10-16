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

ALTER TABLE "persona" 
   ADD CONSTRAINT fk_discapacidad
   FOREIGN KEY (anio_nacimiento) 
   REFERENCES "Anios"(clave_anio);

