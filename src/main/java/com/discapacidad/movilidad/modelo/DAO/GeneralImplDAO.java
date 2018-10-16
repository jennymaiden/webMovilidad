package com.discapacidad.movilidad.modelo.DAO;

import java.util.HashMap;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.discapacidad.movilidad.modelo.VO.PersonaVO;

@Repository
public class GeneralImplDAO<T> implements GeneralDAO<T> {

	@Autowired
	public SessionFactory mySessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.mySessionFactory = sessionFactory;
    }
	
	public List<T> ListarTodos() {
		List<T> lista = (List<T>) getCurrentSession().createQuery("from Book").list();

		return null;
	}

	public List<T> ListarTodos(Integer max, Integer first) {
		// TODO Auto-generated method stub
		return null;
	}

	public void guardar(T objeto) {
		// TODO Auto-generated method stub
		
	}

	public void actualizar(T objeto) {
		// TODO Auto-generated method stub
		
	}

	public T buscarPor(Object id) {
		return (T) mySessionFactory.getCurrentSession().get(Class <T>, id);
		
	}

	public T queryOpjectJpa(String queryString, HashMap<String, Object> parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> queryJpa(String query, HashMap<String, Object> parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	public String selectJdbTemplate(String parametros, String tabla, String condiciones) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateJdbTemplate(String parametros, String tabla, String condiciones) {
		// TODO Auto-generated method stub
		return null;
	}

	public String insertJdbTemplate(String parametros, String tabla, String condiciones) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteJdbTemplate(String tabla, String condiciones) {
		// TODO Auto-generated method stub
		return null;
	}

	public String addInsertJdtbTemplate(String values1, String values2, int iteracion) {
		// TODO Auto-generated method stub
		return null;
	}

}
