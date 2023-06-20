package ar.edu.unju.edm.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Component 
@Entity
public class Paciente_Servicio {

	@Id 
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer idReservadeServicio;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codigo_pacientes")
	Paciente paciente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idServicio") 
	Servicio servicio;
	
	private Date fechadeinicio;
	private Date fechadefinalizacion;
	
	public Paciente_Servicio() {
		this.paciente= new Paciente();
		this.servicio= new Servicio();  
	}

	/*public Paciente_Servicio(Integer idReservadeServicio, Paciente paciente, Servicio servicio, Date fechadeinicio,
			Date fechadefinalizacion) {
		super();
		this.idReservadeServicio = idReservadeServicio;
		this.paciente = paciente;
		this.servicio = servicio;
		this.fechadeinicio = fechadeinicio;
		this.fechadefinalizacion = fechadefinalizacion;
	}*/

	public Integer getIdReservadeServicio() {
		return idReservadeServicio;
	}

	public void setIdReservadeServicio(Integer idReservadeServicio) {
		this.idReservadeServicio = idReservadeServicio;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Date getFechadeinicio() {
		return fechadeinicio;
	}

	public void setFechadeinicio(Date fechadeinicio) {
		this.fechadeinicio = fechadeinicio;
	}

	public Date getFechadefinalizacion() {
		return fechadefinalizacion;
	}

	public void setFechadefinalizacion(Date fechadefinalizacion) {
		this.fechadefinalizacion = fechadefinalizacion;
	}
	
	
	
}
