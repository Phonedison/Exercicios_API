package org.serratec.alula03.enumerated;

import org.serratec.alula03.exception.EnumValidationException;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StatusCliente {
    ATIVO, INATIVO, BLOQUEADO;

    @JsonCreator
    public static StatusCliente verificar(String value) throws EnumValidationException {
        for (StatusCliente sc : values()) {
            if (value.equals(sc.name())) {
                return sc;
            }
        }
        throw new EnumValidationException("Categoria inválida. Valores válidos: ATIVO, INATIVO e BLOQUEADO ");
    }
}
