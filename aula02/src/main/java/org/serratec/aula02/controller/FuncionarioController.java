package org.serratec.aula02.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.serratec.aula02.domain.Funcionario;
import org.springframework.http.HttpStatus;
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

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private static final List<Funcionario> listaFuncionarios = new ArrayList<>();

    static {
        listaFuncionarios.add(new Funcionario(1L, "João Pedro", "Monitor"));
        listaFuncionarios.add(new Funcionario(2L, "Vinicius Lama", "Presidente"));
        listaFuncionarios.add(new Funcionario(3L, "Yan Martins", "Encarregado de Administrativo"));
        listaFuncionarios.add(new Funcionario(4L, "Lucas da Silva", "Desenvolvedor em modo fecal"));
        listaFuncionarios.add(new Funcionario(5L, "Yan Martins", "Gerente"));
    }

    @GetMapping
    public List<Funcionario> listarFuncionarios() {
        return listaFuncionarios;
    }

    @GetMapping("/{id}")
    public Funcionario buscarFuncionario(@PathVariable Long id) {
        return listaFuncionarios.stream()
                .filter(fun -> fun.getId().equals(id)).findFirst()
                .orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario cadastrarFuncionario(@RequestBody Funcionario funcionario) {
        listaFuncionarios.add(funcionario);
        return funcionario;
    }

    @PutMapping("/{id}")
    public Funcionario atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        return listaFuncionarios.stream()
                .filter(fun -> fun.getId().equals(id))
                .findFirst().map(fun -> {
                    fun.setId(funcionario.getId());
                    fun.setNome(funcionario.getNome());
                    fun.setCargo(funcionario.getCargo());
                    return fun;
                }).orElse(null);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletarFuncionario(@PathVariable Long id) {
        listaFuncionarios.stream()
                .filter(funcionario -> funcionario.getId().equals(id))
                .findFirst()
                .map(f -> listaFuncionarios.remove(f))
                .orElse(null);
    }

    @GetMapping("/buscar")
    public Stream<Funcionario> filtrarCargo(@RequestParam String cargo) {
        return listaFuncionarios.stream()
                .filter(funcionario -> funcionario.getCargo().equals(cargo));
    }

}
