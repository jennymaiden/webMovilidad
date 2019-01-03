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

	@Transactional 
	public boolean validarUsuario(String usuario) {
		boolean respuesta = false;
		try
		 {
			Query query = mySessionFactory.getCurrentSession().createQuery("from PersonaVO where usuario=:pUsuario");
			query.setParameter("pUsuario",usuario);
			//System.out.println("La respuesta es:..."+query.list());
			
			//System.out.println("El tamaño de la lista es:......"+query.list().size());
			if(query.list().size() > 1){
				respuesta = true;
			}
			
		 }
		 catch (HibernateException e)
		 {
			 e.printStackTrace();
			 System.out.println("catch:....");
			 
		 }
		 /*catch(Exception e){
			 e.printStackTrace();
			 System.out.println("catch:....");
	       
	     }*/
	
		return respuesta;
	}

	@Transactional
	public PersonaVO validarSession(String usuario, String contraenia) {
		// TODO Auto-generated method stub
		PersonaVO respuesta = new PersonaVO();
		try
		{
			Query query = mySessionFactory.getCurrentSession().createQuery("from PersonaVO where usuario=:pUsuario and contrasenia=:pContra");
			query.setParameter("pUsuario",usuario);
			query.setParameter("pContra",contraenia);
			System.out.println("La respuesta es:..."+query.list());
			
			System.out.println("El tamaño de la lista es:......"+query.list().size());
			if(query.list().size() == 1){
				
				respuesta = (PersonaVO) query.getSingleResult();
			}
			
		}
		catch(HibernateException e)
		 {
			 e.printStackTrace();			 
		 }
		catch(Exception e)
		{
			 e.printStackTrace();
	    }
		return respuesta;
	}
	
	

}
