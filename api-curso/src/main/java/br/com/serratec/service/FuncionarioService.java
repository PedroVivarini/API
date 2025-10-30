package br.com.serratec.service;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.serratec.dto.FuncionarioDTO;
import br.com.serratec.entity.Funcionario;
import br.com.serratec.exeption.FuncionarioException;
import br.com.serratec.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;
	
	@Autowired
	private FotoService fotoService;

	public List<Funcionario> listar() {
		return repository.findAll();
	}

	
	public FuncionarioDTO adicionarUrl(Funcionario funcionario) {
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/funcionarios/{id}/foto")
				.buildAndExpand(funcionario.getId()).toUri();
		FuncionarioDTO dto = new FuncionarioDTO(funcionario.getNome(), funcionario.getSalario(), uri.toString());
		return dto;
	}
	
	@Transactional
	public FuncionarioDTO inserir(Funcionario funcionario, MultipartFile file) throws IOException {
		funcionario = repository.save(funcionario);
		fotoService.inserir(funcionario, file);
		return adicionarUrl(funcionario);
	}
	
	public FuncionarioDTO buscar (Long id) {
		Optional<Funcionario> funcionario = repository.findById(id);
		
		if (funcionario.isPresent()) {
			return adicionarUrl(funcionario.get());
		}
		throw new FuncionarioException ("Funcionário não encontrado");
	
	}
	
	
	public Page<Funcionario> listarPorPagina(Pageable pageable) {
		
		return repository.findAll(pageable);
	}
	
	public Page<Funcionario> buscarPorFaixaSalarial(Double valorMinimo, Double valorMaximo, Pageable pageable){
		return repository.findBySalarioBetween(valorMinimo, valorMaximo, pageable);
	}
	
	
	public Page<Funcionario> buscarPorNome(String parteNome, Pageable pageable){
		return repository.findByNomeContaining(parteNome, pageable);
	}
	
	public Page<Funcionario> buscarPorDataNascimento(LocalDate  dataNascimento, Pageable pageable){
		return repository.findByDataNascimentoGreaterThan(dataNascimento, pageable);
	}
	
	
}