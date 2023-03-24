package com.rafaeldeluca.vendas.configuration;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// por default um aplicação não pode ter o backend e frontend hospedados em locais diferentes
// para poder liberar esse acesso é preciso fazer a configuração de cors

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSeguranca) throws Exception {
		
		httpSeguranca.headers().frameOptions().disable();
		httpSeguranca.cors().and().csrf().disable();
		httpSeguranca.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSeguranca.authorizeHttpRequests((auth) -> auth.anyRequest().permitAll());

		return httpSeguranca.build();
	}

	@Bean
		CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuracaoDeCors = new CorsConfiguration().applyPermitDefaultValues();
		configuracaoDeCors.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource controlador = new UrlBasedCorsConfigurationSource();
		controlador.registerCorsConfiguration("/**", configuracaoDeCors);
		return controlador;
	}
}


