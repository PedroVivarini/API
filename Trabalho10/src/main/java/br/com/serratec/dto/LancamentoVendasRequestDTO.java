package br.com.serratec.dto;

import java.time.LocalDate;

import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.entity.Vendedor;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Objeto de requisição para inserir um novo lançamento de venda")
public class LancamentoVendasRequestDTO {

    @Schema(description = "Nome do vendedor", example = "Maria Souza")
    @NotBlank(message = "O nome não pode ser nulo ou vazio!")
    private String nome;

    @Schema(description = "E-mail do vendedor", example = "maria.souza@gmail.com")
    @Email(message = "E-mail inválido!")
    private String email;

    @Schema(description = "Salário do vendedor (mínimo R$1.500,00)", example = "2500.00")
    @DecimalMin(value = "1500.00", inclusive = true, message = "O salário mínimo é de R$1500,00")
    private Double salario;

    
    public LancamentoVendasRequestDTO() {}

 
    public LancamentoVendasRequestDTO(LancamentoVendas lancamento) {
        this.nome = lancamento.getVendedor().getNome();
        this.email = lancamento.getVendedor().getEmail();
        this.salario = lancamento.getVendedor().getSalario();
    }

    
    public LancamentoVendas toEntity() {
        Vendedor vendedor = new Vendedor();
        vendedor.setNome(this.nome);
        vendedor.setEmail(this.email);
        vendedor.setSalario(this.salario);

        LancamentoVendas lancamento = new LancamentoVendas();
        lancamento.setVendedor(vendedor);
        lancamento.setValor(this.salario); 
        lancamento.setData(LocalDate.now()); 

        return lancamento;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
