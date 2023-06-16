package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.edm.model.*;
import ar.edu.unju.edm.service.EspecialidadService;
import ar.edu.unju.edm.service.MedicoService;


@Controller
public class MedicoController {
	//private static final Log GRUPO7=  LogFactory.getLog(MedicoController.class);
	
	@Autowired 
	MedicoService medicoService; 
	@Autowired
	EspecialidadService especialidadService; 
	@Autowired
	Medico unMedico;
	
	@GetMapping("/medico")
	public ModelAndView cargarMedico(){
		ModelAndView modelAndView = new ModelAndView("formularioMedico");
		modelAndView.addObject("medico", unMedico);
		modelAndView.addObject ("especialidad", especialidadService.listarTodasEspecialidades());
		modelAndView.addObject("band", false);
				
		return modelAndView;
	}

	@PostMapping("/guardarMedico")
	public ModelAndView guardarMedico(@ModelAttribute("medico") Medico medicoConDatos) {
		ModelAndView nuevo= new ModelAndView ("listadoMedico"); 
		medicoService.cargarMedico(medicoConDatos);
		nuevo.addObject("listadoMedico", medicoService.listarTodosMedicos()); 
		
		return nuevo;
	} 
	
	@GetMapping("/editarMedico/{matricula}")
	public ModelAndView getFormMovie(@PathVariable(name="matricula") Integer matricula) {
		ModelAndView modelAndView = new ModelAndView("formularioMedico");
		
		try {
			modelAndView.addObject("medico", medicoService.listarUnMedico(matricula));
			modelAndView.addObject ("especialidad", especialidadService.listarTodasEspecialidades());
		}catch(Exception e) {
			modelAndView.addObject("modificarMedicoErrorMessage", e.getMessage());
		}

		modelAndView.addObject("band", true);
		
		return modelAndView;
	}
	
	@PostMapping("/modificarMedico")
	public ModelAndView modificarMedico(@ModelAttribute("medico") Medico medicoConDatos) {
		ModelAndView modelAndView= new ModelAndView ("listadoMedico"); 
		medicoService.cargarMedico(medicoConDatos);
		modelAndView.addObject("listadoMedico", medicoService.listarTodosMedicos()); 
		
		return modelAndView;
	} 
	
	@GetMapping("/eliminarMedico/{matricula}")
	public ModelAndView eliminarMedico (@PathVariable (name = "matricula") Integer matricula) {
		ModelAndView nuevo= new ModelAndView ("listadoMedico"); 
		try {
			medicoService.eliminarMedico(matricula); 
		}catch (Exception e) {
			nuevo.addObject("eliminarMedicoErrorMessage", e.getMessage()); 
		}
		
		try {
			nuevo.addObject("listadoMedico", medicoService.listarTodosMedicos()); 
		}catch (Exception e) {
			nuevo.addObject("eliminarMedicoErrorMessage", e.getMessage()); 
			
		}
		return nuevo;
		
	}

}