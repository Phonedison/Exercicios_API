package org.serratec.alula03.enumerated;

import org.serratec.alula03.exception.EnumValidationException;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoCliente {
    PF, PJ;

    @JsonCreator
    public static TipoCliente verificar(String value) throws EnumValidationException {
        for (TipoCliente tc : values()) {
            if (value.equals(tc.name())) {
                return tc;
            }
        }
        throw new EnumValidationException("Categoria inválida. Valores válidos: PF e PJ ");
    }
}
