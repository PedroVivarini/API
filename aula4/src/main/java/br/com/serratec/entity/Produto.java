package br.com.serratec.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(name= "descricao", length = 50, nullable = false)
	@NotBlank(message = "descrição nula ou vazia!")
	@Size(message = "Tamanho do campo descrição excedido!")
	private String descricao;
	
	@Column(name = "preco", nullable = false)
	@Min (value = 10, message = "Valor minimo inválido!")
	@Max (value = 10000, message = "Valor máximo excido!")
	private Double preco;

	@Column (name = "data_cadastro", nullable = false)
	@PastOrPresent (message = "Data de cadastro incorreta!")
	private LocalDate dataCadastro;
	
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	
	
	
	
}
