package ar.edu.unju.edm.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.edm.model.*;
import ar.edu.unju.edm.service.PacienteService;


@Controller
public class PacienteController {
	
	@Autowired 
	PacienteService pacienteService; 
	
	@Autowired 
	Paciente unPaciente; 
	 
     @GetMapping("/registrodepaciente")
    	public ModelAndView mostrarFormulario(@RequestParam("codigo") Optional<Integer> codigo) {
        	Optional<Paciente> optPaciente = codigo.map(pacienteService::modificarPaciente).orElse(Optional.of(new Paciente()));
		Paciente paciente = optPaciente.get(); // .orElse(null);
		ModelAndView registroPaciente = new ModelAndView("formularioPaciente");
		registroPaciente.addObject("paciente", paciente);

        	return registroPaciente;
	}
	
     
    @GetMapping("/modificarPaciente/{codigo}")
 	public ModelAndView getFormEditMovie(@PathVariable(name="codigo") Integer codigo) {
 		ModelAndView modelAndView = new ModelAndView("formularioPaciente");
 		
 		try {
 			modelAndView.addObject("pacienteModificar",pacienteService.listarUnPaciente(codigo));
 		}catch (Exception e) {
 			modelAndView.addObject("modificarPacienteErrorMessage", e.getMessage()); 
 		}
 		
 		modelAndView.addObject("band", true);
 		
 		return modelAndView;
 	}
     
      @GetMapping("/eliminarPaciente/{codigo}")
	public ModelAndView eliminarPaciente (@PathVariable (name = "codigo") Integer codigo) {
		ModelAndView nuevo= new ModelAndView ("MostrarPacientes"); 
		try {
			pacienteService.eliminarPaciente(codigo); 
		}catch (Exception e) {
			nuevo.addObject("eliminarPacienteErrorMessage", e.getMessage()); 
		}
		
		try {
			nuevo.addObject("listado", pacienteService.listarTodoslosPacientes()); 
		}catch (Exception e) {
			nuevo.addObject("eliminarPacienteErrorMessage", e.getMessage()); 
			
		}
		return nuevo;
		
	}
    
      @PostMapping("/registrarPaciente")
	public ModelAndView registrarPaciente(@ModelAttribute("formularioPaciente") Paciente PacienteconDatos) {
		ModelAndView nuevo= new ModelAndView ("MostrarPacientes"); 
		pacienteService.registrarPaciente(PacienteconDatos);
		nuevo.addObject("listado", pacienteService.listarTodoslosPacientes()); 
		return nuevo;
	}  

}