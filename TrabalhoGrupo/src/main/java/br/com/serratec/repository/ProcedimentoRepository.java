package br.com.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.Procedimento;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long>{

}
