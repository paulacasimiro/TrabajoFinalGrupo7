package ar.edu.unju.edm.controller;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.edm.model.*;
import ar.edu.unju.edm.service.MedicoService;


@Controller
public class MedicoController {
	private static final Log GRUPO7= LogFactory.getLog(MedicoController.class);
	
	@Autowired 
	MedicoService medicoService; 
	
	@GetMapping("/cargarMedico")
    	public ModelAndView mostrarFormulario(@RequestParam("matricula") Optional<Integer> matricula) {
        	Optional<Medico> optMedico = matricula.map(medicoService::recuperarMedico).orElse(Optional.of(new Medico()));
        	Medico medico = optMedico.get(); // .orElse(null);
        	ModelAndView nuevo = new ModelAndView("formularioMedico");
        	nuevo.addObject("medico", medico);

        	return nuevo;
	}
	
	@GetMapping("/modificarMedico/{matricula}")
	public ModelAndView getFormEditMovie(@PathVariable(name="matricula") Integer matricula) {
		ModelAndView modelAndView = new ModelAndView("formularioMedico");
		
		try {
			modelAndView.addObject("medicoModificar", medicoService.listarUnMedico(matricula));
		}catch (Exception e) {
			modelAndView.addObject("modificarMedicoErrorMessage", e.getMessage()); 
		}
		
		modelAndView.addObject("band", true);
		
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
	
	@PostMapping(value="/guardarMedico")
	public ModelAndView guardarProducto(@ModelAttribute("formularioMedico") Medico medicoConDatos) {
		ModelAndView nuevo= new ModelAndView ("listadoMedico"); 
		medicoService.cargarMedico(medicoConDatos);
		nuevo.addObject("listadoMedico", medicoService.listarTodosMedicos()); 
		
		return nuevo;
	} 
	
	
}