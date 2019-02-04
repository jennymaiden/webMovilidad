package com.discapacidad.movilidad.servicio;

import java.util.List;

import com.discapacidad.movilidad.modelo.VO.CategoriaLugarVO;
import com.discapacidad.movilidad.modelo.VO.CategoriaVO;
import com.discapacidad.movilidad.modelo.VO.FormLugarVO;
import com.discapacidad.movilidad.modelo.VO.ImagenLugarVO;
import com.discapacidad.movilidad.modelo.VO.LugarVO;

public interface MovilidadServicio {
	
	public List<CategoriaVO> mostrarCategorias();
	
	public List<LugarVO> listarLugaresPorCategoria(int idCategoria);
	
	public LugarVO buscarLugar(int id);
	
	public Boolean cargarArchivo(ImagenLugarVO archivo);
	
	public List<CategoriaLugarVO> listaCategoriaLugar();
	
	public void saveUpdateLugar(FormLugarVO objeto);
	
	public int actualizarMeGustas(Integer idLugar, Integer contador);
	

}
