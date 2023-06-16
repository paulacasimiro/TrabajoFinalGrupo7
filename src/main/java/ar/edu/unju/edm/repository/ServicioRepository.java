package ar.edu.unju.edm.repository;

import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Servicio;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface ServicioRepository extends CrudRepository<Servicio, Integer>{
	

}
