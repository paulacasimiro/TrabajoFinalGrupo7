package ar.edu.unju.edm.controller;

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


import ar.edu.unju.edm.model.*;
import ar.edu.unju.edm.service.EspecialidadService;
import ar.edu.unju.edm.service.MedicoService;
import jakarta.validation.Valid;


@Controller
public class MedicoController {
	private static final Log G7=  LogFactory.getLog(MedicoController.class);
	
	@Autowired 
	MedicoService medicoService; 
	
	//@Qualifier("MedicoServiceMySQL")
	@Autowired
	EspecialidadService especialidadService; 
	
	@Autowired
	Medico unMedico;
	
	
	@GetMapping("/medico")
	public ModelAndView cargarMedico(){
		ModelAndView modelAndView = new ModelAndView("formularioMedico.html");
		modelAndView.addObject("medico", unMedico);
		modelAndView.addObject ("especialidad", especialidadService.listarTodasEspecialidades());
		modelAndView.addObject("band", false);
				
		return modelAndView;
	}

	/*@PostMapping("/guardarMedico")
	public ModelAndView guardarMedico(@ModelAttribute("medico") Medico medicoConDatos) {
		ModelAndView nuevo= new ModelAndView ("listadoMedico"); 
		medicoService.cargarMedico(medicoConDatos);
		nuevo.addObject("listadoMedico", medicoService.listarTodosMedicos()); 
		
		return nuevo;
	}*/
	
	@PostMapping("/guardarMedico")
	public ModelAndView guardarMedico(@Valid @ModelAttribute("medico") Medico medicoConDatos, BindingResult result) {
		if(result.hasErrors()) {
			G7.error(result.getAllErrors());
			ModelAndView cargarMedico= new ModelAndView ("formularioMedico"); 
			cargarMedico.addObject("medico", medicoConDatos); 
			cargarMedico.addObject ("especialidad", especialidadService.listarTodasEspecialidades());
			cargarMedico.addObject("band", false);
			return cargarMedico;
		}
		ModelAndView listarMedico = new ModelAndView("listadoMedico");
		G7.warn("mostrando medico"+medicoConDatos.getNombreApellido());
		try {
			medicoService.cargarMedico(medicoConDatos);
		}catch(Exception e) {}
		listarMedico.addObject("listadoMedico",medicoService.listarTodosMedicos());
		
		return listarMedico;
		
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
	public String otroeliminarMedico (@PathVariable (name = "matricula") Integer matricula, Model model) {
 
		try {
			medicoService.eliminarMedico(matricula);
		}catch (Exception e) {
			model.addAttribute("eliminarMedicoErrorMessage", e.getMessage()); 
		}	
		return "redirect:/listadoMedico";
	
	}
	@GetMapping ("/listadoMedico")
	public ModelAndView mostrarMedico() {
		ModelAndView form= new ModelAndView ("listadoMedico"); 
		form.addObject("listadoMedico", medicoService.listarTodosMedicos());
		return form; 
		
	}	
	
}