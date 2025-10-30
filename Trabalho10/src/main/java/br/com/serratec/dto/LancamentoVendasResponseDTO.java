package br.com.serratec.dto;

import java.time.LocalDate;

public record LancamentoVendasResponseDTO(LocalDate dataVenda, Double valorVenda, String nomeVendedor) {

}
