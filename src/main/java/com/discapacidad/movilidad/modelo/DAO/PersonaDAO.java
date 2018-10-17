package com.discapacidad.movilidad.modelo.DAO;

import com.discapacidad.movilidad.modelo.VO.PersonaVO;

public interface PersonaDAO {
	
	/**
	 * Buscar un PERSONA POR SU ID**/
	public PersonaVO consultaPersona(Integer id );
	
	/**
	 * Guardar la persona**/
	public void guardarPersona(PersonaVO objeto);

}
