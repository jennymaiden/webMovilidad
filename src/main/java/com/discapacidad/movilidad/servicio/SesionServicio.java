package com.discapacidad.movilidad.servicio;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.discapacidad.movilidad.modelo.VO.DiscapacidadVO;
import com.discapacidad.movilidad.modelo.VO.PersonaVO;


public interface SesionServicio {
	
	public PersonaVO buscarPersonaId(Integer id);
	
	public PersonaVO mapearFormularioResistro(HttpServletRequest request);
	
	public List<DiscapacidadVO> selectDiscapacitad();
	
	
	public void guardarPersona(PersonaVO objeto);
	
	public String hastGenerarContrasenia(String contra);

}
