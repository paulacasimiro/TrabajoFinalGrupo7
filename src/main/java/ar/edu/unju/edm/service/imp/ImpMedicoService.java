package ar.edu.unju.edm.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.*;
import ar.edu.unju.edm.repository.MedicoRepository;
import ar.edu.unju.edm.service.MedicoService;

@Service 
public class ImpMedicoService implements MedicoService{
	
	@Autowired 
	Medico unMedicoService; 
	@Autowired 
	MedicoRepository medicoRepository; 

	@Override
	public void cargarMedico(Medico unMedico) {
		
		// TODO Auto-generated method stub
		unMedico.setEstado(true);
		medicoRepository.save(unMedico); 
	}

	@Override
	public void eliminarMedico(Integer matricula) {
		// TODO Auto-generated method stub
		Optional<Medico> aux = Optional.of(new Medico()); 
		aux= medicoRepository.findById(matricula);
		aux.get().setEstado(false );
		medicoRepository.save(aux.get()); 
		
		
	}

	@Override
	public List<Medico> listarTodosMedicos() {
		// TODO Auto-generated method stub
		return (List<Medico>) medicoRepository.findByEstado(true); 
	}

	@Override
	public Medico listarUnMedico(Integer matricula) {
		// TODO Auto-generated method stub
		Optional<Medico> aux = Optional.of(new Medico()); 
		aux= medicoRepository.findById(matricula);
		
		return aux.get();
	}

	@Override
	public Optional<Medico> recuperarMedico(int matricula) {
		return medicoRepository.findById(matricula);
	}

}
