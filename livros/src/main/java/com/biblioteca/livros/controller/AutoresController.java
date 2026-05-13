package com.biblioteca.livros.controller;

import java.util.List;
import java.util.Optional;
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

import com.biblioteca.livros.domain.Autores;

@RestController
@RequestMapping("/autores")
public class AutoresController {

    private static final List<Autores> listaAutores = DatabaseMock.autores;

    @GetMapping
    public List<Autores> listaAutores() {
        return listaAutores;
    }

    @GetMapping("/{id}")
    public Autores getAutor(@RequestParam Long id) {
        return listaAutores.stream()
                .filter(autor -> autor.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/buscar")
    public Optional<Autores> getAutorNome(@RequestParam String nome) {
        return listaAutores.stream()
                .filter(autor -> autor.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }

    @GetMapping("/buscar")
    public List<Autores> getAutorLivroNome(@RequestParam String nomeLivro) {
        return listaAutores.stream()
                .filter(livro -> livro.verificarLivros(nomeLivro) != null)
                .collect(Collectors.toList());
    }

    @GetMapping("/buscar")
    public List<Autores> getAutorNacionalidade(@RequestParam String nacionalidade) {
        return listaAutores.stream()
                .filter(pais -> pais.verificarLivros(nacionalidade) != null)
                .collect(Collectors.toList());
    }

    @GetMapping("/buscar")
    public List<Autores> getAutorGenero(@RequestParam String genero) {
        return listaAutores.stream()
                .filter(autor -> autor.getObras().stream()
                        .anyMatch(livro -> livro.verificarGeneros(
                                genero) != null))
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autores postAutores(@RequestBody Autores autor) {
        listaAutores.add(autor);
        return autor;
    }

    @DeleteMapping("deletar/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletedAutor(@PathVariable Long id) {
        listaAutores.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .map(autor -> listaAutores.remove(autor))
                .orElse(null);
    }

    @PutMapping("atualizar/{id}")
    public Autores putMethodName(@PathVariable Long id, @RequestBody Autores body) {
        return listaAutores.stream()
                .filter(autor -> autor.getId().equals(id))
                .findFirst()
                .map(b -> {
                    b.setId(body.getId());
                    b.setNome(body.getNome());
                    b.setNacionalidade(body.getNacionalidade());
                    b.setBiografia(body.getBiografia());
                    b.setAniversario(body.getAniversario());
                    b.setObras(body.getObras());
                    return b;
                }).orElse(null);
    }
}
