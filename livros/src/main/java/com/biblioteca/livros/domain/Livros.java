package com.biblioteca.livros.domain;

import java.util.List;

public class Livros {
    private Long id;
    private String titulo;
    private String subtitulo;
    private Autores autor;
    private List<String> generos;
    private Boolean disponibilidade;
    private Integer ano;

    public Livros(Long id, String titulo, String subtitulo, Autores autor, List<String> generos,
            Boolean disponibilidade,
            Integer ano) {
        this.id = id;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.autor = autor;
        this.generos = generos;
        this.disponibilidade = disponibilidade;
        this.ano = ano;
    }

    public Livros() {

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

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }

    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    /**
     * Pesquisa se o livro contém o genero informado.
     * 
     * @param genero pesquisado
     * @return o próprio objeto se for encontrado, ou nulo se não encontrar
     */
    public Livros verificarGeneros(String genero) {
        boolean existe = this.generos.stream()
                .anyMatch(gen -> gen.equals(genero.toLowerCase()));
        // anyMatch -> usado para retornar um valor do tipo boolean
        // equalsIgnoreCase -> usado para ignorar

        return existe ? this : null;
    }

    /**
     * Pesquisa o autor no livro
     * 
     * @param nome -> nome do autor do livro
     * @return o próprio objeto se for encontrado, ou nulo se não encontrar
     */
    public Livros verificarAutor(String nome) {
        boolean existe = this.autor.getNome().equalsIgnoreCase(nome);
        return existe ? this : null;
    }

}
