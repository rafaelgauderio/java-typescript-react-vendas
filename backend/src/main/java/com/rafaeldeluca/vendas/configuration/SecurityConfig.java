package com.rafaeldeluca.vendas.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

// por default um aplicação não pode ter o backend e frontend hospedados em locais diferentes
// para poder liberar esse acesso é preciso fazer a configuração de cors

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filtroDeCadeia(HttpSecurity httpSecurity) throws Exception {
		
	
			httpSecurity.cors().and().csrf().disable();
			httpSecurity.headers().frameOptions().disable();
			httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			httpSecurity.authorizeHttpRequests((authentication) -> authentication.anyRequest().permitAll());			
		
		return httpSecurity.build();
		
	}
	
	@Bean
	CorsConfigurationSource controladorDeConfiguracaoDeCors () {
		CorsConfiguration configuracaoDeCors = new CorsConfiguration().applyPermitDefaultValues();
		List<String> metodosPermitidos = new ArrayList<String>();
		metodosPermitidos.add("GET");
		metodosPermitidos.add("POST");
		metodosPermitidos.add("PUT");
		metodosPermitidos.add("DELETE");
		metodosPermitidos.add("OPTIONS");		
		configuracaoDeCors.setAllowedMethods(metodosPermitidos);
		
		final UrlBasedCorsConfigurationSource controlador = new UrlBasedCorsConfigurationSource();
		controlador.registerCorsConfiguration("/**", configuracaoDeCors);
		
		return controlador;		
		
	}
	

}
