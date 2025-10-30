package br.com.serratec.entity;

import jakarta.persistence.Entity;

@Entity
public class Tecnico extends Funcionario{

	private Double adicional;

	public Double getAdicional() {
		return adicional;
	}

	public void setAdicional(Double adicional) {
		this.adicional = adicional;
	}
	
	
}
