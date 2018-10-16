package com.discapacidad.movilidad.servicio;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.discapacidad.movilidad.modelo.VO.PersonaVO;


public interface SesionServicio {
	
	public PersonaVO buscarPersonaId(Integer id);
	
	public PersonaVO mapearFormularioResistro(HttpServletRequest request);
	

}
