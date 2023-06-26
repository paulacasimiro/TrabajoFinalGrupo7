package ar.edu.unju.edm.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ar.edu.unju.edm.model.Paciente;
import ar.edu.unju.edm.repository.PacienteRepository;
import ar.edu.unju.edm.service.PacienteService;

@Service
public class ImpPacienteService implements PacienteService {

	
	@Autowired 
	Paciente unPacienteService; 
	@Autowired 
	PacienteRepository pacienteRepository; 
	
	@Override 
	public void registrarPaciente(Paciente unPaciente) {
		// TODO Auto-generated method stub
		
		unPaciente.setEstado(true);
		unPaciente.setTipo("ADMIN");
		String pw= unPaciente.getPassword();
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(4);
		unPaciente.setPassword(encoder.encode(pw));
		
	pacienteRepository.save(unPaciente); 
		
	}

	@Override
	public void eliminarPaciente(Integer codigo) {
		// TODO Auto-generated method stub
		
		Optional<Paciente> aux = Optional.of(new Paciente()); 
		aux= pacienteRepository.findById(codigo);
		aux.get().setEstado(false );
		pacienteRepository.save(aux.get()); 
		
	}

	
	
	@Override
	public List<Paciente> listarTodoslosPacientes() {
		// TODO Auto-generated method stub
		
		return (List<Paciente>) pacienteRepository.findByEstado(true); 
		
	}

	@Override
	public Paciente listarUnPaciente(Integer codigo) {
		// TODO Auto-generated method stub
		
		Optional<Paciente> aux = Optional.of(new Paciente()); 
		aux= pacienteRepository.findById(codigo);
		return aux.get();
	}

	@Override
	public Optional<Paciente> modificarPaciente(int codigo) {
		// TODO Auto-generated method stub
		
		return pacienteRepository.findById(codigo);
		
	}
	
	

}