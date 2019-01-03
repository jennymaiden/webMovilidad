package com.discapacidad.movilidad.servicio.impl;

import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
		
		PersonaVO objPersona = new PersonaVO();
		//validar que el usuario no exista en la base de datos
		String user = request.getParameter("nameUsuario");
		if(!daoPersona.validarUsuario(user)){
			System.out.println("NO::...Existe el usuario");
			objPersona.setNombre(request.getParameter("nombre"));
			objPersona.setApellido(request.getParameter("apellido"));
			objPersona.setTelefono(request.getParameter("telefono"));
			objPersona.setDireccion(request.getParameter("direccion"));
			objPersona.setEmail(request.getParameter("email"));
			objPersona.setCiudad(request.getParameter("ciudad"));
			
			objPersona.setUsuario(user);
			//Generar contraseña
			String hast = this.hastGenerarContrasenia(request.getParameter("contrasenia"));
			//System.out.println("::..."+hast);
			objPersona.setContrasenia(hast);
			objPersona.setDiscapacidad(Integer.parseInt(request.getParameter("discapacidad")));
			
		}else{
			System.out.println("Respuesta fallida validar usuario::::::::");
		}
		return objPersona;
	}

	public List<DiscapacidadVO> selectDiscapacitad() {
		// TODO Auto-generated method stub
		
		List<DiscapacidadVO> lista = daoDiscapacidad.listarDiscapacidad();
		
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

	public PersonaVO autenticacionUSuario(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String usuario = request.getParameter("usuario");
		String password = this.hastGenerarContrasenia(request.getParameter("password"));
		PersonaVO objeto = daoPersona.validarSession(usuario, password);
		
		return objeto;
	}

	public Model validacionSesion(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String msg = "";
		if(session.getAttribute("usr") != null && !session.getAttribute("usr").equals("")){
			//System.out.println("Se encuentra alo en la sesion");
			msg="true";
		}else{
			//System.out.println("No ahi nada!!!");
		}
		model.addAttribute("perfil",msg);
		
		
		return model;
	}

}
