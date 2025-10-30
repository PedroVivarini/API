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

import br.com.serratec.entity.Paciente;
import br.com.serratec.repository.PacienteRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	@Autowired
	private PacienteRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Paciente inserir(@Valid @RequestBody Paciente paciente) {
		return repository.save(paciente);
	}
	
	@GetMapping
	public List<Paciente> listar(){
		return repository.findAll();
	}
}
