package org.serratec.aula05.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.aula05.domain.Servico;
import org.serratec.aula05.repository.ServicosRepository;
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

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicosRepository servicosRepository;

    @GetMapping
    public ResponseEntity<List<Servico>> listar() {
        List<Servico> servicos = servicosRepository.findAll();
        return ResponseEntity.ok(servicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> listar(@PathVariable Long id) {

        Optional<Servico> servicos = servicosRepository.findById(id);

        if (servicos.isPresent())
            return ResponseEntity.ok(servicos.get());

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servico inserir(@RequestBody Servico servicos) {
        return servicosRepository.save(servicos);
    }

    @PostMapping("/lista")
    public List<Servico> inserirVarios(@RequestBody List<Servico> servicos) {
        return servicosRepository.saveAll(servicos);
    }

}
