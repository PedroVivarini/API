package br.com.serratec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.dto.LancamentoVendasRequestDTO;
import br.com.serratec.dto.LancamentoVendasResponseDTO;
import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository repository;

	public LancamentoVendasResponseDTO buscar(Long id) {
		Optional<LancamentoVendas> lancamento = repository.findById(id);
		return lancamento
				.map(l -> new LancamentoVendasResponseDTO(l.getData(), l.getValor(), l.getVendedor().getNome()))
				.orElse(null);
	}

	public LancamentoVendasResponseDTO inserir(LancamentoVendasRequestDTO dto) {
		LancamentoVendas entidade = dto.toEntity();
		LancamentoVendas salvo = repository.save(entidade);
		return new LancamentoVendasResponseDTO(salvo.getData(), salvo.getValor(), salvo.getVendedor().getNome());
	}
}
