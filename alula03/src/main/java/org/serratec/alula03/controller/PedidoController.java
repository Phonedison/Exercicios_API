package org.serratec.alula03.controller;

import java.util.List;

import org.serratec.alula03.domain.Pedido;
import org.serratec.alula03.exception.RecursoNaoEncontradoException;
import org.serratec.alula03.repository.PedidoRepository;
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
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidosRepository;

    @GetMapping
    public List<Pedido> getListPedido() {
        return pedidosRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id) throws RecursoNaoEncontradoException {

        return pedidosRepository.findById(id)
                .map(pedido -> ResponseEntity.ok(pedido))
                .orElseThrow(() -> new RecursoNaoEncontradoException("Pedido de ID '" + id + "' não encontrado!"));
        /*
         * Optional<Pedido> pedidos = pedidosRepository.findById(id);
         * 
         * if (!pedidos.isPresent())
         * return ResponseEntity.notFound().build();
         * 
         * return ResponseEntity.ok(pedidos.get());
         */

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido postPedido(@Valid @RequestBody Pedido body) {
        return pedidosRepository.save(body);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> putPedido(@Valid @PathVariable Long id, @Valid @RequestBody Pedido body) {

        /*
         * return pedidosRepository.findById(id)
         * .map(pedidoExistente -> {
         * body.setId(id); // -> utiliza o mesmo método
         * Pedido atualizado = pedidosRepository.save(body); // necessário criar um
         * objeto da classe para
         * // retorna-la depois
         * return ResponseEntity.ok(atualizado); // -> Retorna o cabeçalho como 200 - OK
         * }).orElseGet(() -> ResponseEntity.notFound().build()); // -> Retorna o
         * cabeçalho como 404 - NOT FOUND
         */

        if (!pedidosRepository.existsById(id))
            return ResponseEntity.notFound().build();

        body.setId(id);
        body = pedidosRepository.save(body);
        return ResponseEntity.ok(body);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {

        return pedidosRepository.findById(id) // -> encontra o ID informado
                .map(pedido -> {
                    pedidosRepository.deleteById(id); // -> deleta o ID
                    return ResponseEntity.noContent().<Void>build(); // -> Retorna o cabeçalho como 202 - NO CONTENT
                }).orElseGet(() -> ResponseEntity.notFound().build()); // -> Retorna o cabeçalho como 404 - NOT FOUND

        /*
         * if (!pedidosRepository.existsById(id))
         * return ResponseEntity.notFound().build();
         * 
         * pedidosRepository.deleteById(id);
         * return ResponseEntity.noContent().build();
         */
    }
}
