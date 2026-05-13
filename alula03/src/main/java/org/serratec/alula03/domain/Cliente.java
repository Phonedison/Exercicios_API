package org.serratec.alula03.domain;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 60, message = "valor acima do esperado")
    @NotBlank(message = "O nome é Obrigatório")
    @Column(name = "nome")
    private String nome;

    @CPF(message = "CPF inválido")
    @NotNull(message = "Valor inválido")
    @NotBlank(message = "CPF é obrigatório")
    @Column(name = "cpf", unique = true)
    private String cpf;

    @Email(regexp = ".*", message = "E-mail inválido")
    @Length(max = 50, message = "Limite atingindo")
    @Column(name = "email")
    private String email;

    @Past(message = "Data inválida, informe uma data no passado")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    public Cliente(Long id, String nome, String cpf, String email, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public Cliente() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
