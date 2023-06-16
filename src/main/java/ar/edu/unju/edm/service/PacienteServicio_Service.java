package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import ar.edu.unju.edm.model.Paciente_Servicio;

@Service
public interface PacienteServicio_Service {

	public void registrarPaciente_Servicio (Paciente_Servicio  paci_serv ); 
	public List <Paciente_Servicio>listarTodoslosPaciente_Servicios();
	public Paciente_Servicio listarUnPaciente_Servicio(Integer idReservadeServicio); 
	
	
}
