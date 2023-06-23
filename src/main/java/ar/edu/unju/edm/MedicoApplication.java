package ar.edu.unju.edm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ar.edu.unju.edm.model.Paciente;
import ar.edu.unju.edm.service.PacienteService;


@SpringBootApplication
public class MedicoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MedicoApplication.class, args);
	}
	@Autowired
	Paciente usuario;
	
	@Autowired
	PacienteService ps;
	
	@Override 
	public void run (String... args ) throws Exception{
		
		
		usuario.setEstado(true);
		usuario.setCodigo(3);
		usuario.setNombredeusuario("usuario");
		usuario.setPassword("33");
		usuario.setTipo("USUARIO");
		ps.registrarPaciente(usuario);
		
		
	}
	
}
