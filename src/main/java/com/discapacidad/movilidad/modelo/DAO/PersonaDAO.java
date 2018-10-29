package com.discapacidad.movilidad.modelo.DAO;

import com.discapacidad.movilidad.modelo.VO.PersonaVO;

public interface PersonaDAO {
	
	/**
	 * Buscar un PERSONA POR SU ID**/
	public PersonaVO consultaPersona(Integer id );
	
	/**
	 * Guardar la persona**/
	public void guardarPersona(PersonaVO objeto);
	
	/**
	 * Buscar por el usuario si existe o no en la tabla de persona**/
	public boolean validarUsuario(String usuario);
	
	/**
	 * Validar usuario y contraseña de rgistro**/
	public PersonaVO validarSession(String usuario, String contraenia);

}
