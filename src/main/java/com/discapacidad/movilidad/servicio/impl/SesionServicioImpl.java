package com.discapacidad.movilidad.servicio.impl;

import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.discapacidad.movilidad.modelo.DAO.DiscapacidadDAO;
import com.discapacidad.movilidad.modelo.DAO.PersonaDAO;
import com.discapacidad.movilidad.modelo.VO.DiscapacidadVO;
import com.discapacidad.movilidad.modelo.VO.PersonaVO;
import com.discapacidad.movilidad.servicio.SesionServicio;
import com.google.common.hash.Hashing;

@Service("servicioSesion")
public class SesionServicioImpl implements SesionServicio{

	@Autowired
	public PersonaDAO daoPersona;
	
	@Autowired
	public DiscapacidadDAO daoDiscapacidad;
	
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
		//Generar contraseña
		String hast = this.hastGenerarContrasenia(request.getParameter("contrasenia"));
		System.out.println("::..."+hast);
		objPersona.setContrasenia(request.getParameter(hast));
		objPersona.setDiscapacidad(Integer.parseInt(request.getParameter("discapacidad")));
		return objPersona;
	}

	public List<DiscapacidadVO> selectDiscapacitad() {
		// TODO Auto-generated method stub
		System.out.println("Listardiscapacidad");
		List<DiscapacidadVO> lista = daoDiscapacidad.listarDiscapacidad();
		System.out.println("lista ess:..."+lista.size());
		for (DiscapacidadVO personita : lista) {
			System.out.println("*****...."+personita.getNombre());
		}
		return lista;
	}

	public void guardarPersona(PersonaVO objeto) {
		// TODO Auto-generated method stub
		daoPersona.guardarPersona(objeto);
	}

	public String hastGenerarContrasenia(String contra) {
		// TODO Auto-generated method stub
		String sha256hex = Hashing.sha256()
				  .hashString(contra, StandardCharsets.UTF_8)
				  .toString();
		return sha256hex;
	}

}
