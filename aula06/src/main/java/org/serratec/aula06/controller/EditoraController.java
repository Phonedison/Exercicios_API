package org.serratec.aula06.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.aula06.domain.Editora;
import org.serratec.aula06.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

    @Autowired
    private EditoraRepository editoraRepository;

    @GetMapping
    public ResponseEntity<List<Editora>> listar() {
        List<Editora> editoras = editoraRepository.findAll();
        return ResponseEntity.ok(editoras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editora> listar(@PathVariable Long id) {

        Optional<Editora> editora = editoraRepository.findById(id);

        if (editora.isPresent())
            return ResponseEntity.ok(editora.get());

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Editora inserir(@Valid @RequestBody Editora Editora) {
        return editoraRepository.save(Editora);
    }

    @PostMapping("/lista")
    public List<Editora> inserirVarios(@RequestBody List<Editora> Editoras) {
        return editoraRepository.saveAll(Editoras);
    }

}
