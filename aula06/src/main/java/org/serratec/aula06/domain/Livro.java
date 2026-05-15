package org.serratec.aula06.domain;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
// @JsonPropertyOrder({ "id", "isbn", "titulo", "anoPublicacao", "preco",
// "editora" })
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Valor inválido!")
    @Size(max = 100, message = "Limite de até 100 caracteres!")
    @Column
    private String titulo;

    @Column
    private String isbn;

    @Column
    private Integer anoPublicacao;

    @DecimalMin(value = "9.90", message = "Valor invalido")
    @Digits(integer = 3, fraction = 2)
    @Column
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "id_editora")
    @JsonIgnoreProperties("livros")
    private Editora editora;
    // @JsonIgnoreProperties

    @OneToMany(mappedBy = "livro")
    @JsonIgnoreProperties("livro")
    private List<Avaliacao> avaliacoes;

    public Livro() {
    }

    public Livro(Long id,
            @NotBlank(message = "Valor inválido!") @Size(max = 100, message = "Limite de até 100 caracteres!") String titulo,
            String isbn, Integer anoPublicacao,
            @DecimalMin(value = "9.90", message = "Valor invalido") @Digits(integer = 3, fraction = 2) BigDecimal preco,
            Editora editora, List<Avaliacao> avaliacoes) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.preco = preco;
        this.editora = editora;
        this.avaliacoes = avaliacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

}
