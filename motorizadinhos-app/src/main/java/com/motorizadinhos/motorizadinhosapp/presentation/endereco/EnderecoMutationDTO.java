package com.motorizadinhos.motorizadinhosapp.presentation.endereco;

import com.motorizadinhos.motorizadinhosapp.application.entity.endereco.Estado;

public class EnderecoMutationDTO {

    private Estado estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String numero;

    public EnderecoMutationDTO(Estado estado, String cidade, String bairro, String logradouro, String numero) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
    }

    protected EnderecoMutationDTO() {}

    public Estado getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

}
