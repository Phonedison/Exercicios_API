package com.biblioteca.livros.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.livros.domain.Livros;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    // Declarando a lista de livros puxando de DatabaseMock
    private static final List<Livros> listaLivros = DatabaseMock.livros;
    // MÉTODOS de BUSCAS

    @GetMapping // -> mapeia os livros
    public List<Livros> listarLivros() {
        return listaLivros;
    }

    @GetMapping("/{id}") // -> pega um livro por ID
    public Livros getLivros(@RequestParam Long idLivros) {
        return listaLivros.stream()
                .filter(livro -> livro.getId().equals(idLivros))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/buscar")
    public List<Livros> getGenero(@RequestParam String genero) {
        return listaLivros.stream()
                .filter(livro -> livro.verificarGeneros(genero) != null)
                .collect(Collectors.toList());
    }

    @GetMapping("/buscar")
    public List<Livros> getAutor(@RequestParam String nomeAutor) {
        return listaLivros.stream()
                .filter(livro -> livro.verificarGeneros(nomeAutor.toLowerCase().trim()) != null)
                .collect(Collectors.toList());
    }

    // MÉTODO DE PUBLICAÇÃO
    @PostMapping // -> insere um novo livro
    @ResponseStatus(HttpStatus.CREATED)
    public Livros postLivros(@RequestBody Livros livro) {
        listaLivros.add(livro);
        return livro;
    }

    // MÉTODOS de EXCLUSÃO
    @DeleteMapping("deletar/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletedLivro(@PathVariable Long id) {
        listaLivros.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst().map(livro -> listaLivros.remove(livro))
                .orElse(null);
    }

    @PutMapping("atualizar/{id}")
    public Livros putLivro(@PathVariable Long id, @RequestBody Livros body) {

        return listaLivros.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .map(book -> {
                    book.setId(body.getId());
                    book.setTitulo(body.getTitulo());
                    book.setSubtitulo(body.getSubtitulo());
                    book.setAutor(body.getAutor());
                    book.setGeneros(body.getGeneros());
                    book.setDisponibilidade(body.getDisponibilidade());
                    return book;
                }).orElse(null);
    }
}
