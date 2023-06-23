package ar.edu.unju.edm;

import ar.edu.unju.edm.Autenticacion;
import ar.edu.unju.edm.service.imp.LoginService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired; 




@Configuration
@EnableWebSecurity
public class ConfiguracionWeb extends WebSecurityConfigurerAdapter {
	
	@Autowired 
	private Autenticacion autenticacion;
	
	String[] resources = new String [] {"/include/**","/css/**","/incons/**","/img/**","/js/**","/layer/**","/webjars/**"};
	
	protected void configure(HttpSecurity http) throws Exception
	{
		http
		     .authorizeRequests()
		         .antMatchers(resources).permitAll()
		         //metodos definidos para cualquier usuario comun
		         .antMatchers("/","/index","/paciente2","/guardarPaciente2").permitAll()
		         //metodos definidos para el Admin---poner los otros metodos 
		         .antMatchers("/medico","/listadoPaciente","/listado","/listadoMedico","/especialidad").hasAuthority("ADMIN")
		         .anyRequest().authenticated()
		         .and()
		         
		    .formLogin()
		        .loginPage("/login")
		        .permitAll()
		        .successHandler(autenticacion)
		        .failureUrl("/login?error=true")
		        .usernameParameter("codigo")
		        .passwordParameter("password")
		        .and()
		        
		    .logout()
		        .permitAll()
		        .logoutSuccessUrl("/login?logout");
		//para cerrar sesion  /login?logout
		
	}
	
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new  BCryptPasswordEncoder(4);
	}
	
	@Autowired
	LoginService userDetailsService;
	
	@Autowired
	public void configuracionGlobal(AuthenticationManagerBuilder auth)throws Exception {
		System.out.println("***Inicio del Usuario***");
		auth.userDetailsService(userDetailsService);
	}
	
	

}
