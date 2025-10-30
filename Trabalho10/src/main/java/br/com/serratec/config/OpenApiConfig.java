package br.com.serratec.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

	@Value("${dominio.openapi.dev-uri}")
	private String devUri;

	@Value("${dominio.openapi.prod-uri}")
	private String devProd;

	@Bean
	 OpenAPI myOpenApi() {
		Server devServer = new Server();
		devServer.setUrl(devUri);
		devServer.setDescription("Uri do servidor de Dev.");
		
		new OpenAPI().addServersItem(new Server().url("http://localhost:8080").description("Servidor local"));


		Server prodServer = new Server();
		prodServer.setUrl(devProd);
		prodServer.setDescription("Uri do servidor de Prod.");

		Contact contact = new Contact();
		contact.setEmail("pedrohenriquevivarini@gmail.com");
//		contact.setEmail("phdof.pedro@gmail.com");
//		contact.setEmail("marcosmuniz815gmail.com");
		contact.setName("Pedro Vivarini");
//		contact.setName("Pedro Oliveira");
//		contact.setName("Marcos Muniz");
		contact.setUrl("www.meudominio.com.br");
		contact.setUrl("www.meudominio.com.br");

		Info info = new Info().title("API para gestão de vendas").version("1.0").contact(contact).description("Documentação da API de gerenciamento de produtos")
				.termsOfService("API usada para gestão de vendas- SerraTec/2025");

		return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
	}
	
}



