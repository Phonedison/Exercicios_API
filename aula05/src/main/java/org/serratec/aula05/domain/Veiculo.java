package org.serratec.aula05.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "veiculo")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 7)
    @NotBlank(message = "A placa é obrigatória")
    @Column(nullable = false, length = 7)
    private String placa;

    @NotBlank(message = "obrigatória")
    @Size(max = 30)
    @Column(nullable = false, length = 30)
    private String marca;

    @Embedded // -> Sempre na classe principal
    private Caracteristica caracteristica;

    @OneToOne
    @JoinColumn(name = "id_proprietario")
    private Proprietario proprietario;

    @OneToMany(mappedBy = "veiculo") // vinculo um para muitos
    private List<Manutencao> manutencao;

    public Veiculo() {
    }

    public Veiculo(Long id, @Size(max = 7) @NotBlank(message = "A placa é obrigatória") String placa,
            @NotBlank(message = "obrigatória") @Size(max = 30) String marca, Caracteristica caracteristica,
            Proprietario proprietario, List<Manutencao> manutencao) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.caracteristica = caracteristica;
        this.proprietario = proprietario;
        this.manutencao = manutencao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public List<Manutencao> getManutencao() {
        return manutencao;
    }

    public void setManutencao(List<Manutencao> manutencao) {
        this.manutencao = manutencao;
    }

}
