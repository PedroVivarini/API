package br.com.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.Propietario;


public interface PropietarioRepository extends JpaRepository<Propietario, Long>{
	
}
