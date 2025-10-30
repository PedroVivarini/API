package br.com.serratec.entity;

import jakarta.persistence.Entity;

@Entity
public class Gerente extends Funcionario{

	private String setor;

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	
	
}
