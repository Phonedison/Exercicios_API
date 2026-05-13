package org.serratec.aula02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // classe Controller
@RequestMapping("/calculadora")
public class CalculadoraController {

    @GetMapping("/somar") // 1. Somar — GET /calculadora/somar?a=10&b=5
    public Double somar(@RequestParam double a, @RequestParam double b) {
        return (a + b);
    }

    @GetMapping("/subtrair") // 2. Subtrair — GET /calculadora/subtrair?a=10&b=5
    public Double subtrair(@RequestParam double a, @RequestParam double b) {
        return (a - b);
    }

    @GetMapping("/multiplicar") // 3. Multiplicar — GET /calculadora/multiplicar?a=4&b=3
    public Double multiplicar(@RequestParam double a, @RequestParam double b) {
        return (a * b);
    }

    @GetMapping("/dividir") // 4. Dividir — GET /calculadora/dividir?a=10&b=2
    public Double dividir(@RequestParam double a, @RequestParam double b) {
        // Atenção: trate a divisão por zero!
        if (a % b == 0) {
            return (a / b);
        } else {
            throw new IllegalArgumentException("Valor não possível ser divido por zero");
        }
    }

}
