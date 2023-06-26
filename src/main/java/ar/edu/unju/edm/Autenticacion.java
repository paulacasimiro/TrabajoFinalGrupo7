package ar.edu.unju.edm;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class Autenticacion implements AuthenticationSuccessHandler  {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
	
		Boolean tipoPaciente=false, tipoAdmin=false;
		
		Collection<?extends GrantedAuthority> autorizaciones = authentication.getAuthorities();
		for (GrantedAuthority granteAuthority:autorizaciones) {
			System.out.println("entrando al for");

			if ( granteAuthority.getAuthority().equals("USUARIO")) {
				tipoPaciente=true;
				break;
			}else{
				if(granteAuthority.getAuthority().equals("ADMIN")) {
					tipoAdmin=true;
					break;
				}
			}
		}
		
		if(tipoPaciente) {
			redirectStrategy.sendRedirect(request, response,"/pacienteServicio");
		}else {
			if(tipoAdmin) {
				redirectStrategy.sendRedirect(request, response,"/vistaAdministrador");//especialidad
			}
		}
		
	}

	
	
	
}
