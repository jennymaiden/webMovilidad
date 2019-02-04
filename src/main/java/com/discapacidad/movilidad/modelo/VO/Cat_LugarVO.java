package com.discapacidad.movilidad.modelo.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoria_lugar")
public class Cat_LugarVO {
	
	
	@Id
	@Column(name="id_categoria")
	public Integer idCategoria;

	@Column(name="id_lugar")
	public Integer idLugar;

	
	public Cat_LugarVO() {
		super();
	}


	public Cat_LugarVO(Integer idCategoria, Integer idLugar) {
		super();
		this.idCategoria = idCategoria;
		this.idLugar = idLugar;
	}


	public Integer getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}


	public Integer getIdLugar() {
		return idLugar;
	}


	public void setIdLugar(Integer idLugar) {
		this.idLugar = idLugar;
	}
	
}
