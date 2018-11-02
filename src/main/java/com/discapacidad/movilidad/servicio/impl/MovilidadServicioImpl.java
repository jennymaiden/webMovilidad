package com.discapacidad.movilidad.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.discapacidad.movilidad.modelo.DAO.CategoriaDAO;
import com.discapacidad.movilidad.modelo.DAO.PersonaDAO;
import com.discapacidad.movilidad.modelo.VO.CategoriaVO;
import com.discapacidad.movilidad.servicio.MovilidadServicio;

@Service("servicioMovilidad")
public class MovilidadServicioImpl implements MovilidadServicio {

	@Autowired
	public PersonaDAO daoPersona;	
	
	@Autowired
	public CategoriaDAO daoCategoria;
	
	
	public List<CategoriaVO> mostrarCategorias() {
		// TODO Auto-generated method stub
		return daoCategoria.listarCategoria();
	}

}
