package br.com.serratec.entity;

import jakarta.persistence.Entity;

@Entity
public class Pediatra  extends Medico{
	private Boolean aplicaVacina;

	public boolean isAplicaVacina() {
		return aplicaVacina;
	}

	public void setAplicaVacina(boolean aplicaVacina) {
		this.aplicaVacina = aplicaVacina;
	}
	
	
}
