package com.discapacidad.movilidad.modelo.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.discapacidad.movilidad.modelo.VO.DiscapacidadVO;

@Repository
public class DiscapaidadDAOImpl implements DiscapacidadDAO{

	@Autowired
	public SessionFactory mySessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.mySessionFactory = sessionFactory;
    }
	
	@Transactional
	public List<DiscapacidadVO> listarDiscapacidad() {
		// TODO Auto-generated method stub
		 List<DiscapacidadVO> lista = null;
		 try
		 {
			 Query query =  mySessionFactory.getCurrentSession().createQuery("from DiscapacidadVO") ;
			 lista = query.list();
			 //System.out.println("listar discapacidad query:...."+query);
			 //System.out.println("listar discapacidad list:...."+lista);
		 }
		 catch (HibernateException e)
		 {
			 e.printStackTrace();
			 //System.out.println("catch:....");
			 
		 }
		 
		 return lista;

		
	}

}
