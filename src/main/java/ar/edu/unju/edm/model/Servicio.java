package ar.edu.unju.edm.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Component
@Entity
public class Servicio {
	@Id 
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer idServicio;
	
	@NotNull(message = "Debe ingresar el costo del servicio")
	private Integer costoDelServicio;
	
	//@Pattern(regexp = "[a-zA-Z]+", message = "El servicio solo puede contener letras")
	@NotBlank(message = "Debe ingresar el nombre del servicio")
	@Size(min = 3, max = 20)
	private String nombreServicio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="matricula")
	Medico medico;
	
	public Servicio() {
		this.medico = new Medico(); 
	}

	public Integer getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	public Integer getCostoDelServicio() {
		return costoDelServicio;
	}

	public void setCostoDelServicio(Integer costoDelServicio) {
		this.costoDelServicio = costoDelServicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	
}
