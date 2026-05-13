package org.serratec.alula03.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 100, message = "A descrição deve conter até 100 caracteres")
    @Length(min = 10, message = "A descrição deve conter no mínimo 10 caracteres")
    @Column(name = "descricao")
    private String descricao;

    @DecimalMax(value = "5000", message = "O preço não pode ser menor que R${value},00")
    @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero.")
    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Column(name = "dataPedido")
    private LocalDate dataPedido;

    public Pedido() {
    }

    public Pedido(Long id, String descricao, BigDecimal total, LocalDate dataPedido) {
        this.id = id;
        this.descricao = descricao;
        this.total = total;
        this.dataPedido = dataPedido;
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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

}
