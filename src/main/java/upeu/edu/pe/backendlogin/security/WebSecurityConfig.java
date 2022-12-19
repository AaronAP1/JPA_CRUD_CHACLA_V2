package upeu.edu.pe.backendlogin.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@CrossOrigin(origins= "*")
public class WebSecurityConfig {
	
	private final UserDetailsService userDetailsService;
	private final JWTAuthorizationFilter jwtAuthorizationFilter;

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
		
		JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
		jwtAuthenticationFilter.setAuthenticationManager(authManager);
		jwtAuthenticationFilter.setFilterProcessesUrl("/api/login");
		
		return http
				.cors().configurationSource(corsConfigurationSource()).and()
				.csrf().disable()
				.authorizeRequests()
				// API PUBLICAS
				.antMatchers(HttpMethod.POST, "/api/usuario/create-usuario").permitAll()
				.antMatchers(HttpMethod.GET, "/api/organizacion/listar").permitAll()
				.antMatchers(HttpMethod.POST, "/api/organizacion/crear-organizacion").permitAll()
				.antMatchers(HttpMethod.PUT, "/api/organizacion/actualizar-organizacion/**").permitAll()
				// API PRIVADAS
//				.antMatchers(HttpMethod.GET, "/api/categoria/get-all").access("hasAuthority('ADMIN_ROLE') or hasAuthority('USER_ROLE') ")
				.antMatchers(HttpMethod.GET, "/api/organizacion/listar-todo").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.POST, "/api/organizacion/crear-organizacion").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.PUT, "/api/organizacion/actualizar-organizacion/**").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "/api/categoria/get-all").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.POST, "/api/categoria/create-categoria").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.PUT, "/api/categoria/update-categoria/**").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/api/categoria/delete-categoria/**").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "/api/categoria/get-categoria/**").hasAuthority("USER_ROLE")
				.anyRequest()
				.authenticated()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.addFilter(jwtAuthenticationFilter)
				.addFilterAfter(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	
	
	@Bean
	AuthenticationManager authManager(HttpSecurity http) throws Exception{
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder())
				.and()
				.build();
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		config.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Content-Type","Authorization"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
