package com.discapacidad.movilidad.servicio.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.discapacidad.movilidad.modelo.DAO.CategoriaDAO;
import com.discapacidad.movilidad.modelo.DAO.CategoriaLugarDAO;
import com.discapacidad.movilidad.modelo.DAO.ImagenDAO;
import com.discapacidad.movilidad.modelo.DAO.LugarDAO;
import com.discapacidad.movilidad.modelo.DAO.PersonaDAO;
import com.discapacidad.movilidad.modelo.VO.Cat_LugarVO;
import com.discapacidad.movilidad.modelo.VO.CategoriaLugarVO;
import com.discapacidad.movilidad.modelo.VO.CategoriaVO;
import com.discapacidad.movilidad.modelo.VO.FormLugarVO;
import com.discapacidad.movilidad.modelo.VO.ImagenLugarVO;
import com.discapacidad.movilidad.modelo.VO.ImagenVO;
import com.discapacidad.movilidad.modelo.VO.LugarVO;
import com.discapacidad.movilidad.servicio.MovilidadServicio;

@Service("servicioMovilidad")
public class MovilidadServicioImpl implements MovilidadServicio {

	@Autowired
	public PersonaDAO daoPersona;	
	
	@Autowired
	public CategoriaDAO daoCategoria;
	
	@Autowired
	public LugarDAO daoLugar;
	
	@Autowired
	public CategoriaLugarDAO daoCategoriaLugar;
	
	@Autowired
	public ImagenDAO daoImagen;
	
	
	public List<CategoriaVO> mostrarCategorias() {
		// TODO Auto-generated method stub
		return daoCategoria.listarCategoria();
	}


	public List<LugarVO> listarLugaresPorCategoria(int idCategoria) {
		// TODO Auto-generated method stub
		return daoLugar.listaLugarPorCategoria(idCategoria);
	}


	public LugarVO buscarLugar(int id) {
		// TODO Auto-generated method stub
		return daoLugar.obtenerLugar(id);
	}


	public Boolean cargarArchivo(ImagenLugarVO archivo) {
		// TODO Auto-generated method stub
		ImagenVO imagen = new ImagenVO();
		imagen.setIdLugar(archivo.getIdLugar());
		imagen.setRuta("/home/fernando/Documentos/Utilidades/movilidad/ImagenesLugares/");
		
		CommonsMultipartFile uploaded = archivo.getFichero();
		//System.out.println("El nombre delarchivo es :::........."+uploaded.getName());
    	File localFile = new File(imagen.getRuta()+uploaded.getOriginalFilename());
    	imagen.setNombre(uploaded.getOriginalFilename());
    	
    	FileOutputStream os = null;
    	
    	try {
    		os = new FileOutputStream(localFile);
    		os.write(uploaded.getBytes());
    		
    		daoImagen.guardarImagen(imagen);
    		
    	}catch(IOException e){
    		// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
    	} 
    	finally {
    		if (os != null) {
    			try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
    		}
    	}
		return true;
	}


	public List<CategoriaLugarVO> listaCategoriaLugar() {
		// TODO Auto-generated method stub
		return daoCategoriaLugar.listarCategoriasLugar();
	}


	public void saveUpdateLugar(FormLugarVO objeto) {
		// TODO Auto-generated method stub
		System.out.println("El id es :::::::::::::...."+objeto.getId());
		LugarVO lugar = new LugarVO();
		if(objeto.getId() !=null){
			lugar.setId(objeto.getId());
		}else{
			lugar.setContador(0);
		}
		
		lugar.setNombre(objeto.getNombre());
		lugar.setLatitud(objeto.getLatitud());
		lugar.setLongitud(objeto.getLongitud());
		lugar.setMensaje(objeto.getMensaje());
		//lugar.setContador(objeto.getContador());
		
		System.out.println("EL dato de categoria es :....."+objeto.getIdCategoria());
		//Guardar el lugar
		int idLugar = daoLugar.guardarLugar(lugar);
		
		System.out.println("EL id del lugar es:::::::::...."+idLugar);
		if(idLugar >0 && objeto.getId() ==null){
			//Guardar la relacion de categoria lugar
			Cat_LugarVO relacion = new Cat_LugarVO(objeto.getIdCategoria(), idLugar);
			System.out.println("La categoria:..."+relacion.getIdCategoria() +"  el id lugar:..."+relacion.getIdLugar());
			
			daoCategoriaLugar.guardarCategoriaLugar(relacion);
			
		}
		
	}


	public int actualizarMeGustas(Integer idLugar, Integer contador) {
		// TODO Auto-generated method stub
		LugarVO objeto = daoLugar.obtenerLugar(idLugar);
		
		objeto.setContador(contador +1);
		int id = daoLugar.guardarLugar(objeto);
		
		return objeto.getContador();
	}



}
