package ar.edu.unju.edm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unju.edm.model.Paciente_Servicio;

@Repository
public interface PacienteServicioRepository extends CrudRepository <Paciente_Servicio,Integer>  {

	
	
}
