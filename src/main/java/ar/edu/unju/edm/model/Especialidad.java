package ar.edu.unju.edm.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Component
@Entity
public class Especialidad {
	@Id 
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Integer codigo; 
	private String nombre; 
	private String descripcion; 
	private Boolean estado;
	
	
	
	//CONSTRUCTOR POR DEFECTO
	public Especialidad() {
		// TODO Auto-generated constructor stub
	}
	//CONSTRUCTOR PARAMETRIZADO
	public Especialidad(Integer codigo, String nombre, String descripcion, Boolean estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	//GETERS AND SETTERS 
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	} 
	
	
	

}
