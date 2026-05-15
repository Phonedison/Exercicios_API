package org.serratec.aula05.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "manutencao")
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_entrada")
    private LocalDate dataEntreda;

    @Column(name = "data_saida")
    private LocalDate dataSaida;

    @Column
    private String observacao;

    @ManyToOne // -> Muitos para um
    @JoinColumn(name = "id_veiculo") // método de vinculo (chave estrangeira)
    private Veiculo veiculo;

    @ManyToMany
    @JoinTable(name = "manutencao_servico", // nome da tabela intermediário
            joinColumns = @JoinColumn(name = "id_manutencao"), // id pai
            inverseJoinColumns = @JoinColumn(name = "id_servico")) // id filho
    private List<Servico> servicos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataEntreda() {
        return dataEntreda;
    }

    public void setDataEntreda(LocalDate dataEntreda) {
        this.dataEntreda = dataEntreda;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

}
