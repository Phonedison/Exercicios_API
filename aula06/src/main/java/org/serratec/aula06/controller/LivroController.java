package org.serratec.aula06.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.aula06.domain.Livro;
import org.serratec.aula06.repository.EditoraRepository;
import org.serratec.aula06.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private EditoraRepository editoraRepository;

    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        List<Livro> livros = livroRepository.findAll();
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> listar(@PathVariable Long id) {

        Optional<Livro> livros = livroRepository.findById(id);

        if (livros.isPresent())
            return ResponseEntity.ok(livros.get());

        return ResponseEntity.notFound().build();
    }

    /*
     * @PostMapping
     * 
     * @ResponseStatus(HttpStatus.CREATED)
     * public Livro inserir(@RequestBody Livro livro) {
     * return livroRepository.save(livro);
     * }
     */

    @PostMapping
    public ResponseEntity<Livro> cadastrar(@Valid @RequestBody Livro livro) {
        if (livro.getEditora() == null || livro.getEditora().getId() == null) {
            return ResponseEntity.badRequest().build();
        }

        return editoraRepository.findById(livro.getEditora().getId()).map(editora -> {
            livro.setEditora(editora);
            Livro salvo = livroRepository.save(livro);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/lista")
    public List<Livro> inserirVarios(@RequestBody List<Livro> livros) {
        return livroRepository.saveAll(livros);
    }
}
