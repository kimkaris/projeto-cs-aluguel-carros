package com.motorizadinhos.motorizadinhosapp.application.entity.carro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "caracteristica_carro")
public class CaracteristicaCarro {

    @Id
    @Column(name = "id", length = 36, unique = true, nullable = false)
    private final UUID id = UUID.randomUUID();
    @Column(name = "caracteristica", length = 80, nullable = false)
    private String caracteristica;
    @Column(name = "descricao", length = 512, nullable = false)
    private String descricao;

    protected CaracteristicaCarro() {}

    public CaracteristicaCarro(String caracteristica, String descricao) {
        this.caracteristica = caracteristica;
        this.descricao = descricao;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
