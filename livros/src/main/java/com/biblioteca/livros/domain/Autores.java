package com.biblioteca.livros.domain;

import java.time.LocalDate;
import java.util.List;

public class Autores {
    private Long id;
    private String nome;
    private String nacionalidade;
    private String biografia;
    private LocalDate aniversario;
    private List<Livros> obras;

    public Autores(Long id, String nome, String nacionalidade, String biografia, LocalDate aniversario,
            List<Livros> obras) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.biografia = biografia;
        this.aniversario = aniversario;
        this.obras = obras;
    }

    public Autores() {
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

    public String getNacionalidade() {
        return this.nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getBiografia() {
        return this.biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public LocalDate getAniversario() {
        return aniversario;
    }

    public void setAniversario(LocalDate aniversario) {
        this.aniversario = aniversario;
    }

    public List<Livros> getObras() {
        return obras;
    }

    public void setObras(List<Livros> obras) {
        this.obras = obras;
    }

    public Autores verificarLivros(String nomeLivro) {
        boolean existe = this.obras.stream()
                .anyMatch(obra -> obra.getTitulo().equals(nomeLivro));
        return existe ? this : null;
    }

    public Autores verificarNacionalidade(String nacionalidade) {
        boolean existe = this.obras.stream()
                .anyMatch(obra -> obra.getTitulo().equals(nacionalidade));
        return existe ? this : null;
    }

}
