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

import br.com.serratec.entity.Servico;
import br.com.serratec.repository.ServicoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

	@Autowired
	private ServicoRepository repository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Servico inserir(@Valid @RequestBody Servico servico) {
		return repository.save(servico);

	}

	@GetMapping
	public List<Servico> listar() {
		return repository.findAll();

	}
}
