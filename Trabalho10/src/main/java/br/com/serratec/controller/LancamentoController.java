package br.com.serratec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.serratec.dto.LancamentoVendasRequestDTO;
import br.com.serratec.dto.LancamentoVendasResponseDTO;
import br.com.serratec.service.LancamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

	@Autowired
	private LancamentoService service;

	@Operation(summary = "Buscar lançamento por ID", description = "Retorna um lançamento de venda específico com base no ID informado.")
	@ApiResponse(responseCode = "200", description = "Lançamento encontrado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LancamentoVendasResponseDTO.class)))
	@ApiResponse(responseCode = "404", description = "Lançamento não encontrado")
	
	@GetMapping("{id}")
	public ResponseEntity<LancamentoVendasResponseDTO> buscar(@PathVariable Long id) {
		LancamentoVendasResponseDTO dto = service.buscar(id);
		return (dto != null) ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
	}

	@Operation(summary = "Inserir novo lançamento", description = "Adiciona um novo lançamento de venda no sistema.")
	@ApiResponse(responseCode = "201", description = "Lançamento criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LancamentoVendasResponseDTO.class)))
	
	@PostMapping
	public ResponseEntity<LancamentoVendasResponseDTO> inserir(@RequestBody LancamentoVendasRequestDTO dto) {
		LancamentoVendasResponseDTO resposta = service.inserir(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
	}
}
