package org.serratec.aula05.domain;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "servico")
public class Servico {

    @Id
    private Long id;

    @Column
    private String descricao;

    @Column
    private BigDecimal valor;

    @ManyToMany(mappedBy = "servicos")
    private List<Manutencao> manutencoes;

    public Servico() {
    }

    public Servico(Long id, String descricao, BigDecimal valor, List<Manutencao> manutencoes) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.manutencoes = manutencoes;
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

    public List<Manutencao> getManutencoes() {
        return manutencoes;
    }

    public void setManutencoes(List<Manutencao> manutencoes) {
        this.manutencoes = manutencoes;
    }

}
