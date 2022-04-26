package com.motorizadinhos.motorizadinhosapp.presentation.carro;

public class CaracteristicaCarroMutationDTO {

    private String caracteristica;
    private String descricao;

    public CaracteristicaCarroMutationDTO(String caracteristica, String descricao) {
        this.caracteristica = caracteristica;
        this.descricao = descricao;
    }

    protected CaracteristicaCarroMutationDTO() {}

    public String getCaracteristica() {
        return caracteristica;
    }

    public String getDescricao() {
        return descricao;
    }

}
