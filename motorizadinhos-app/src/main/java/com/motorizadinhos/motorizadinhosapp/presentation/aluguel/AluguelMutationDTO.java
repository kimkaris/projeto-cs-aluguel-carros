package com.motorizadinhos.motorizadinhosapp.presentation.aluguel;

import java.util.UUID;

public class AluguelMutationDTO {

    private UUID carro;
    private String cliente;
    private UUID responsavel;

    public AluguelMutationDTO(UUID carro, String cliente, UUID responsavel) {
        this.carro = carro;
        this.cliente = cliente;
        this.responsavel = responsavel;
    }

    protected AluguelMutationDTO() {}

    public UUID getCarro() {
        return carro;
    }

    public String getCliente() {
        return cliente;
    }

    public UUID getResponsavel() {
        return responsavel;
    }

}
