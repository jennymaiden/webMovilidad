package com.discapacidad.movilidad.modelo.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persona")
public class PersonaVO {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="id", nullable=false, length=512)
	public Integer id;
	
	@Column(name="nombre", nullable=false, length=30)
	public String nombre;
	
	@Column(name="apellido", nullable=false, length=30)
	public String apellido;
	
	@Column(name="telefono", nullable=false, length=30)
	public String telefono;
	
	@Column(name="direccion", nullable=false, length=60)
	public String direccion;
	
	@Column(name="email", nullable=false, length=50)
	public String email;
	
	@Column(name="ciudad", nullable=false, length=30)
	public String ciudad;
	
	@Column(name="usuario", nullable=false, length=30)
	public String usuario;
	
	@Column(name="contrasenia", nullable=false)
	public String contrasenia;
	
	@Column(name="id_discapacidad", nullable=false, length=30)
	public Integer discapacidad;


	public PersonaVO(Integer id, String nombre, String apellido, String telefono, String direccion, String email,
			String ciudad, String usuario, String contrasenia, Integer discapacidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
		this.ciudad = ciudad;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.discapacidad = discapacidad;
	}

	public PersonaVO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Integer getDiscapacidad() {
		return discapacidad;
	}

	public void setDiscapacidad(Integer discapacidad) {
		this.discapacidad = discapacidad;
	}
	
	

}
