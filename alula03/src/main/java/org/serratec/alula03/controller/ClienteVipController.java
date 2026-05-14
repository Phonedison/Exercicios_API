package org.serratec.alula03.controller;

import java.util.List;

import org.serratec.alula03.domain.ClienteVip;
import org.serratec.alula03.exception.RecursoNaoEncontradoException;
import org.serratec.alula03.repository.ClienteVipRepository;
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
@RequestMapping("/clientes-vip")
public class ClienteVipController {

    @Autowired
    private ClienteVipRepository clienteVipRepository;

    @GetMapping
    public List<ClienteVip> listar() throws RecursoNaoEncontradoException {
        return clienteVipRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteVip> buscar(@PathVariable Long id) {
        return clienteVipRepository.findById(id).map(vip -> ResponseEntity.ok(vip))
                .orElseThrow(() -> new RecursoNaoEncontradoException("ClienteVip não encontrado!"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteVip inserir(@RequestBody ClienteVip body) {
        return clienteVipRepository.save(body);
    }

}
