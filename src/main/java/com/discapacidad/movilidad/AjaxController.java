package com.discapacidad.movilidad;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.discapacidad.movilidad.servicio.MovilidadServicio;

@Controller
public class AjaxController {

	
	@Autowired
	public MovilidadServicio serviciomMovilidad;
	
	@ResponseBody
	@RequestMapping(value = "/ajaxMovilidad")
	public String getSearchResultViaAjax( HttpServletResponse response, HttpServletRequest request) {
		
		//PrintWriter out;
		JSONObject objeto = new JSONObject();
		String json = request.getParameter("funcion");
		System.out.println("JSON:::."+json);
		if(!json.equals("null") && !json.equals("")){
			objeto = new JSONObject(json);
			 switch (objeto.getInt("funcion")) {
			 
			 	case 1://Buscar los lugares por la categoria
			 		System.out.println("El id de categoria es:.."+objeto.getInt("categoria"));
			 		serviciomMovilidad.listarLugaresPorCategoria(objeto.getInt("categoria"));
			 		break;
			 }
			
		}
			System.out.println("Lo que envia el ajax es data:....."+request.getParameter("funcion"));

		
		return objeto.toString();

	}
}
