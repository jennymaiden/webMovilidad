package com.discapacidad.movilidad.servicio.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.discapacidad.movilidad.modelo.DAO.PersonaDAO;
import com.discapacidad.movilidad.modelo.VO.PersonaVO;
import com.discapacidad.movilidad.servicio.SesionServicio;

@Service("servicioSesion")
public class SesionServicioImpl implements SesionServicio{

	@Autowired
	public PersonaDAO daoPersona;
	
	public PersonaVO buscarPersonaId(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("Buscar una persona por el id");
		PersonaVO persona = daoPersona.consultaPersona(id);
		System.out.println("Nombre del paciente:...."+persona.getNombre());
		System.out.println("id:...."+persona.getId());
		return persona;
	}

	public PersonaVO mapearFormularioResistro(HttpServletRequest request) {
		// TODO Auto-generated method stub
		PersonaVO objPersona = new PersonaVO();
		
		objPersona.setNombre(request.getParameter("nombre"));
		objPersona.setApellido(request.getParameter("apellido"));
		objPersona.setTelefono(request.getParameter("telefono"));
		objPersona.setDireccion(request.getParameter("direccion"));
		objPersona.setEmail(request.getParameter("email"));
		objPersona.setCiudad(request.getParameter("ciudad"));
		objPersona.setUsuario(request.getParameter("nameUsuario"));
		objPersona.setContrasenia(request.getParameter("contrasenia"));
		objPersona.setDiscapacidad(Integer.parseInt(request.getParameter("discapacidad")));
		return objPersona;
	}

}
