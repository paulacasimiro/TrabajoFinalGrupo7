package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Servicio;

@Service
public interface ServicioService {
	public void cargarServicio (Servicio unServicio); 
	public void eliminarServicio (Integer idServicio); 
	public List <Servicio> listarTodosServicios (); 
	public Servicio listarUnaServicio (Integer idServicio); 
	public void modificarServicio (Servicio servicioAModificar); 

}
