package com.discapacidad.movilidad.modelo.DAO;
import java.util.List;

import com.discapacidad.movilidad.modelo.VO.Cat_LugarVO;
import com.discapacidad.movilidad.modelo.VO.CategoriaLugarVO;

public interface CategoriaLugarDAO {
	
	public List<CategoriaLugarVO> listarCategoriasLugar();
	
	public void guardarCategoriaLugar(Cat_LugarVO objeto);

}
