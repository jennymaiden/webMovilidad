package com.discapacidad.movilidad.modelo.DAO;

import java.util.HashMap;
import java.util.List;

public interface GeneralDAO  <T>{
    
    List<T> ListarTodos();
    List<T> ListarTodos(Integer max,Integer first);
    void guardar(T objeto);
    void actualizar(T objeto);
    
    T buscarPor(Object id);
    T queryOpjectJpa(String queryString,HashMap<String,Object> parametros);
    List<T> queryJpa(String query,HashMap<String,Object> parametros);
    String selectJdbTemplate(String parametros, String tabla, String condiciones);
    String updateJdbTemplate(String parametros, String tabla, String condiciones);
    String insertJdbTemplate(String parametros, String tabla, String condiciones);
    String deleteJdbTemplate(String tabla, String condiciones);   
    String addInsertJdtbTemplate(String values1,String values2,int iteracion);

}