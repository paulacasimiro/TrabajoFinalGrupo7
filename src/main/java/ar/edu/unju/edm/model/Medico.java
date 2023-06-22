package ar.edu.unju.edm.model;

import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
@Entity
public class Medico {
	@Id 
	private Integer matricula;
	
	@NotBlank(message = "Debe ingresar el nombre del medico")
	@Size(min=3, max=30)
	private String nombreApellido; 
	
	@NotNull(message = "Debe ingresar DNI")
	private Integer dni;
	
	private String direccion;
	private Integer telefono;
	private Boolean estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="codigo")
	Especialidad especialidad;
	public Medico() {
		this.especialidad = new	Especialidad();
	}

	public Medico(Integer matricula, String nombreApellido, Integer dni, String direccion, Integer telefono,
			Boolean estado) {
		super();
		this.matricula = matricula;
		this.nombreApellido = nombreApellido;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.estado = estado;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	
	
	
}
