package org.serratec.alula03.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity // -> Declarando a entidade que é uma tabela
@Table(name = "produto") // -> Informando que é uma tabela
public class Produto {

    @Id // -> declarando que a propriedade é um ID da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descrição é obrigatória.")
    @Size(max = 40, message = "A descrição deve conter no máximo 40 caracteres.")
    @Column(name = "descricao", nullable = false, length = 40) // -> declarando que a propriedade é uma coluna e as
                                                               // propriedades dela
    private String descricao;

    @DecimalMax(value = "5000", message = "O preço não pode ser menor que R${value},00")
    @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero.")
    @Column(name = "valor", nullable = false, precision = 10, scale = 2) // -> declarando que a propriedade é uma coluna
                                                                         // e as propriedades dela
    private BigDecimal valor;

    @Column(name = "data_cadastro") // -> declarando que a propriedade é uma coluna e as propriedades dela
    private LocalDate dataCadastro;

    public Produto(Long id, String descricao, BigDecimal valor, LocalDate dataCadastro) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.dataCadastro = dataCadastro;
    }

    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDataCadastro() {
        return dataCadastro.toString();
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}
