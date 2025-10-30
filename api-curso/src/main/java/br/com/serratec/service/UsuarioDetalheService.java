package br.com.serratec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.serratec.entity.Usuario;
import br.com.serratec.exception.UsuarioException;
import br.com.serratec.repository.UsuarioRepository;

@Service
public class UsuarioDetalheService implements UserDetailsService {

	// essa classe valida os loguins

	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repository.findByEmail(username); // campo do email
		if (usuario.isPresent()) { //verificar se ele existe
			return usuario.get();	//retorna usuario

		}
		throw new UsuarioException("Email não encontrado");
	}

}
