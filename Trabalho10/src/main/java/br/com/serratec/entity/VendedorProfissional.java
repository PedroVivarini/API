package br.com.serratec.entity;

import jakarta.persistence.Entity;

@Entity
public class VendedorProfissional extends Vendedor{
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}

