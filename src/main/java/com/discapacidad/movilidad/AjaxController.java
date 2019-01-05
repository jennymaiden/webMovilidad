package com.discapacidad.movilidad;



import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.discapacidad.movilidad.modelo.VO.CategoriaVO;
import com.discapacidad.movilidad.modelo.VO.LugarVO;
import com.discapacidad.movilidad.servicio.MovilidadServicio;

@Controller
public class AjaxController {

	
	@Autowired
	public MovilidadServicio serviciomMovilidad;

	protected final Log logger = LogFactory.getLog(getClass());

	
	@ResponseBody
	@RequestMapping(value = "/ajaxMovilidad")
	public String getSearchResultViaAjax( HttpServletResponse response, HttpServletRequest request) {
		
		//PrintWriter out;
		JSONObject respuesta = new JSONObject();
		String json = request.getParameter("funcion");
		System.out.println("JSON:::."+json);
		if(!json.equals("null") && !json.equals("")){
			try{
				JSONObject objeto = new JSONObject(json);
				 switch (objeto.getInt("funcion")) {
				 
				 	case 1://Buscar los lugares por la categoria
				 		//System.out.println("El id de categoria es:.."+objeto.getInt("categoria"));
				 		List<LugarVO> lista = serviciomMovilidad.listarLugaresPorCategoria(objeto.getInt("categoria"));
				 		
				 		String array = "[";
				 		for(int indice = 0;indice<lista.size();indice++)
				 		{
				 			String separador = ",";
				 			if(indice ==(lista.size() -1) ){
				 				System.out.println(":::::::: Entro en indice igual al tamaño de lista::::::::::::");
				 				separador = "";
				 			}
				 			
				 			array+=lista.get(indice).toString()+separador;
				 		}
				 		 
				 		array += "]";  
				 		
				 		respuesta.put("lugar", array);
				          
				 		break;
				 	case 2: //Volver a mostrar las categorias
				 		
				 		List<CategoriaVO> categorias = serviciomMovilidad.mostrarCategorias();
				 		
				 		respuesta.put("categorias", categorias.toString());
				 		break;
				 }
			}catch(Exception error){
				logger.error("Se genero un error en el ajax a la hora de parsear el json::::::"+error);
			}
			
			
		}

		
		return respuesta.toString();

	}
}
