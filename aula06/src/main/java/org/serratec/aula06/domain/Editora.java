package org.serratec.aula06.domain;

import java.util.List;

import org.hibernate.validator.constraints.br.CNPJ;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "editora")
// @JsonPropertyOrder({ "id", "cnpj", "nome", "cidade", "livros" })
@Inheritance(strategy = InheritanceType.JOINED)
public class Editora {
    // @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
    // property = "id")

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 80, message = "Limite máximo de 80 caracteres")
    @Column(name = "nome")
    private String nome;

    // @CNPJ(message = "Valor inválido")
    @NotBlank(message = "Preencha o campo CNPJ!")
    @Column(name = "cnpj")
    private String cnpj;

    @NotBlank(message = "Preencha o campo cidade!")
    @Column(name = "cidade")
    private String cidade;

    @OneToMany(mappedBy = "editora")
    @JsonIgnoreProperties("editora")
    private List<Livro> livros;
    // @JsonManagedReference

    public Editora() {
    }

    public Editora(Long id, @NotBlank @Size(max = 80, message = "Limite máximo de 80 caracteres") String nome,
            @CNPJ(message = "Valor inválido") @NotBlank(message = "Preencha o campo CNPJ!") String cnpj,
            @NotBlank(message = "Preencha o campo cidade!") String cidade, List<Livro> livros) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.livros = livros;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

}
