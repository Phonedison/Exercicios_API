package org.serratec.aula02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // classe de controller
@RequestMapping("/hello") /* Mapeando o método */
public class HelloWorldController {

    @GetMapping // é possível declarar apenas um sem passagem
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/msg") // controller dentro de outro controler
    public String helloWorld2() {
        return "Hello World! 2";
    }

    @GetMapping("/bemVindo")
    // passando parâmetro ->
    // Usa o nome da variável = valor (Ex:
    // http://localhost:8080/hello/bemVindo?valor=lucas_
    public String bemVindo(@RequestParam String valor) {
        return ("Seja bem vindo, " + valor.toUpperCase());
    }

    @GetMapping("/somar")
    public String somar(@RequestParam int v1, @RequestParam int v2) {
        return "A soma do valor é " + (v1 + v2);
    }
}
