package com.discapacidad.movilidad.modelo.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.discapacidad.movilidad.modelo.VO.Cat_LugarVO;
import com.discapacidad.movilidad.modelo.VO.CategoriaLugarVO;
import com.discapacidad.movilidad.modelo.VO.CategoriaVO;
import com.discapacidad.movilidad.modelo.VO.LugarVO;

@Repository
public class CategoriaLugarDAOImpl implements CategoriaLugarDAO{

	
	@Autowired
	public SessionFactory mySessionFactory;
	
	@Autowired
	public CategoriaDAO daoCategoria;
	
	@Autowired
	public LugarDAO daoLugar;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.mySessionFactory = sessionFactory;
    }
	
	public List<CategoriaLugarVO> listarCategoriasLugar() {
		// TODO Auto-generated method stub

		List<CategoriaLugarVO> listaCategoriaLugar = new ArrayList<CategoriaLugarVO>() ;
		
		
		List<CategoriaVO> listCategoria = daoCategoria.listarCategoria();
		
		for (CategoriaVO it : listCategoria) {
			CategoriaLugarVO objeto = new CategoriaLugarVO();
			objeto.setId(it.getId());
			objeto.setNombre(it.getNombre());
			objeto.setHtml(it.getHtml());
			List<LugarVO> listaLugar = daoLugar.listaLugarPorCategoria(it.getId());
			objeto.setListLugar(listaLugar);
			
			listaCategoriaLugar.add(objeto);
		}
		/*Iterator<CategoriaVO> it = listCategoria.iterator();
		 
		while (it.hasNext()) {
			objeto.setId(it.next().getId());
			objeto.setNombre(it.next().getNombre());
			objeto.setHtml(it.next().getHtml());
			List<LugarVO> listaLugar = daoLugar.listaLugarPorCategoria(it.next().getId());
			objeto.setListLugar(listaLugar);
			
			listaCategoriaLugar.add(objeto);
		 
		}*/
		
		return listaCategoriaLugar;
	}

	@Transactional
	public void guardarCategoriaLugar(Cat_LugarVO objeto) {
		// TODO Auto-generated method stub
		try
		 {
			mySessionFactory.getCurrentSession().save(objeto);
			System.out.println("Se guardo correctamente categoria_lugar:....");
		 }
		 catch (HibernateException e)
		 {
			 e.printStackTrace();
			 System.out.println("catch:....");
			 
		 }
	}

}
