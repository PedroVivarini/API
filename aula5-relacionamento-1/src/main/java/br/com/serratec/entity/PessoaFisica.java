package br.com.serratec.entity;

import jakarta.persistence.Entity;

@Entity
public class PessoaFisica extends Fornecedor{
	private String cpf;
	private String rg;
	private String orgaoExpedido;
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getOrgaoExpedido() {
		return orgaoExpedido;
	}
	public void setOrgaoExpedido(String orgaoExpedido) {
		this.orgaoExpedido = orgaoExpedido;
	}
	
	
	
}
