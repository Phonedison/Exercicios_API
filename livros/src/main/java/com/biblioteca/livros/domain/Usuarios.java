package com.biblioteca.livros.domain;

import java.util.List;

public class Usuarios {
    private Long id;
    private String cpf;
    private String nome;
    private Integer limiteEmprestimo;
    private List<Livros> emprestimos;

    public Usuarios(Long id, String cpf, String nome, Integer limiteEmprestimo, List<Livros> emprestimos) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.limiteEmprestimo = limiteEmprestimo;
        this.emprestimos = emprestimos;
    }

    public Usuarios() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getLimiteEmprestimo() {
        return limiteEmprestimo;
    }

    public void setLimiteEmprestimo(Integer limiteEmprestimo) {
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public List<Livros> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Livros> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public Usuarios verificarCpf(String cpf) {
        boolean existe = this.cpf.equals(cpf);
        return existe ? this : null;
    }

}
