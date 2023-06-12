package ar.edu.unju.edm.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Especialidad;

import ar.edu.unju.edm.repository.EspecialidadRepository;
import ar.edu.unju.edm.service.EspecialidadService;

@Service
public class ImpEspecialidadService implements EspecialidadService {
	
	@Autowired 
	Especialidad unaEspecialidadService; 
	
	@Autowired 
	EspecialidadRepository especialidadRepository; 

	@Override
	public void cargarEspecialidad(Especialidad unaEspecialidad) {
		// TODO Auto-generated method stub
		unaEspecialidad.setEstado(true);
		especialidadRepository.save(unaEspecialidad); 
	}

	@Override
	public void eliminarEspecialidad(Integer codigo) {
		// TODO Auto-generated method stub
		Optional<Especialidad> aux = Optional.of(new Especialidad()); 
		aux= especialidadRepository.findById(codigo); 
		aux.get().setEstado(false );
		especialidadRepository.save(aux.get()); 
	}

	@Override
	public List<Especialidad> listarTodasEspecialidades() {
		// TODO Auto-generated method stub
	 
		return (List<Especialidad>) especialidadRepository.findByEstado(true); 
	}

	@Override
	public Especialidad listarUnaEspecialidad(Integer codigo) {
		// TODO Auto-generated method stub
		Optional <Especialidad> aux= Optional.of (new Especialidad());
		aux=especialidadRepository.findById(codigo); 
		return aux.get(); 

	}

	@Override
	public void modificarEspecialidad(Especialidad especialidadAModificar) {
		// TODO Auto-generated method stub
		
		
	}

}
