package org.serratec.aula05.domain;

import org.serratec.aula05.enumerated.Categoria;
import org.serratec.aula05.enumerated.Combustivel;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable // -> Sempre na classe secundária
public class Caracteristica {
    private String renavam;
    private String chassi;
    private Long ano;
    private String cor;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Enumerated(EnumType.ORDINAL)
    private Combustivel combustivel;

    public Caracteristica(String renavam, String chassi, Long ano, String cor, Categoria categoria,
            Combustivel combustivel) {
        this.renavam = renavam;
        this.chassi = chassi;
        this.ano = ano;
        this.cor = cor;
        this.categoria = categoria;
        this.combustivel = combustivel;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Long getAno() {
        return ano;
    }

    public void setAno(Long ano) {
        this.ano = ano;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

}
