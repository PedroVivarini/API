package br.com.serratec.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.Produto;

//import org.springframework.stereotype.Repository;

//@Repository //
public interface ProdutoRepository extends JpaRepository<Produto, UUID>{
	
	
	
	
}
