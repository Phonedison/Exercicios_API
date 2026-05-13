package org.serratec.alula03.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.serratec.alula03.domain.Cliente;
import org.serratec.alula03.repository.ClienteRepository;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (!cliente.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente.get());
    }

    @GetMapping("/buscar")
    public List<Cliente> buscarNome(@RequestParam String nome) {

        return clienteRepository.findAll().stream()
                .filter(c -> c.getNome().toLowerCase()
                        .contains(nome.toLowerCase()))
                .collect(Collectors.toList());

        /*
         * // List<Cliente> clientes = clienteRepository.findAll(); // -> método para
         * buscar todos
         * /* -> utilizando o método stream e jogando para objeto List<Cliente>
         * List<Cliente> resultado = clientes.stream()
         * .filter(cliente ->
         * cliente.getNome().toLowerCase().contains(nome.toLowerCase())) // -> filtra o
         * valor de
         * nome, verificando se
         * está presente em
         * getCliente()
         * passando como
         * minusculo os valores
         * .collect(Collectors.toList()); // -> Retorna como uma lista
         * if (resultado.isEmpty()) // Se for vazio
         * return ResponseEntity.notFound().build(); // Retorna como não encontrado ->
         * .build() serve para finalizar a
         * construção do HTTP
         * return ResponseEntity.ok(resultado);
         */
    }

    /*
     * @GetMapping("/buscar")
     * public ResponseEntity<Cliente> getNome(@RequestParam String nome) {
     * 
     * return clienteRepository.findAll().stream()
     * .filter(cliente -> cliente.getNome()
     * .toLowerCase()
     * .contains(nome.toLowerCase()))
     * .findAny()
     * .map(ResponseEntity::ok)
     * .orElse(ResponseEntity
     * .notFound()
     * .build());
     * }
     */

    /*
     * @GetMapping("/buscar/nome")
     * public ResponseEntity<List<Cliente>> getNome(@RequestParam String valor) {
     * List<Cliente> clientes = clienteRepository.findByNome(valor);
     * 
     * if (clientes.isEmpty())
     * return ResponseEntity.notFound().build();
     * 
     * return ResponseEntity.ok(clientes);
     * }
     */

    /*
     * @GetMapping("/buscar")
     * public List<Cliente> getAniversario(@RequestParam Integer idade) {
     * LocalDate dataLimite = LocalDate.now().minusYears(idade);
     * 
     * return clienteRepository.findByDataNascimento(dataLimite);
     * }
     */

    /*
     * @GetMapping("/buscar/cpf")
     * public ResponseEntity<Cliente> getCpf(@RequestParam String valor) {
     * Optional<Cliente> cliente = clienteRepository.findByCpf(valor);
     * 
     * if (!cliente.isPresent())
     * return ResponseEntity.notFound().build();
     * 
     * return ResponseEntity.ok(cliente.get());
     * }
     */

    /*
     * @GetMapping("/buscar") // -> (required = false) -> Determina o tipo da
     * variável opcional
     * public ResponseEntity<Cliente> getCliente(
     * 
     * @RequestParam(required = false) String nome,
     * 
     * @RequestParam(required = false) String cpf) {
     * 
     * if (nome == null && cpf == null)
     * return ResponseEntity.badRequest().build();
     * 
     * Optional<Cliente> cliente = null;
     * 
     * if (nome != null)
     * cliente = clienteRepository.findByNome(nome);
     * if (cpf != null)
     * cliente = clienteRepository.findByCpf(cpf);
     * 
     * if (!cliente.isPresent()) {
     * return ResponseEntity.notFound().build();
     * }
     * 
     * return ResponseEntity.ok(cliente.get());
     * }
     */

    // -> Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long id, @Valid @RequestBody Cliente body) {
        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        body.setId(id);
        body = clienteRepository.save(body);
        return ResponseEntity.ok(body);
    }

    // -> Criar
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente inserir(@Valid @RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {

        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

}
