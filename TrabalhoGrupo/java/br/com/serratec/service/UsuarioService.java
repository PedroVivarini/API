package br.com.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.serratec.entity.Usuario;
import br.com.serratec.exception.UsuarioException;
import br.com.serratec.repository.UsuarioRepository;

@Service // classe de gerenciamento
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public List<Usuario> listar() {
		return repository.findAll();

	}

	public Usuario inserir(Usuario usuario) {
		var user = repository.findByEmail(usuario.getEmail());
		// var usar quando não sei oq receber
		if (user.isPresent()) {
			throw new UsuarioException("Email já está cadastrado");
		}
		usuario.setSenha(encoder.encode(usuario.getSenha()));
		return repository.save(usuario);
	}

}
