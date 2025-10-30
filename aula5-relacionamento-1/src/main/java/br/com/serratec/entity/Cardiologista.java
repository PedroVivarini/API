package br.com.serratec.entity;

import jakarta.persistence.Entity;

@Entity
public class Cardiologista extends Medico{

	private Boolean eletro;

	public Boolean getEletro() {
		return eletro;
	}

	public void setEletro(Boolean eletro) {
		this.eletro = eletro;
	}
	
	
	
}
