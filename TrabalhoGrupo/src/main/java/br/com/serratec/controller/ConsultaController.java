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

import br.com.serratec.entity.Consulta;
import br.com.serratec.repository.ConsultaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

	@Autowired
	private ConsultaRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Consulta inserir(@Valid @RequestBody Consulta consulta) {
		return repository.save(consulta);

	}

	@GetMapping
	public List<Consulta> listar() {
		return repository.findAll();

	}
}
