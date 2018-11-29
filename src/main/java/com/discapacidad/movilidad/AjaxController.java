package com.discapacidad.movilidad;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

	@ResponseBody
	@RequestMapping(value = "/ajaxMovilidad")
	public String getSearchResultViaAjax( HttpServletResponse response, HttpServletRequest request) {
		
		//PrintWriter out;
		JSONObject objeto = new JSONObject();
		String json = request.getParameter("funcion");
		if(!json.equals("null") && !json.equals("")){
			objeto = new JSONObject(json);
			 switch (objeto.getInt("funcion")) {
			 
			 	case 1:
			 		
			 		break;
			 }
			
		}
			System.out.println("Lo que envia el ajax es data:....."+request.getParameter("funcion"));

		
		return objeto.toString();

	}
}
