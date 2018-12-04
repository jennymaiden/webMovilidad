package com.discapacidad.movilidad.modelo.DAO;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.discapacidad.movilidad.modelo.VO.LugarVO;

@Repository
public class LugarDAOImpl implements LugarDAO {

	
	@Autowired
	public SessionFactory mySessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.mySessionFactory = sessionFactory;
    }
	
	@Transactional
	public List<LugarVO> listaLugarPorCategoria(int categoria) {
		// TODO Auto-generated method stub
		List<LugarVO> lista = null;
		String sql = "select a.* from lugar as a inner join categoria_lugar as b on a.id = b.id_lugar inner join categoria as c on b.id_categoria = c.id";
		
		List employees = mySessionFactory.getCurrentSession().createSQLQuery(sql).list(); 
        for (Iterator iterator = employees.iterator(); iterator.hasNext();){
        	System.out.println("la respuesta es:..."+iterator.next().toString());
        	LugarVO Lugar = (LugarVO) iterator.next(); 
           System.out.print("Nombre: " + Lugar.getNombre()); 
           System.out.print("  Latitud: " + Lugar.getLatitud()); 
          
        }
        
		return lista;
	}

}
