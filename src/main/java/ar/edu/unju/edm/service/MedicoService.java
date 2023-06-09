package ar.edu.unju.edm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.*;

@Service
public interface MedicoService {
	public void cargarMedico (Medico unMedico ); 
	public void eliminarMedico (Integer matricula); 
	public List <Medico>listarTodosMedicos ();
	public Medico listarUnMedico(Integer matricula); 
	public Optional<Medico> recuperarMedico(int matricula);
}
