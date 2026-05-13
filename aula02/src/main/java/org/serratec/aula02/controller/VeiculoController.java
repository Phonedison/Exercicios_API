package org.serratec.aula02.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.serratec.aula02.domain.Veiculo;
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

@RestController // -> Não confundir sempre inserir @RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private static final List<Veiculo> listaVeiculos = new ArrayList<>();

    static {
        listaVeiculos.add(new Veiculo(1L, "Toyota", "Corolla"));
        listaVeiculos.add(new Veiculo(2L, "Honda", "Civic"));
        listaVeiculos.add(new Veiculo(3L, "Fiat", "Uno"));
    }

    // método para listar todos os veículos cadastrados -> utilizando o GET
    // http://localhost:8080/veiculos -> URI
    @GetMapping
    public List<Veiculo> listarVeiculos() {
        return listaVeiculos;
    }

    @GetMapping("/{id}") // -> utilizando o método
    public Veiculo buscarVeiculo(@PathVariable Long id) {
        return listaVeiculos.stream()
                .filter(veiculo -> veiculo.getId().equals(id))
                .findFirst().orElse(null);

        /*
         * collect -> contate o array em uma string com base no parâmetro de divisão
         * map - > mapia o parâmetro com base o que precisa realizar
         * forEach -> percorre array de forma simplificada == for (Array objeto: lista
         * Array)
         * toList -> converte os elementos em uma lista
         * reduce -> transforma os parameters em um só
         * filter -> utiliza para filtrar
         */
    }

    @GetMapping("/buscar")
    public Stream<Veiculo> filtrarMarca(@RequestParam String marca) { // retorna uma lista do tipo Stream
        return listaVeiculos.stream()
                .filter(veiculo -> veiculo.getMarca().equalsIgnoreCase(marca));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo cadastrarVeiculo(@RequestBody Veiculo veiculo) {
        listaVeiculos.add(veiculo);
        return veiculo;
    }

    @PutMapping("/{id}")
    public Veiculo atualizarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        return listaVeiculos.stream()
                .filter(car -> car.getId().equals(id))
                .findFirst().map(vei -> {
                    vei.setId(veiculo.getId());
                    vei.setModelo(veiculo.getModelo());
                    vei.setMarca(veiculo.getMarca());
                    return vei;
                }).orElse(null);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletarVeiculo(@PathVariable Long id) {
        listaVeiculos.stream()
                .filter(veiculo -> veiculo.getId().equals(id))
                .findFirst()
                .map(a -> listaVeiculos.remove(a))
                .orElse(null);

        /* listaveiculos.removeIf( veiculos -> veiculos.getId().equals(id)); */
    }

}
