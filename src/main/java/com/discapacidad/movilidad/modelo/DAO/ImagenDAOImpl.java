package com.discapacidad.movilidad.modelo.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.discapacidad.movilidad.modelo.VO.ImagenVO;

@Repository
public class ImagenDAOImpl implements ImagenDAO{

	
	@Autowired
	public SessionFactory mySessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.mySessionFactory = sessionFactory;
    }
	
	@Transactional
	public void guardarImagen(ImagenVO objeto) {
		// TODO Auto-generated method stub
		try
		 {
			mySessionFactory.getCurrentSession().save(objeto);
			System.out.println("lSe guardo correctamente:....");
		 }
		 catch (HibernateException e)
		 {
			 e.printStackTrace();
			 System.out.println("catch:....");
			 
		 }
		
	}

	public List<ImagenVO> listarImagenes(int idLugar) {
		// TODO Auto-generated method stub
		List<ImagenVO> lista = null;
		 try
		 {
			 Query query =  mySessionFactory.getCurrentSession().createQuery("from ImagenVO where idLugar=:pId");
			 query.setParameter("pId",idLugar);
			 lista = query.list();
		 }
		 catch (HibernateException e)
		 {
			 e.printStackTrace();
			 //System.out.println("catch:....");
			 
		 }
		 
		return lista;
	}

}
