package com.discapacidad.movilidad.modelo.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="imagen_lugar")
public class ImagenVO {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="id")
	public Integer id;
	
	@Column(name="id_lugar")
	public Integer idLugar;
	
	@Column(name="ruta")
	public String ruta;
	
	@Column(name="nombre")
	public String nombre;

	
	public ImagenVO() {
		super();
	}


	public ImagenVO(Integer id, Integer idLugar, String ruta, String nombre) {
		super();
		this.id = id;
		this.idLugar = idLugar;
		this.ruta = ruta;
		this.nombre = nombre;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getIdLugar() {
		return idLugar;
	}


	public void setIdLugar(Integer idLugar) {
		this.idLugar = idLugar;
	}


	public String getRuta() {
		return ruta;
	}


	public void setRuta(String ruta) {
		this.ruta = ruta;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
