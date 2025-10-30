package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.entity.Exame;
import br.com.serratec.repository.ExameRepository;

@RestController
@RequestMapping("/Exames")
public class ExameController {
	@Autowired
	private ExameRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Exame inserir(@RequestBody Exame Exame) {
		return repository.save(Exame);
	}
	
	@GetMapping
	public List<Exame> listar(){
		return repository.findAll();
	}	
}
