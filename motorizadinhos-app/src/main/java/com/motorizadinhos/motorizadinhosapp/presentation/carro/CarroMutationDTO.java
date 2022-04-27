package com.motorizadinhos.motorizadinhosapp.presentation.carro;

import java.util.List;
import java.util.UUID;

public class CarroMutationDTO {

    private String modelo;
    private String marca;
    private Short ano;
    private Integer quilometragem;
    private List<UUID> caracteristicas;
    private boolean inativar = false;

    public CarroMutationDTO(String modelo, String marca, Short ano, Integer quilometragem, List<UUID> caracteristicas, boolean inativar) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.caracteristicas = caracteristicas;
        this.inativar = inativar;
    }

    protected CarroMutationDTO() {}

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public Short getAno() {
        return ano;
    }

    public Integer getQuilometragem() {
        return quilometragem;
    }

    public List<UUID> getCaracteristicas() {
        return caracteristicas;
    }

    public boolean deveInativar() {
        return inativar;
    }

}
