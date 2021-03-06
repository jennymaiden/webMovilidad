package com.discapacidad.movilidad.modelo.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="discapacidad")
public class DiscapacidadVO {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="id", nullable=false, length=512)
	public Integer id;
	
	@Column(name="tipo", nullable=false, length=50)
	public String nombre;
	
	@Column(name="disabled", nullable=false)
	public boolean habilitado;

	public DiscapacidadVO(Integer id, String nombre, boolean habilitado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.habilitado = habilitado;
	}

	public DiscapacidadVO() {
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

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	
}
