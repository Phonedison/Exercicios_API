package org.serratec.aula07.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.aula07.domain.Aluno;
import org.serratec.aula07.repository.AlunoRepository;
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
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    AlunoRepository alunoRepository;

    @GetMapping
    public ResponseEntity<List<Aluno>> listar() {
        List<Aluno> alunos = alunoRepository.findAll();
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> listar(@Valid @PathVariable Long id) {

        Optional<Aluno> alunos = alunoRepository.findById(id);

        if (alunos.isPresent())
            return ResponseEntity.ok(alunos.get());

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno inserir(@Valid @RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @PostMapping("/lista")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Aluno> inserirVarios(@Valid @RequestBody List<Aluno> alunos) {
        return alunoRepository.saveAll(alunos);
    }

}
