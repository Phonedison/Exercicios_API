package org.serratec.aula02.controller;

import java.util.ArrayList;
import java.util.List;

import org.serratec.aula02.domain.Aluno;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos") // criando o caminho
public class AlunoController {

    private static final List<Aluno> listaAlunos = new ArrayList<>();

    // criando uma lista
    static {
        listaAlunos.add(new Aluno(2354L, "Carla", "2224-0439"));
        listaAlunos.add(new Aluno(2343L, "Carlos", "2334-0239"));
        listaAlunos.add(new Aluno(1409L, "Maria", "2343-2345"));
    }

    @GetMapping
    public List<Aluno> listarAlunos() { // criando um método para listar
        return listaAlunos;
    }

    // está sendo utilizado a arquitetura REST -> Estudar mais

    // -----------------
    // método que informa que passe um parâmetro de pesquisa com base no get / set /
    // constructor
    @GetMapping("/{matricula}") // método de passar um valor de parâmetro -> matricula

    // passagem -> GET -> http://localhost:8080/alunos/2345
    public Aluno buscarAlunoPorMatricula(@PathVariable Long matricula) {
        for (Aluno aluno : listaAlunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null;
    }

    @PostMapping // método padrão de inserção de valor -> não passa parâmetro já que será
                 // utilizado uma vez
    @ResponseStatus(HttpStatus.CREATED) // --> Método de retorno do HEAD -> Status
    public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
        listaAlunos.add(aluno);
        return aluno;
    }

    // não esquecer o /aluno/.. antes de testar ->
    @DeleteMapping("/deletarAluno/{matricula}")
    public void deletarAluno(@PathVariable Long matricula) {
        for (Aluno aluno : listaAlunos) {
            if (aluno.getMatricula().equals(matricula)) {
                listaAlunos.remove(aluno);
                // removeIf
                // iterator
                // return listaAluno.stream().filter(aluno ->
                // aluno.getMatricula().equals(matricula)).findFirst().orElse(null);
                break;
            }
        }
    }

    @PutMapping("/atualizarAluno/{matricula}")
    public Aluno atualizarAluno(@PathVariable Long matricula, @RequestBody Aluno aluno) {

        /*
         * primeira ideia
         * for (Aluno alu : listaAlunos) {
         * if (alu.getMatricula().equals(matricula)) {
         * alu.setMatricula(matricula);
         * alu.setNome(aluno.getNome());
         * alu.setMatricula(aluno.getMatricula());
         * alu.setTelefone(aluno.getTelefone());
         * return aluno;
         * }
         * }
         * return null;
         */

        return listaAlunos.stream()
                .filter(a -> a.getMatricula().equals(matricula)) // -> filtra o aluno
                .findFirst() // -> acha o primeiro
                .map(a -> { // -> destrincha e mapeá o aluno
                    a.setMatricula(aluno.getMatricula()); // -> altera a matricula
                    a.setNome(aluno.getNome()); // -> altera o nome
                    a.setTelefone(aluno.getTelefone()); // -> altera o telefone
                    return a; // -> retorna o aluno
                }).orElse(null); // -> caso contrário, retorna null

    }
}
