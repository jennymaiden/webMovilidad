/**
 * 
 */
package com.discapacidad.movilidad;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.discapacidad.movilidad.modelo.VO.FormLugarVO;
import com.discapacidad.movilidad.modelo.VO.ImagenLugarVO;
import com.discapacidad.movilidad.modelo.VO.LugarVO;
import com.discapacidad.movilidad.modelo.VO.PersonaVO;
import com.discapacidad.movilidad.servicio.MovilidadServicio;
import com.discapacidad.movilidad.servicio.SesionServicio;
/**
 * @author Carolina
 *
 */
@Controller
public class SpringController {
	
	@Autowired
	public SesionServicio servicioSesion;
	
	@Autowired
	public MovilidadServicio serviciomMovilidad;
	
	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String paginaInicio(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		logger.info("Returning hello view");
        model.addAttribute("title", "Health Mov -Login");
        servicioSesion.validacionSesion(request, model);
		
		return "index";
	}
	

	@RequestMapping(value = "/acercaDeNosotros", method = RequestMethod.GET)
    public String asercaDe(Model model,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
        model.addAttribute("title", "Health Mov -Acerca de nosotros");
        servicioSesion.validacionSesion(request, model);
        
        return "acercaDe";
    }
	
	@RequestMapping(value = "/servicios", method = RequestMethod.GET)
    public String servicios(Model model,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
			
        model.addAttribute("title", "Health Mov -Servicios");
        servicioSesion.validacionSesion(request, model);
        
        return "Servicios";
    }
	
	@RequestMapping(value = "/noticias", method = RequestMethod.GET)
    public String noticias(Model model,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
			
        model.addAttribute("title", "Health Mov -Noticias");
        servicioSesion.validacionSesion(request, model);
        return "noticias";
    }
	
	@RequestMapping(value = "/sitiosInteres", method = RequestMethod.GET)
    public String sitiosInteres(Model model,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
			
        model.addAttribute("title", "Health Mov -Sitios de interes");
        servicioSesion.validacionSesion(request, model);
        //Listar las categoias
        model.addAttribute("categorias", serviciomMovilidad.mostrarCategorias());
        
        return "sitiosInteres";
    }
	
	/**
	 * Ajax de movilidad*
	@RequestMapping(value = "/ajaxMovilidad", method = RequestMethod.POST)
    public JSONObject ajaxMovilidad(@RequestBody JSONObject obj,Model model,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
			
        System.out.println("Lo que envia el ajax es data:....."+request.getParameter("data"));
        System.out.println("Lo que envia el ajax es categoria:....."+request.getParameter("categoria"));
        //
        System.out.println("Respuesta:::..."+obj.get("categoria"));
        JSONObject obj2 = new JSONObject();
        
        obj.put("llave", "valor");
        return obj2;
    }*/
	
	
	
	@RequestMapping(value = "/unete", method = RequestMethod.GET)
    public String paginaUnete(Model model,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        model.addAttribute("title", "Health Mov -Login");
        servicioSesion.validacionSesion(request, model);
        //servicioSesion.buscarPersonaId(1);
        model.addAttribute("discapacidades", servicioSesion.selectDiscapacitad());
        model.addAttribute("activeRegistro","active show");
    	model.addAttribute("activeIngresa","");
    	
        String msg = "";
        System.out.println("Parametro que llega:..."+request.getParameter("res"));
        if(request.getParameter("res") != null){
        	if(request.getParameter("res").equals("true")){
            	msg ="Se guardo correctamente";
            }else if(request.getParameter("res").equals("false")){
            	msg = "No se puede hacer el registro de la persona";
            }
        	model.addAttribute("activeRegistro","active show");
        	model.addAttribute("activeIngresa","");
        }
        
        //Autenticacion
        
        System.out.println("Autenticacion:..."+request.getParameter("login"));
        if(request.getParameter("login") != null){
        	if(request.getParameter("login").equals("true")){
            	msg ="Se pudo autenticar";
            }else if(request.getParameter("login").equals("false")){
            	msg = "Usario y/o contraseña invalido, vuelva a intentarlo";
            }
        	model.addAttribute("activeIngresa","active show");
        	model.addAttribute("activeRegistro","");
        }
        
        
        
        model.addAttribute("validar", msg);
        return "login";
    }
	
	/**
	 * Metodo para el subtmit del formulario de registro de la pataforma**/
	@RequestMapping(value = "/formularioInicio", method = RequestMethod.POST)
    public String postRegistro(Model model,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
			
        logger.info("Entro al formulario de registro");
        //validar que los datos sean correctos y que el usuario no se encuentr en la bd
        PersonaVO objPersona = servicioSesion.mapearFormularioResistro(request);
        String msn = "";
        System.out.println("El nombre es:......"+objPersona.getNombre());
        if(objPersona.getNombre() != null && !objPersona.getNombre().equals("")){
        	System.out.println("Puede guardar::::::::");
        	servicioSesion.guardarPersona(objPersona);
        	msn = "true";
        }else{
        	System.out.println("No debe guardar ***************");
        	msn="false";
        }
        System.out.println("mapeo la persona:..."+objPersona.getNombre());
        //System.out.println("Guardar persona****");
        //
        model.addAttribute("persona",objPersona);
        //armar el objeto de persona
        
        return "redirect:/unete?res="+msn;
    }
	
	/**
	 * Metodo para el subtmit del formulario de login a la plataforma y crear la sesion**/
	@RequestMapping(value = "/formularioLogin", method = RequestMethod.POST)
    public String postLogin(Model model,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
			
		String msg ="";
		PersonaVO objPersona = servicioSesion.autenticacionUSuario(request);
		if(objPersona.getNombre() != null && !objPersona.getNombre().equals("")){
			System.out.println("Usuario valido");
			HttpSession session = request.getSession();
			session.setAttribute("usr", objPersona);
			msg = "true";
		}else{
			msg = "false";
		}
        
        //armar el objeto de persona
        
        return "redirect:/unete?login="+msg;
    }
	
	/**
	 * Metodo para la vista de la administracion de los sitios **/
	@RequestMapping(value = "/administrarSitios", method = RequestMethod.GET)
	public String viewAdminPlace(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		//logger.info("Returning hello view");
        model.addAttribute("title", "Health Mov - Administracion de lugaes");
        //Consultar las categorias con sus lugares
        //servicioSesion.validacionSesion(request, model);
		if(request.getParameter("creacion")!= null && request.getParameter("creacion").equals("true") ){
			model.addAttribute("creacion", "Se creo el lugar correctamente");
		}
		model.addAttribute("imagenLugarVO", new ImagenLugarVO());
		model.addAttribute("categoriaLugar", serviciomMovilidad.listaCategoriaLugar());
		model.addAttribute("formLugarVO", new FormLugarVO());
		model.addAttribute("listCategoria", serviciomMovilidad.mostrarCategorias());
		
		return "admiSitios";
	}
	
	
	
	/**
	 * Funcion de la accion de submit del formulario de creacion de lugar**/
	@RequestMapping(value = "/formCargarArchivo", method = RequestMethod.POST)
	public String formCargarArchivo(@ModelAttribute("imagenLugarVO") ImagenLugarVO imagenLugarVO) {
		
		Boolean respuesta = false;
		
		System.out.println("El objeto que llega es::::::::::::::"+imagenLugarVO.getFichero());
		respuesta = serviciomMovilidad.cargarArchivo(imagenLugarVO);
		return "redirect:/administrarSitios?creacion="+respuesta;
	}
	
	/**
	 * Funcion de la accion de submit del formulario de creacion de lugar**/
	@RequestMapping(value = "/formEditLugar", method = RequestMethod.POST)
	public String formCrearLugar(@ModelAttribute("formLugarVO") FormLugarVO formLugaVO) {

		serviciomMovilidad.saveUpdateLugar(formLugaVO);
		
		return "redirect:/administrarSitios?creacion=true";
	}

}
