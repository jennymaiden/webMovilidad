package com.discapacidad.movilidad.modelo.DAO;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.discapacidad.movilidad.modelo.VO.PersonaVO;

@Repository
public class PersonaDAOImpl implements PersonaDAO {
	
	@Autowired
	public SessionFactory mySessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.mySessionFactory = sessionFactory;
    }

	
	@Transactional
	public PersonaVO consultaPersona(Integer id ){
		
		return (PersonaVO) mySessionFactory.getCurrentSession().get(PersonaVO.class, id);
		
	}

	@Transactional
	public void guardarPersona(PersonaVO objeto) {
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
	
	

}
