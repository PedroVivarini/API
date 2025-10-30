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

import br.com.serratec.entity.Endereco;
import br.com.serratec.repository.EnderecoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Endereco inserir(@Valid @RequestBody Endereco endereco) {
		return repository.save(endereco);

	}

	@GetMapping
	public List<Endereco> listar() {
		return repository.findAll();

	}
}
