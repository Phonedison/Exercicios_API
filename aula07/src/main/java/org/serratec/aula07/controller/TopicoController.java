package org.serratec.aula07.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.aula07.domain.Topico;
import org.serratec.aula07.repository.CursoRepository;
import org.serratec.aula07.repository.TopicoRepository;
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
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public ResponseEntity<List<Topico>> listar() {
        List<Topico> topicos = topicoRepository.findAll();
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> listar(@PathVariable Long id) {

        Optional<Topico> topicos = topicoRepository.findById(id);

        if (topicos.isPresent())
            return ResponseEntity.ok(topicos.get());

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Topico> cadastrar(@Valid @RequestBody Topico topico) {
        if (topico.getCurso() == null || topico.getCurso().getId() == null) {
            return ResponseEntity.badRequest().build();
        }

        return cursoRepository.findById(topico.getCurso().getId())
                .map(top -> {
                    topico.setCurso(top);
                    Topico salvo = topicoRepository.save(topico);
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(salvo);
                }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/lista")
    public List<Topico> inserirVarios(@RequestBody List<Topico> topicos) {
        return topicoRepository.saveAll(topicos);
    }

}
