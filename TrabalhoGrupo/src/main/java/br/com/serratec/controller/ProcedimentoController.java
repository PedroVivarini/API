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

import br.com.serratec.entity.Procedimento;
import br.com.serratec.repository.ProcedimentoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/procedimento")
public class ProcedimentoController {

	@Autowired
	private ProcedimentoRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Procedimento inserir(@Valid @RequestBody Procedimento procedimento) {
		return repository.save(procedimento);

	}

	@GetMapping
	public List<Procedimento> listar() {
		return repository.findAll();

	}
}
