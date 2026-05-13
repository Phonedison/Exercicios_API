package com.biblioteca.livros.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.livros.domain.Livros;
import com.biblioteca.livros.domain.Usuarios;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private static final List<Usuarios> listaUsuarios = DatabaseMock.usuarios;

    public List<Usuarios> listarUsuarios() {
        return listaUsuarios;
    }

    @GetMapping("/{id}")
    public Usuarios getUsuario(@RequestParam Long id) {
        return listaUsuarios.stream()
                .filter(usuario -> usuario.getId().equals(id))
                .findFirst().orElse(null);
    }

    @GetMapping("/{cpf}")
    public List<Usuarios> getUsuario(@RequestParam String cpf) {
        return listaUsuarios.stream()
                .filter(usuario -> usuario.verificarCpf(cpf
                        .trim()) != null)
                .collect(Collectors.toList());
    }

    @GetMapping("/limite")
    public List<Usuarios> getUsuarioLimite(@RequestParam Integer qtd) {
        return listaUsuarios.stream()
                .filter(usuario -> usuario.getLimiteEmprestimo().equals(qtd)).collect(Collectors.toList());
    }

    @GetMapping("/usuario")
    public List<Usuarios> getUsuarioNome(@RequestParam String nome) {
        return listaUsuarios.stream()
                .filter(user -> user.getNome().equals(nome))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}/emprestimos")
    public List<Livros> getListaLivros(@PathVariable Long id) {

        return listaUsuarios.stream()
                .filter(usuario -> usuario.getId().equals(id))
                .findFirst()
                .map(user -> user.getEmprestimos())
                .orElse(Collections.emptyList());
    }

}
