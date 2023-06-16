package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Servicio;
import ar.edu.unju.edm.repository.ServicioRepository;
import ar.edu.unju.edm.service.ServicioService;

@Service
public class ImpServicioService implements ServicioService{
	@Autowired 
	Servicio unServicioService; 
	
	@Autowired 
	ServicioRepository servicioRepository; 
	@Override
	public void cargarServicio(Servicio unServicio) {
		// TODO Auto-generated method stub
		servicioRepository.save(unServicio);
	}

	@Override
	public void eliminarServicio(Integer idServicio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Servicio> listarTodosServicios() {
		// TODO Auto-generated method stub
		return (List<Servicio>) servicioRepository.findAll();
	}

	@Override
	public Servicio listarUnaServicio(Integer idServicio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarServicio(Servicio servicioAModificar) {
		// TODO Auto-generated method stub
		
	}
	

}
