package com.discapacidad.movilidad;



import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.discapacidad.movilidad.modelo.VO.LugarVO;
import com.discapacidad.movilidad.servicio.MovilidadServicio;

@Controller
public class AjaxController {

	
	@Autowired
	public MovilidadServicio serviciomMovilidad;
	
	@ResponseBody
	@RequestMapping(value = "/ajaxMovilidad")
	public String getSearchResultViaAjax( HttpServletResponse response, HttpServletRequest request) {
		
		//PrintWriter out;
		JSONObject respuesta = new JSONObject();
		String json = request.getParameter("funcion");
		System.out.println("JSON:::."+json);
		if(!json.equals("null") && !json.equals("")){
			JSONObject objeto = new JSONObject(json);
			 switch (objeto.getInt("funcion")) {
			 
			 	case 1://Buscar los lugares por la categoria
			 		System.out.println("El id de categoria es:.."+objeto.getInt("categoria"));
			 		List<LugarVO> lista = serviciomMovilidad.listarLugaresPorCategoria(objeto.getInt("categoria"));
			 		System.out.println(":::::::tamanio:::::::"+lista.size());
			 		
			 		for (Iterator iterator = lista.iterator(); iterator.hasNext();){
			        	//System.out.println(":::::::::::::::::::objeto en STRING:::::::::::::::::"+iterator.next().toString());
			 			
			        	respuesta.put("lugar", iterator.next().toString());
			        	LugarVO Lugar = (LugarVO) iterator.next(); 
			        	
			        }
			        
			 		break;
			 }
			
		}

		
		return respuesta.toString();

	}
}
