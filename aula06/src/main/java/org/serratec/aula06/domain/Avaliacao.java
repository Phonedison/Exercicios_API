package org.serratec.aula06.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo obrigatório!")
    @Size(max = 500, message = "Campo até 500 caracteres!")
    private String comentario;

    @DecimalMax(value = "5", message = "Aceitamos no máximo 5 estrelinhas! XD")
    @DecimalMin(value = "1", message = "Aceitamos no mínimo 1 estrelinhas! :'(")
    private Double nota;

    private LocalDate dataAvaliacao;

    @ManyToOne
    @JoinColumn(name = "id_livro")
    private Livro livro;

    public Avaliacao() {
    }

    public Avaliacao(Long id,
            @NotBlank(message = "Campo obrigatório!") @Size(max = 500, message = "Campo até 500 caracteres!") String comentario,
            @DecimalMax(value = "5", message = "Aceitamos no máximo 5 estrelinhas! XD") @DecimalMin(value = "1", message = "Aceitamos no mínimo 1 estrelinhas! :'(") Double nota,
            LocalDate dataAvaliacao, Livro livro) {
        this.id = id;
        this.comentario = comentario;
        this.nota = nota;
        this.dataAvaliacao = dataAvaliacao;
        this.livro = livro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public LocalDate getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDate dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

}
