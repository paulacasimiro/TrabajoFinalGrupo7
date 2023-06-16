package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Servicio;
import ar.edu.unju.edm.service.MedicoService;
import ar.edu.unju.edm.service.PacienteService;
import ar.edu.unju.edm.service.ServicioService;

@Controller
public class ServicioController {
	@Autowired 
	ServicioService servicioService; 
	
	@Autowired 
	PacienteService pacienteService; 
	
	@Autowired 
	MedicoService medicoService; 
	
	@Autowired 
	Servicio unServicio; 
	
	@GetMapping ("/servicio")
	public ModelAndView cargarServicio () {
		ModelAndView form= new ModelAndView ("formularioServicio"); 
		form.addObject("servicio", unServicio); 
		form.addObject("paciente", pacienteService.listarTodoslosPacientes()); 
		form.addObject("medico", medicoService.listarTodosMedicos());
		
		return form; 
		
	}
	@PostMapping ("/guardarServicio")
	public ModelAndView guardarServicio (@ModelAttribute ("servicio") Servicio servicioConDatos) {
		ModelAndView listado=new ModelAndView ("listadoServicio"); 
		servicioService.cargarServicio(servicioConDatos); 
		listado.addObject("listadoServicio", servicioService.listarTodosServicios()); 
		return listado; 
	}

	
}
