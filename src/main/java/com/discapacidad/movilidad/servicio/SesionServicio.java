package com.discapacidad.movilidad.servicio;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.discapacidad.movilidad.modelo.VO.DiscapacidadVO;
import com.discapacidad.movilidad.modelo.VO.PersonaVO;


public interface SesionServicio {
	
	public PersonaVO buscarPersonaId(Integer id);
	
	public PersonaVO mapearFormularioResistro(HttpServletRequest request);
	
	public List<DiscapacidadVO> selectDiscapacitad();
	
	
	public void guardarPersona(PersonaVO objeto);
	
	public String hastGenerarContrasenia(String contra);
	
	public PersonaVO  autenticacionUSuario(HttpServletRequest request); 
	
	public Model  validacionSesion(HttpServletRequest request, Model model);

}
