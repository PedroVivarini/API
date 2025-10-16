package br.com.serratec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/exemplos")
public class Exemplo {

	@GetMapping
	public String mensagem (@RequestParam String msg) {
		return "Hello World!" + msg.toUpperCase();
	}
	
	@GetMapping("{id}")
	public String texto (@PathVariable Long id) {
		return "Aula de API!" + id;
	}
}
