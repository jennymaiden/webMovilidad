package com.discapacidad.movilidad.modelo.DAO;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.discapacidad.movilidad.modelo.VO.PersonaVO;

@Repository
public class PersonaDAO {
	
	@Autowired
	public SessionFactory mySessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.mySessionFactory = sessionFactory;
    }
	
	@Transactional
	public PersonaVO consultaPersona(Integer id ){
		
		return (PersonaVO) mySessionFactory.getCurrentSession().get(PersonaVO.class, id);
		
	}

}
