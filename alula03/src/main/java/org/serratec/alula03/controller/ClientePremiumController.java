package org.serratec.alula03.controller;

import java.util.List;

import org.serratec.alula03.domain.ClientePremium;
import org.serratec.alula03.exception.RecursoNaoEncontradoException;
import org.serratec.alula03.repository.ClientePremiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes-premium")
public class ClientePremiumController {

    @Autowired
    private ClientePremiumRepository clientePremiumRepository;

    @GetMapping
    public List<ClientePremium> listar() throws RecursoNaoEncontradoException {
        return clientePremiumRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientePremium> buscar(@PathVariable Long id) {
        return clientePremiumRepository.findById(id).map(cliente -> ResponseEntity.ok(cliente))
                .orElseThrow(
                        () -> new RecursoNaoEncontradoException("Cliente Premium de ID '" + id + "' não encontrado!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientePremium> atualizar(@PathVariable Long id,
            @Valid @RequestBody ClientePremium body) {

        if (!clientePremiumRepository.existsById(id))
            return ResponseEntity.notFound().build();

        body.setId(id);
        return ResponseEntity.ok(clientePremiumRepository.save(body));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientePremium postClientePremium(@Valid @RequestBody ClientePremium body) {
        return clientePremiumRepository.save(body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        return clientePremiumRepository.findById(id)
                .map(cliente -> {
                    clientePremiumRepository.delete(cliente);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
