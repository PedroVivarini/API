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

import br.com.serratec.entity.Tecnico;
import br.com.serratec.repository.TecnicoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

	@Autowired
	private TecnicoRepository repository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Tecnico inserir(@Valid @RequestBody Tecnico tecnico) {
		return repository.save(tecnico);

	}

	@GetMapping
	public List<Tecnico> listar() {
		return repository.findAll();

	}
	
}