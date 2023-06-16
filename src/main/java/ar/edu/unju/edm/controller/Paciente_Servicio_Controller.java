package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.edm.model.Paciente_Servicio;
import ar.edu.unju.edm.service.PacienteService;
import ar.edu.unju.edm.service.PacienteServicio_Service;
import ar.edu.unju.edm.service.ServicioService;

@Controller
public class Paciente_Servicio_Controller {

	@Autowired 
	PacienteService pacienteService; 
	
	@Autowired 
	ServicioService serv_Service; 
	
	@Autowired 
	PacienteServicio_Service pss; 
	 
	@Autowired 
	Paciente_Servicio paci_serv; 
	 
	 @GetMapping("/pacienteServicio")
	public ModelAndView registrarPacienteServicio(){
		ModelAndView modelAndView = new ModelAndView("formularioPacienteServicio");
		modelAndView.addObject("reserva",paci_serv);
		modelAndView.addObject("pacientes",pacienteService.listarTodoslosPacientes() );
		modelAndView.addObject("servicios",serv_Service.listarTodosServicios() );	
		return modelAndView;
	}
 
	@PostMapping("/guardarPacienteServicio")
	public ModelAndView guardarPacienteServicio(@ModelAttribute("reserva") Paciente_Servicio PacienteServicioConDatos) {
		ModelAndView lista= new ModelAndView ("listadeturnos"); 
		pss.registrarPaciente_Servicio(PacienteServicioConDatos);
		lista.addObject("listadeturnos", pss.listarTodoslosPaciente_Servicios()); 
		
		return lista;
	} 
	

	
}
