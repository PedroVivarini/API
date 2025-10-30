package br.com.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.LancamentoVendas;

public interface LancamentoRepository extends JpaRepository<LancamentoVendas, Long>{

}
