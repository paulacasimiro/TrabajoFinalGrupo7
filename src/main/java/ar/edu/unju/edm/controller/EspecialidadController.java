package ar.edu.unju.edm.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Especialidad;
import ar.edu.unju.edm.model.Medico;
import ar.edu.unju.edm.service.EspecialidadService;

@Controller
public class EspecialidadController {
	private static final Log G7=  LogFactory.getLog(MedicoController.class);
	
	@Autowired 
	EspecialidadService especialidadSer; 
	@Autowired 
	Especialidad unaEsp; 
	
	@GetMapping ("/especialidad")
	public ModelAndView cargarEspecialidad () {
		ModelAndView form= new ModelAndView ("formulario"); 
		form.addObject("especialidad", unaEsp); 
		form.addObject("band", false);
		return form; 
		
	}
	@PostMapping ("/guardarEspecialidad")
	public ModelAndView guardarEspecialidad (@ModelAttribute ("especialidad") Especialidad especialidadConDatos) {
		ModelAndView listado=new ModelAndView ("listado"); 
		especialidadSer.cargarEspecialidad(especialidadConDatos); 
		listado.addObject("listado", especialidadSer.listarTodasEspecialidades()); 
		return listado; 
	}
	
	/*@PostMapping("/guardarEspecialidad")
	public ModelAndView guardarEspecialidad(@Valid @ModelAttribute("especialidad") Especialidad especialidadConDatos, BindingResult result) {
		if(result.hasErrors()) {
			G7.error(result.getAllErrors());
			ModelAndView cargarEspecialidad= new ModelAndView ("formulario"); 
			cargarEspecialidad.addObject("especialidad", especialidadConDatos); 
			cargarEspecialidad.addObject("band", false);
			return cargarEspecialidad;
		}
		ModelAndView listarEspecialidad = new ModelAndView("listado");
		G7.warn("mostrando especialidad"+especialidadConDatos.getNombre());
		try {
			especialidadSer.cargarEspecialidad(especialidadConDatos);
		}catch(Exception e) {}
		listarEspecialidad.addObject("listadoMedico", especialidadSer.listarTodasEspecialidades());
		
		return listarEspecialidad;
		
	}*/
	
	@GetMapping ("/editarEspecialidad/{codigo}")
	public ModelAndView editarEspecialidad (@PathVariable (name = "codigo") Integer codigo) {
		ModelAndView modificacion=new ModelAndView ("formulario"); 
		
		try {
			modificacion.addObject("especialidad", especialidadSer.listarUnaEspecialidad(codigo)); 
		}catch (Exception e) {
			modificacion.addObject("modificarEspecialidadErrorMessage", e.getMessage()); 
		}
		modificacion.addObject("band", true);
		
		return modificacion; 
	}
	@PostMapping ("/modificarEspecialidad")
	public ModelAndView modificarEspecialidad (@ModelAttribute ("especialidad") Especialidad especialidadConDatos) {
		ModelAndView modelAndview=new ModelAndView ("listado"); 
		especialidadSer.cargarEspecialidad(especialidadConDatos); 
		modelAndview.addObject("listado", especialidadSer.listarTodasEspecialidades()); 
		return modelAndview; 
	}
	/*@GetMapping("/eliminarEspecialidad/{codigo}")
	public ModelAndView eliminarProducto (@PathVariable (name = "codigo") Integer codigo) {
		ModelAndView nuevo= new ModelAndView ("listado"); 
		try {
			especialidadSer.eliminarEspecialidad(codigo); 
		}catch (Exception e) {
			nuevo.addObject("eliminarEspecialidadErrorMessage", e.getMessage()); 
		}
		
		try {
			nuevo.addObject("listado", especialidadSer.listarTodasEspecialidades()); 
		}catch (Exception e) {
			nuevo.addObject("eliminarEspecialidadErrorMessage", e.getMessage()); 
			
		}
		return nuevo;
		
	}*/
	//otra manera de hacer elimnar
		@GetMapping("/eliminarEspecialidad/{codigo}")
		public String otroeliminarProducto (@PathVariable (name = "codigo") Integer codigo, Model model) {
			//ModelAndView nuevo= new ModelAndView ("listado"); 
			try {
				especialidadSer.eliminarEspecialidad(codigo); 
			}catch (Exception e) {
				model.addAttribute("eliminarEspecialidadErrorMessage", e.getMessage()); 
			}	
			return "redirect:/listado";
			
		}
	
		@GetMapping ("/listado")
		public ModelAndView mostrarEspecialidad() {
			ModelAndView form= new ModelAndView ("listado"); 
			//form.addObject("especialidad", unaEsp); 
			//form.addObject("band", false);
			form.addObject("listado", especialidadSer.listarTodasEspecialidades());
			return form; 
			
		}	
}
