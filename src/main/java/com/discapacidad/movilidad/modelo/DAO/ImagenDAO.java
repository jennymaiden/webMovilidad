package com.discapacidad.movilidad.modelo.DAO;

import java.util.List;

import com.discapacidad.movilidad.modelo.VO.ImagenVO;

public interface ImagenDAO {

	public void guardarImagen(ImagenVO objeto);
	
	public List<ImagenVO> listarImagenes(int idLugar);
}
