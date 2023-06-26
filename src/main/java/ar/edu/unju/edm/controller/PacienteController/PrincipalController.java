package ar.edu.unju.edm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Paciente;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
@Controller
public class PrincipalController {

	@Autowired
	Paciente usuariopaciente;
	
	@GetMapping({"/","/principal","/home","/login"})
	public ModelAndView cargarPrincipal(){
		//
		ModelAndView modelAndView = new ModelAndView("princi");
		modelAndView.addObject("usuario",usuariopaciente);
		return modelAndView;
	}
	
	
}
