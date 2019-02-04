package com.discapacidad.movilidad.modelo.VO;

import java.util.List;


public class FormLugarVO {
	
public Integer id;

	public String nombre;
	
	public String longitud;

	public String Latitud;

	public String mensaje;

	public Integer contador;
	
	public Integer idCategoria;

	
	public FormLugarVO() {
		super();
	}


	public FormLugarVO(Integer id, String nombre, String longitud, String latitud, String mensaje, Integer contador,
			Integer listaCategoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.longitud = longitud;
		Latitud = latitud;
		this.mensaje = mensaje;
		this.contador = contador;
		this.idCategoria = listaCategoria;
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


	public Integer getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}


	
	

}
