package ar.edu.unju.edm.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Component
@Entity

public class Paciente {

	@Id 
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer codigo;
	private String nombreyapellido ;
	private String password; 
	private String DNI; 
	private String direccion;
	
	private Boolean estado;
	private String gmail;
    private String nombredeusuario;
    
    public Paciente(String nombreyapellido, String password, String dNI, String direccion, Integer codigo,
			Boolean estado, String gmail, String nombredeusuario) {
		super();
		this.nombreyapellido = nombreyapellido;
		this.password = password;
		DNI = dNI;
		this.direccion = direccion;
		this.codigo = codigo;
		this.estado = estado;
		this.gmail = gmail;
		this.nombredeusuario = nombredeusuario;
	}
	 public Paciente(){
			
     }

	 public String getNombreyapellido() {
			return nombreyapellido;
		}


		public void setNombreyapellido(String nombreyapellido) {
			this.nombreyapellido = nombreyapellido;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getDNI() {
			return DNI;
		}


		public void setDNI(String dNI) {
			DNI = dNI;
		}


		public String getDireccion() {
			return direccion;
		}


		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}


		public Integer getCodigo() {
			return codigo;
		}


		public void setCodigo(Integer codigo) {
			this.codigo = codigo;
		}


		public Boolean getEstado() {
			return estado;
		}


		public void setEstado(Boolean estado) {
			this.estado = estado;
		}


		public String getGmail() {
			return gmail;
		}


		public void setGmail(String gmail) {
			this.gmail = gmail;
		}


		public String getNombredeusuario() {
			return nombredeusuario;
		}


		public void setNombredeusuario(String nombredeusuario) {
			this.nombredeusuario = nombredeusuario;
		}

}