package com.discapacidad.movilidad.modelo.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lugar")
public class LugarVO {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="id")
	public Integer id;
	
	@Column(name="nombre")
	public String nombre;
	
	@Column(name="longitud")
	public String longitud;
	
	@Column(name="latitud")
	public String Latitud;
	
	@Column(name="mensaje")
	public String mensaje;
	
	@Column(name="megusta")
	public Integer contador;

	
	public LugarVO() {
		super();
	}

	public LugarVO(Integer id, String nombre, String longitud, String latitud, String mensaje, Integer contador) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.longitud = longitud;
		Latitud = latitud;
		this.mensaje = mensaje;
		this.contador = contador;
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

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getLatitud() {
		return Latitud;
	}

	public void setLatitud(String latitud) {
		Latitud = latitud;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Integer getContador() {
		return contador;
	}

	public void setContador(Integer contador) {
		this.contador = contador;
	}

	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"nombre\":\"" + nombre + "\", \"longitud\":\"" + longitud + "\", \"latitud\":\"" + Latitud
				+ "\", \"mensaje\":\"" + mensaje + "\", \"contador\":\"" + contador + "\"}";
	}

	
}
