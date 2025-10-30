package br.com.serratec.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.serratec.dto.FuncionarioDTO;
import br.com.serratec.entity.Foto;
import br.com.serratec.entity.Funcionario;
import br.com.serratec.service.FotoService;
import br.com.serratec.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;

	@Autowired
	private FotoService fotoService;

	@PreAuthorize("permitAll()")
	@GetMapping
	public List<Funcionario> listar() {
		return service.listar();
	}

	@GetMapping("/paginacao")
	public Page<Funcionario> listar(
			@PageableDefault(page = 0, size = 10, sort = "dataNascimento", direction = Direction.DESC) Pageable pageable) {
		return service.listarPorPagina(pageable);
	}

	@GetMapping("/faixaSalarial")
	public ResponseEntity<Page<Funcionario>> buscarPorFaixaSalarial(
			@RequestParam(defaultValue = "0") Double valorMinimo,
			@RequestParam(defaultValue = "10000") Double valorMaximo, Pageable pageable) {
		return ResponseEntity.ok(service.buscarPorFaixaSalarial(valorMinimo, valorMaximo, pageable));
	}

	@GetMapping("/buscarPorNome")
	public ResponseEntity<Page<Funcionario>> buscarPorNome(@RequestParam(defaultValue = "") String parteNome,
			Pageable pageable) {
		return ResponseEntity.ok(service.buscarPorNome(parteNome, pageable));
	}

	@GetMapping("/buscarPorData")
	public ResponseEntity<Page<Funcionario>> buscarPorData(@RequestParam String paramDataNascimento,
			Pageable pageable) {
		LocalDate dataNascimento = LocalDate.parse(paramDataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return ResponseEntity.ok(service.buscarPorDataNascimento(dataNascimento, pageable));
	}

	@PostMapping
	public FuncionarioDTO inserir(@RequestPart Funcionario  funcionario, MultipartFile file) throws IOException {
		return service.inserir(funcionario, file);
	}

	@GetMapping("/{id}/foto")
	public ResponseEntity<byte[]> buscar(@PathVariable Long id) {
		Foto foto = fotoService.buscar(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", foto.getTipo());
		headers.add("Content-length", String.valueOf(foto.getDados().length));
		return new ResponseEntity<>(foto.getDados(), headers, HttpStatus.OK);

	}
}
