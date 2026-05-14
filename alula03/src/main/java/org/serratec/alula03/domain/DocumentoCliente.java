package org.serratec.alula03.domain;

import org.serratec.alula03.enumerated.StatusCliente;
import org.serratec.alula03.enumerated.TipoCliente;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class DocumentoCliente {
    private String cpfOuCnpj;
    private String rgInscricaoEstadual;

    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente;

    @Enumerated(EnumType.ORDINAL)
    private StatusCliente statusCliente;

    public DocumentoCliente() {
    }

    public DocumentoCliente(String cpfOuCnpj, String rgInscricaoEstadual, TipoCliente tipoCliente,
            StatusCliente statusCliente) {
        this.cpfOuCnpj = cpfOuCnpj;
        this.rgInscricaoEstadual = rgInscricaoEstadual;
        this.tipoCliente = tipoCliente;
        this.statusCliente = statusCliente;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public String getRgInscricaoEstadual() {
        return rgInscricaoEstadual;
    }

    public void setRgInscricaoEstadual(String rgInscricaoEstadual) {
        this.rgInscricaoEstadual = rgInscricaoEstadual;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public StatusCliente getStatusCliente() {
        return statusCliente;
    }

    public void setStatusCliente(StatusCliente statusCliente) {
        this.statusCliente = statusCliente;
    }

}
