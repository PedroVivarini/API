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


import br.com.serratec.entity.Usuario;
import br.com.serratec.repository.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario inserir(@Valid @RequestBody Usuario usuario) {
		return repository.save(usuario);

	}

	@GetMapping
	public List<Usuario> listar() {
		return repository.findAll();

	}
}
