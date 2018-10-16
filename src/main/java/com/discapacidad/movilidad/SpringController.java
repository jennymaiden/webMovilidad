/**
 * 
 */
package com.discapacidad.movilidad;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.discapacidad.movilidad.modelo.VO.PersonaVO;
import com.discapacidad.movilidad.servicio.SesionServicio;
/**
 * @author Carolina
 *
 */
@Controller
public class SpringController {
	
	@Autowired
	public SesionServicio servicioSesion;
	
	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String pay_confirmation(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		logger.info("Returning hello view");
        model.addAttribute("title", "Health Mov -Login");
        
		/*ModelAndView model= new ModelAndView("index");
		logger.info("Returning hello view");
		model.addObject("title", "Health Mov");*/
		
		return "index";
	}
	
	@RequestMapping(value = "/unete", method = RequestMethod.GET)
    public String handleRequest(Model model,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        model.addAttribute("title", "Health Mov -Login");
        
        System.out.println("**************");
        System.out.println("Buscar lalista de discapacidad");
        servicioSesion.buscarPersonaId(1);
        return "login";
    }
	
	
	
	@RequestMapping(value = "/acercaDeNosotros", method = RequestMethod.GET)
    public String asercaDe(Model model,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
			System.out.println("**************");
        logger.info("Returning hello view");
        model.addAttribute("title", "Health Mov -Acerca de nosotros");
        return "acercaDe";
    }
	
	@RequestMapping(value = "/servicios", method = RequestMethod.GET)
    public String servicios(Model model,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
			System.out.println("**************");
        logger.info("Returning hello view");
        model.addAttribute("title", "Health Mov -Servicios");
        return "Servicios";
    }
	
	@RequestMapping(value = "/noticias", method = RequestMethod.GET)
    public String noticias(Model model,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
			System.out.println("**************");
        logger.info("Returning hello view");
        model.addAttribute("title", "Health Mov -Noticias");
        return "noticias";
    }
	
	/**
	 * Metodo para el subtmit del formulario de registro de la pataforma**/
	@RequestMapping(value = "/formularioInicio", method = RequestMethod.POST)
    public String postRegistro(Model model,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
			System.out.println("**************");
        logger.info("Entro al formulario de registro");
        
        PersonaVO objPersona = servicioSesion.mapearFormularioResistro(request);
        
        //armar el objeto de persona
        
        return "noticias";
    }

}
