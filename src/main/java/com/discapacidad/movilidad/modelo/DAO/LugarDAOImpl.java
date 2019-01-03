package com.discapacidad.movilidad.modelo.DAO;

import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.discapacidad.movilidad.modelo.VO.LugarVO;

@Repository
public class LugarDAOImpl implements LugarDAO {

	
	@Autowired
	private SessionFactory mySessionFactory;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/*private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void init(DataSource MydataSource){
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(MydataSource);
	}*/
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.mySessionFactory = sessionFactory;
    }
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<LugarVO> listaLugarPorCategoria(int categoria) {
		// TODO Auto-generated method stub
		List<LugarVO> lista = null;
		String sql = "select a.* from lugar as a inner join categoria_lugar as b on a.id = b.id_lugar inner join categoria as c on b.id_categoria = c.id";
		
		lista = jdbcTemplate.query(sql, new BeanPropertyRowMapper(LugarVO.class));
		
        
		return lista;
	}

}
