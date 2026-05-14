package org.serratec.alula03.domain;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity
@Table(name = "cliente_premium")
public class ClientePremium extends Cliente {

    private Double limiteCredito;
    private String nivelFidelidade;

    public ClientePremium(String telefone, String endereco, Boolean ativo, Long id,
            @Length(max = 60, message = "valor acima do esperado") @NotBlank(message = "O nome é Obrigatório") String nome,
            @CPF(message = "CPF inválido") @NotNull(message = "Valor inválido") @NotBlank(message = "CPF é obrigatório") String cpf,
            @Email(regexp = ".*", message = "E-mail inválido") @Length(max = 50, message = "Limite atingindo") String email,
            @Past(message = "Data inválida, informe uma data no passado") LocalDate dataNascimento,
            DocumentoCliente documentoCliente, Double limiteCredito, String nivelFidelidade) {
        super(telefone, endereco, ativo, id, nome, cpf, email, dataNascimento, documentoCliente);
        this.limiteCredito = limiteCredito;
        this.nivelFidelidade = nivelFidelidade;
    }

    public Double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(Double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public String getNivelFidelidade() {
        return nivelFidelidade;
    }

    public void setNivelFidelidade(String nivelFidelidade) {
        this.nivelFidelidade = nivelFidelidade;
    }

}
