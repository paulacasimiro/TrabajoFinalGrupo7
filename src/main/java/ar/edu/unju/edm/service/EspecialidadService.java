package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Especialidad;

@Service
public interface EspecialidadService {
	public void cargarEspecialidad (Especialidad unaEspecialidad); 
	public void eliminarEspecialidad (Integer codigo); 
	public List <Especialidad> listarTodasEspecialidades (); 
	public Especialidad listarUnaEspecialidad (Integer codigo); 
	public void modificarEspecialidad (Especialidad especialidadAModificar); 

}