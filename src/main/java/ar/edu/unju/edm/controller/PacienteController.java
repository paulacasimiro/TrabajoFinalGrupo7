package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.edm.model.*;
import ar.edu.unju.edm.service.PacienteService;


@Controller
public class PacienteController {
	
	@Autowired 
	PacienteService pacienteService; 
	
	@Autowired 
	Paciente unPaciente; 
	 
	 @GetMapping("/paciente")
	public ModelAndView registrarPaciente(){
		ModelAndView modelAndView = new ModelAndView("formularioPaciente");
		modelAndView.addObject("paciente", unPaciente);
		modelAndView.addObject("band", false);
				
		return modelAndView;
	}
 
	@PostMapping("/guardarPaciente")
	public ModelAndView guardarPaciente(@ModelAttribute("paciente") Paciente pacienteConDatos) {
		ModelAndView lista= new ModelAndView ("MostrarPacientes"); 
		pacienteService.registrarPaciente(pacienteConDatos);
		lista.addObject("listadoPaciente", pacienteService.listarTodoslosPacientes()); 
		
		return lista;
	} 
	   
    @GetMapping("/editarPaciente/{codigo}")
 	public ModelAndView editarPaciente(@PathVariable(name="codigo") Integer codigo) {
 		ModelAndView modelAndView = new ModelAndView("formularioPaciente");
 		
 		try {
 			modelAndView.addObject("paciente",pacienteService.listarUnPaciente(codigo));
 		}catch (Exception e) {
 			modelAndView.addObject("modificarPacienteErrorMessage", e.getMessage()); 
 		}
 		
 		modelAndView.addObject("band", true);
 		
 		return modelAndView;
 	}
      
    @PostMapping("/modificarPaciente")
	public ModelAndView modificarPaciente(@ModelAttribute("codigo") Paciente pacienteConDatos) {
		ModelAndView modelAndView= new ModelAndView ("MostrarPacientes"); 
		pacienteService.registrarPaciente(pacienteConDatos);
		modelAndView.addObject("listadoPaciente", pacienteService.listarTodoslosPacientes()); 
		
		return modelAndView;
	} 

	@GetMapping("/eliminarPaciente/{codigo}")
	public String eliminarPaciente (@PathVariable (name = "codigo") Integer codigo, Model model) {
 
		try {
			pacienteService.eliminarPaciente(codigo);
		}catch (Exception e) {
			model.addAttribute("eliminarPacienteErrorMessage", e.getMessage()); 
		}	
		return "redirect:/listadoPaciente";
	
	}
    
	@GetMapping ("/listadoPaciente")
	public ModelAndView mostrarPaciente() {
		ModelAndView form= new ModelAndView ("MostrarPacientes"); 
		form.addObject("listadoPaciente", pacienteService.listarTodoslosPacientes());
		return form; 
		
	}	  

}