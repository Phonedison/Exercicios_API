package org.serratec.aula05.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.aula05.domain.Proprietario;
import org.serratec.aula05.repository.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    @GetMapping
    public ResponseEntity<List<Proprietario>> listar() {
        List<Proprietario> proprietarios = proprietarioRepository.findAll();
        return ResponseEntity.ok(proprietarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proprietario> listar(@PathVariable Long id) {

        Optional<Proprietario> proprietario = proprietarioRepository.findById(id);

        if (proprietario.isPresent())
            return ResponseEntity.ok(proprietario.get());

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Proprietario inserir(@RequestBody Proprietario proprietario) {
        return proprietarioRepository.save(proprietario);
    }

    @PostMapping("/lista")
    public List<Proprietario> inserirVarios(@RequestBody List<Proprietario> proprietarios) {
        return proprietarioRepository.saveAll(proprietarios);
    }

}
