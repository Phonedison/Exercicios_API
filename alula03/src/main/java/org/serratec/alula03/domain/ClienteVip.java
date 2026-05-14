package org.serratec.alula03.domain;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity
public class ClienteVip extends Cliente {

    @NotBlank(message = "O consultor responsável deve ser informado!")
    @Column(name = "consultor_responsavel")
    private String consultarResponsavel;

    public ClienteVip() {
    }

    public ClienteVip(String telefone, String endereco, Boolean ativo, Long id,
            @Length(max = 60, message = "valor acima do esperado") @NotBlank(message = "O nome é Obrigatório") String nome,
            @CPF(message = "CPF inválido") @NotNull(message = "Valor inválido") @NotBlank(message = "CPF é obrigatório") String cpf,
            @Email(regexp = ".*", message = "E-mail inválido") @Length(max = 50, message = "Limite atingindo") String email,
            @Past(message = "Data inválida, informe uma data no passado") LocalDate dataNascimento,
            DocumentoCliente documentoCliente,
            @NotBlank(message = "O consultor responsável deve ser informado!") String consultarResponsavel) {
        super(telefone, endereco, ativo, id, nome, cpf, email, dataNascimento, documentoCliente);
        this.consultarResponsavel = consultarResponsavel;
    }

    public ClienteVip(@NotBlank(message = "O consultor responsável deve ser informado!") String consultarResponsavel) {
        this.consultarResponsavel = consultarResponsavel;
    }

    public String getConsultarResponsavel() {
        return consultarResponsavel;
    }

    public void setConsultarResponsavel(String consultarResponsavel) {
        this.consultarResponsavel = consultarResponsavel;
    }

}
