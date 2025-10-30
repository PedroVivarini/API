package br.com.serratec.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.serratec.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

//	@Query(value="SELECT * FROM funcionario WHERE salario BETWEEN :valorMinimo AND :valorMaximo", nativeQuery = true)
//	public Page<Funcionario> buscarFaixaSalarial(Double valorMinimo, Double valorMaximo, Pageable pageable);
//
//	@Query(value="SELECT * FROM FUNCIONARIO WHERE nome ILIKE CONCAT('%', :parteNome, '%')", nativeQuery = true)
//	public Page<Funcionario> buscarPorNome(String parteNome, Pageable pageable);
//	

	
	//forma mais nova e mais simplificada de fazer
	
	public Page<Funcionario> findBySalarioBetween(Double valorMinimo, Double valorMaximo, Pageable pageable);
	
	public Page<Funcionario> findByNomeContaining(String parteNome, Pageable pageable);

	public Page<Funcionario> findByDataNascimentoGreaterThan(LocalDate dataNascimento, Pageable pageable);
}