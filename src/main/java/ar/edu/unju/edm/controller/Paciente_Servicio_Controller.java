package ar.edu.unju.edm.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.edm.model.Paciente_Servicio;
import ar.edu.unju.edm.model.Servicio;
import ar.edu.unju.edm.service.PacienteService;
import ar.edu.unju.edm.service.PacienteServicio_Service;
import ar.edu.unju.edm.service.ServicioService;
import jakarta.validation.Valid;

@Controller
public class Paciente_Servicio_Controller {
	private static final Log G7=  LogFactory.getLog(Paciente_Servicio_Controller.class);

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
 
	/*@PostMapping("/guardarPacienteServicio")
	public ModelAndView guardarPacienteServicio(@ModelAttribute("reserva") Paciente_Servicio PacienteServicioConDatos) {
		ModelAndView lista= new ModelAndView ("listadeturnos"); 
		pss.registrarPaciente_Servicio(PacienteServicioConDatos);
		lista.addObject("listadeturnos", pss.listarTodoslosPaciente_Servicios()); 
		
		return lista;
	} */
	
	@PostMapping("/guardarPacienteServicio")
	public ModelAndView guardarPacienteServicio(@Valid @ModelAttribute("reserva") Paciente_Servicio PacienteServicioConDatos, BindingResult result) {
		if(result.hasErrors()) {
			G7.error(result.getAllErrors());
			ModelAndView cargarPacienteServicio= new ModelAndView ("formularioPacienteServicio"); 
			cargarPacienteServicio.addObject("reserva", PacienteServicioConDatos); 
			cargarPacienteServicio.addObject("pacientes",pacienteService.listarTodoslosPacientes() );
			cargarPacienteServicio.addObject("servicios",serv_Service.listarTodosServicios() );	
		
			return cargarPacienteServicio;
		}
		ModelAndView listarPacienteServicio = new ModelAndView("listadoServicio");
		G7.warn("mostrando servicio"+PacienteServicioConDatos.getServicio());
		try {
			pss.registrarPaciente_Servicio(PacienteServicioConDatos);
		}catch(Exception e) {}
		listarPacienteServicio.addObject("listadoServicio",pss.listarTodoslosPaciente_Servicios());
		
		return listarPacienteServicio;
		
	}
	
}
