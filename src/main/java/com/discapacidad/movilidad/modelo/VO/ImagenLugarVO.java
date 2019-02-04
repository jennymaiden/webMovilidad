package com.discapacidad.movilidad.modelo.VO;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ImagenLugarVO {
	
	public Integer idLugar;
	
	CommonsMultipartFile fichero;
	 
	public CommonsMultipartFile getFichero() {
		return fichero;
	}
 
	public void setFichero(CommonsMultipartFile fichero) {
		this.fichero = fichero;
	}

	public Integer getIdLugar() {
		return idLugar;
	}

	public void setIdLugar(Integer idLugar) {
		this.idLugar = idLugar;
	}

	
}
