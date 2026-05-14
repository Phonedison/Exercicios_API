package org.serratec.aula05.enumerated;

import org.serratec.aula05.exception.EnumValidationException;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Combustivel {
    GASOLINA(1, "Gasolina"),
    ALCOOL(2, "Álcool"),
    DIESEL(3, "Diesel"),
    FLEX(4, "Flex");

    private final Integer codigo;
    private final String tipo;

    private Combustivel(Integer codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    @JsonCreator
    public static Combustivel verificar(Integer value) throws EnumValidationException {
        for (Combustivel c : values()) {
            if (value.equals(c)) {
                return c;
            }
        }
        throw new EnumValidationException(
                "Combustivel inválido. Válidos: 1 - Gasolina, 2 - Álcool, 3 - Diesel, 4 - Flex");
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

}
