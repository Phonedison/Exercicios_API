package org.serratec.aula05.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.aula05.domain.Veiculo;
import org.serratec.aula05.repository.VeiculoRepository;
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
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping
    public ResponseEntity<List<Veiculo>> listar() {
        List<Veiculo> veiculos = veiculoRepository.findAll();
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> listar(@PathVariable Long id) {

        Optional<Veiculo> veiculo = veiculoRepository.findById(id);

        if (veiculo.isPresent())
            return ResponseEntity.ok(veiculo.get());

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo inserir(@RequestBody Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @PostMapping("/lista")
    public List<Veiculo> inserirVarios(@RequestBody List<Veiculo> veiculos) {

        return veiculoRepository.saveAll(veiculos);
    }

}
