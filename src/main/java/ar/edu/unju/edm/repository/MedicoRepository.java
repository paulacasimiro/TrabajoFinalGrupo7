package ar.edu.unju.edm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.*;

@Repository
public interface MedicoRepository extends CrudRepository<Medico, Integer>  {
	public List <Medico> findByEstado (Boolean estado); 

}