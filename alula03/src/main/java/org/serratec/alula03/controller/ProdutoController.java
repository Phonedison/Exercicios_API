package org.serratec.alula03.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.alula03.domain.Produto;
import org.serratec.alula03.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id); // sem Optional ele vai quebrar -> sendo necessário

        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto inserir(@Validated @RequestBody Produto body) {
        return produtoRepository.save(body); // -> Salvando o produto informado pelo usuário
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@Valid @PathVariable Long id, @Valid @RequestBody Produto produto) {

        if (!produtoRepository.existsById(id)) { // -> Se não existe, retorna não encontrado!
            return ResponseEntity.notFound().build();
        }
        produto.setId(id); // -> Evita o banco informar que ele não existe
        produto = produtoRepository.save(produto);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!produtoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
