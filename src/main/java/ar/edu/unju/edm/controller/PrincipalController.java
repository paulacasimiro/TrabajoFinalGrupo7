package ar.edu.unju.edm.controller;




import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Paciente;
import ar.edu.unju.edm.service.PacienteService;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
@Controller
public class PrincipalController {

	
	@Autowired
	Paciente usuario;
	
	@GetMapping("/login")
	public ModelAndView cargarPrincipal(){ 
		ModelAndView modelAndView = new ModelAndView("princi");
		modelAndView.addObject("usuario",usuario);
		return modelAndView;
	}
	
@GetMapping ("/vistaAdministrador")
	
	public ModelAndView mostrarvistaAdministrador () {
		
		ModelAndView name= new ModelAndView ("vistaAdministrador"); 
		return name;
		
	}

//vista para usuario cuando se Registre 

 @Autowired 
	PacienteService pacienteService; 
	
	@Autowired 
	Paciente unPaciente; 
	 
	 @GetMapping("/paciente2")
	public ModelAndView registrarPaciente2(){
		ModelAndView modelAndView = new ModelAndView("formularioPaciente2");
		modelAndView.addObject("paciente", unPaciente);
		modelAndView.addObject("band", false);
				 
		return modelAndView;
	}
 //se muestra solo los datos de los usuarios registrados --vistadeRegistroUsuario.html--
 @PostMapping("/guardarPaciente2")
	public ModelAndView guardarPaciente2(@ModelAttribute("paciente") Paciente pacienteConDatos) {
		ModelAndView lista= new ModelAndView ("vistadeUsuario"); 
		pacienteService.registrarPaciente(pacienteConDatos);
		lista.addObject("listadoPaciente2", pacienteService.listarTodoslosPacientes()); 
		
		return lista;
	} 
	
 
	

}
