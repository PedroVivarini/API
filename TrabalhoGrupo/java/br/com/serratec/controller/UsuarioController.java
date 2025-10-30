package br.com.serratec.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.serratec.entity.Usuario;
import br.com.serratec.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public List<Usuario> listar (){
		return service.listar();
	}
	
	
	@PostMapping
	
	public ResponseEntity<Object> inserir (@Valid @RequestBody Usuario usuario){
		usuario = service.inserir(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(usuario);
		
	}
}
