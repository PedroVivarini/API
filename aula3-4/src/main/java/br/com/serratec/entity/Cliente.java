package br.com.serratec.entity;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column (name = "nome",length = 60, nullable = false)
	@NotBlank( message = "Descrição nula ou vazia")
	@Size(message = "Tamanho do campo nome excedido")
	private String nome;
	
	@Column (name = "cpf", length = 14, nullable = false)
	@NotBlank(message = "Descrição nula ou vazia!")
	@CPF (message = "CPF inválido")
	private String cpf;
	
	@Column (name = "email", nullable = false)
	@NotBlank(message = "Descrição nula ou vazia!")
	@Email(message = "Email inválido")
	private String email;
	
	@Column (name = "data_nascimento", nullable = false)
	private LocalDate dataNascimento;

	public UUID getId() {
		return  id;
	}

	public void setId(UUID id) {
		this.id =  id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
}
