package com.discapacidad.movilidad.modelo.DAO;

import java.util.List;

import com.discapacidad.movilidad.modelo.VO.LugarVO;

public interface LugarDAO {

	public List<LugarVO> listaLugarPorCategoria(int categoria);
	
	public LugarVO obtenerLugar(int id);
	
	public int guardarLugar(LugarVO objeto);
}
