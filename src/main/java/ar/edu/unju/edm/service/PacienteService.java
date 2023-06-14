
package ar.edu.unju.edm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Paciente;
@Service
public interface PacienteService {
	public void registrarPaciente (Paciente unPaciente ); 
	public void eliminarPaciente (Integer codigo); 
	public List <Paciente>listarTodoslosPacientes();
	public Paciente listarUnPaciente(Integer codigo);  
	public Optional<Paciente> modificarPaciente(int codigo);
}
