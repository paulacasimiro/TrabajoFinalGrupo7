package ar.edu.unju.edm.util;

import java.util.List;
import java.util.ArrayList;
import ar.edu.unju.edm.model.Paciente;

public class Pacientes {
	private static List <Paciente> listadoDePacientes= new ArrayList<>();
	
	public Pacientes(){
		
	}

	public static List<Paciente> getListadoDePacientes() {
		return listadoDePacientes;
	}

	public static void setListadoDePacientes(List<Paciente> listadoDePacientes) {
		Pacientes.listadoDePacientes = listadoDePacientes;
	}
	
}
