package br.com.serratec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration//quando roda o projeto, a primeira coisa que roda é o
//configuration
public class AppConfig {

	
	@Bean
	 BCryptPasswordEncoder criptografar() {
		return new BCryptPasswordEncoder();
	}
}
