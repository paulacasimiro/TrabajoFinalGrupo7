package ar.edu.unju.edm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Especialidad;

@Repository
public interface EspecialidadRepository extends CrudRepository <Especialidad, Integer>{
	
	public List <Especialidad> findByEstado (Boolean estado); 

}
