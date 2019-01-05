package com.discapacidad.movilidad.modelo.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class CategoriaVO {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="id", nullable=false, length=512)
	public Integer id;
	
	@Column(name="nombre", nullable=false, length=30)
	public String nombre;
	
	@Column(name="disabled", nullable=false)
	public boolean habilitado;
	
	@Column(name="nombre_html", nullable=false)
	public String html;

	
	public CategoriaVO() {
		super();
	}


	public CategoriaVO(Integer id, String nombre, boolean habilitado, String html) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.habilitado = habilitado;
		this.html = html;
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


	public boolean isHabilitado() {
		return habilitado;
	}


	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}


	public String getHtml() {
		return html;
	}


	public void setHtml(String html) {
		this.html = html;
	}


	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"nombre\":\"" + nombre + "\", \"habilitado\":\"" + habilitado + "\", \"html\":\"" + html + "\"}";
	}
	
	

}
