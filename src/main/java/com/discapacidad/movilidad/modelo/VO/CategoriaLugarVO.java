package com.discapacidad.movilidad.modelo.VO;

import java.util.List;

public class CategoriaLugarVO {
	
public Integer id;
	
	
	public String nombre;
	
	public String html;
	
	public List<LugarVO> listLugar;
	
	public CategoriaLugarVO() {
		super();
	}


	public CategoriaLugarVO(Integer id, String nombre, String html, List<LugarVO> listLugar) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.html = html;
		this.listLugar = listLugar;
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

	public String getHtml() {
		return html;
	}


	public void setHtml(String html) {
		this.html = html;
	}


	public List<LugarVO> getListLugar() {
		return listLugar;
	}


	public void setListLugar(List<LugarVO> listLugar) {
		this.listLugar = listLugar;
	}
	
	

}
