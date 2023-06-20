package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Paciente;
import ar.edu.unju.edm.model.Paciente_Servicio;
import ar.edu.unju.edm.repository.PacienteServicioRepository;
import ar.edu.unju.edm.service.PacienteServicio_Service;
 
@Service
public class Imp_PacienteServicio_Service  implements PacienteServicio_Service{

	 
	@Autowired
	PacienteServicioRepository psr; 
	@Autowired 
	Paciente_Servicio paci_serv;
	@Override
	public void registrarPaciente_Servicio(Paciente_Servicio paci_serv) {
		// TODO Auto-generated method stub
		psr.save(paci_serv); 
	}
	
	@Override
	public List<Paciente_Servicio> listarTodoslosPaciente_Servicios() {
		// TODO Auto-generated method stub
		return (List<Paciente_Servicio>)psr.findAll();
	}
	@Override
	public Paciente_Servicio listarUnPaciente_Servicio(Integer idReservadeServicio) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
