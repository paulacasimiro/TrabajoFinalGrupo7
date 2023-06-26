package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import ar.edu.unju.edm.model.Paciente;
import ar.edu.unju.edm.repository.PacienteRepository;

@Service
public class LoginService implements UserDetailsService {

	@Autowired 
	PacienteRepository pr; 
	
	 
	@Override
	public UserDetails loadUserByUsername(String codigo) throws UsernameNotFoundException {
		System.out.println("codigo"+codigo);
		//busqueda del usuario
		Paciente usuarioEncontrado= pr.findById(Integer.parseInt(codigo)).orElseThrow(()->new UsernameNotFoundException("Usuario Invalido"));
		System.out.println("usuario encontrado"+usuarioEncontrado.getCodigo());
		//definir autorizaciones 
		List <GrantedAuthority> tipos = new ArrayList<>();
		
		GrantedAuthority granteAuthority =  new SimpleGrantedAuthority(usuarioEncontrado.getTipo());
		tipos.add(granteAuthority);
		
		
		//definir el usuario en sesion
		UserDetails usuarioEnSesion = new User (codigo,usuarioEncontrado.getPassword(),tipos);
		return  usuarioEnSesion;

	}

	
	
	
}
