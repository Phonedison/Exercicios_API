package org.serratec.aula05.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.aula05.domain.Manutencao;
import org.serratec.aula05.repository.ManutencaoRepository;
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
@RequestMapping("/manutencoes")
public class ManutencaoController {

    @Autowired
    private ManutencaoRepository manutencaoRepository;

    @GetMapping
    public ResponseEntity<List<Manutencao>> listar() {
        List<Manutencao> manutencao = manutencaoRepository.findAll();
        return ResponseEntity.ok(manutencao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manutencao> listar(@PathVariable Long id) {

        Optional<Manutencao> manutencao = manutencaoRepository.findById(id);

        if (manutencao.isPresent())
            return ResponseEntity.ok(manutencao.get());

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Manutencao inserir(@RequestBody Manutencao manutencao) {
        return manutencaoRepository.save(manutencao);
    }

    @PostMapping("/lista")
    public List<Manutencao> inserirVarios(@RequestBody List<Manutencao> manutencao) {
        return manutencaoRepository.saveAll(manutencao);
    }

}
