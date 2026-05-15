package org.serratec.aula07.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.aula07.domain.Curso;
import org.serratec.aula07.domain.Topico;
import org.serratec.aula07.repository.CursoRepository;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cursos")

public class CursoController {

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping
    public ResponseEntity<List<Curso>> listar() {
        List<Curso> cursos = cursoRepository.findAll();
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> listar(@Valid @PathVariable Long id) {

        Optional<Curso> cursos = cursoRepository.findById(id);

        if (cursos.isPresent())
            return ResponseEntity.ok(cursos.get());

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/topicos")
    @JsonIgnoreProperties({ "curso" })
    public ResponseEntity<List<Topico>> listarTopicos(@Valid @PathVariable Long id) {

        return cursoRepository.findById(id)
                .map(curso -> ResponseEntity.ok(curso.getTopicos()))
                .orElse(ResponseEntity.notFound().build());

        /*
         * Optional<Curso> curso = cursoRepository.findById(id);
         * 
         * if (curso.isPresent()) {
         * List<Topico> listaTopico = curso.get().getTopicos();
         * return ResponseEntity.ok(listaTopico);
         * }
         * 
         * return ResponseEntity.notFound().build();
         */
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Curso inserir(@Valid @RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    @PostMapping("/lista")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Curso> inserirVarios(@Valid @RequestBody List<Curso> cursos) {
        return cursoRepository.saveAll(cursos);
    }

}
