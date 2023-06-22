package ar.edu.unju.edm.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Servicio;
import ar.edu.unju.edm.service.MedicoService;
import ar.edu.unju.edm.service.ServicioService;
import jakarta.validation.Valid;

@Controller
public class ServicioController {
	private static final Log G7=  LogFactory.getLog(ServicioController.class);

	
	@Autowired 
	ServicioService servicioService; 
	
	@Autowired 
	MedicoService medicoService; 
	
	@Autowired 
	Servicio unServicio; 
	
	@Autowired
	private List<Servicio> servicios;
	
	@GetMapping ("/servicio")
	public ModelAndView cargarServicio () {
		ModelAndView form= new ModelAndView ("formularioServicio"); 
		form.addObject("servicio", unServicio); 
		form.addObject("medico", medicoService.listarTodosMedicos());
		
		return form; 
		
	}
	/*@PostMapping ("/guardarServicio")
	public ModelAndView guardarServicio (@ModelAttribute ("servicio") Servicio servicioConDatos) {
		ModelAndView listado=new ModelAndView ("listadoServicio"); 
		servicioService.cargarServicio(servicioConDatos); 
		listado.addObject("listadoServicio", servicioService.listarTodosServicios()); 
		return listado; 
	}*/

	@PostMapping("/guardarServicio")
	public ModelAndView guardarServicio(@Valid @ModelAttribute("servicio") Servicio servicioConDatos, BindingResult result) {
		if(result.hasErrors()) {
			G7.error(result.getAllErrors());
			ModelAndView cargarServicio= new ModelAndView ("formularioServicio"); 
			cargarServicio.addObject("servicio", servicioConDatos); 
			cargarServicio.addObject ("medico", medicoService.listarTodosMedicos());
		
			return cargarServicio;
		}
		ModelAndView listarServicio = new ModelAndView("listadoServicio");
		G7.warn("mostrando servicio"+servicioConDatos.getNombreServicio());
		try {
			servicioService.cargarServicio(servicioConDatos);
		}catch(Exception e) {}
		listarServicio.addObject("listadoServicio",servicioService.listarTodosServicios());
		
		return listarServicio;
		
	}
}
