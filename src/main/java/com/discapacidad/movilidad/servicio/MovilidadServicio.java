package com.discapacidad.movilidad.servicio;

import java.util.List;

import com.discapacidad.movilidad.modelo.VO.CategoriaVO;
import com.discapacidad.movilidad.modelo.VO.LugarVO;

public interface MovilidadServicio {
	
	public List<CategoriaVO> mostrarCategorias();
	
	public List<LugarVO> listarLugaresPorCategoria(int idCategoria);
	

}
