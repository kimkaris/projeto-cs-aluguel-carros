package com.motorizadinhos.motorizadinhosapp.application.entity.carro;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "carro")
public class Carro {

    @Id
    @Column(name = "id", length = 36, unique = true, nullable = false)
    private final UUID id = UUID.randomUUID();
    @Column(name = "modelo", length = 40, nullable = false)
    private String modelo;
    @Column(name = "marca", length = 40, nullable = false)
    private String marca;
    @Column(name = "ano", nullable = false)
    private Short ano;
    @Column(name = "quilometragem", length = 40, nullable = false)
    private Integer quilometragem;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", length = 12, nullable = false)
    private StatusCarro status = StatusCarro.DISPONIVEL;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "relacionamento_caracteristica_carro", joinColumns = @JoinColumn(name = "carro_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_caracteristica_carro"))
    private List<CaracteristicaCarro> caracteristicas;

    protected Carro() {}

    private Carro(Builder builder) {
        this.modelo = builder.modelo;
        this.marca = builder.marca;
        this.ano = builder.ano;
        this.quilometragem = builder.quilometragem;
        this.caracteristicas = builder.caracteristicas;
    }

    public static class Builder {
        private final String modelo;
        private final String marca;
        private final Short ano;
        private Integer quilometragem;
        private List<CaracteristicaCarro> caracteristicas;

        public Builder(String modelo, String marca, Short ano) {
            this.modelo = modelo.toUpperCase();
            this.marca = marca.toUpperCase();
            this.ano = ano;
        }

        public Carro.Builder comQuilometragem(Integer quilometragem) {
            this.quilometragem = quilometragem;
            return this;
        }

        public Carro.Builder comAsCaracteristicas(List<CaracteristicaCarro> caracteristicas) {
            this.caracteristicas = caracteristicas;
            return this;
        }

        public Carro build() {
            return new Carro(this);
        }
    }

    public void alugarCarro() {
        if (estaAlugado()) {
            throw new IllegalArgumentException("O veículo " + this + " já está alugado.");
        }
        this.status = StatusCarro.ALUGADO;
    }

    public boolean estaAlugado() {
        return this.status.equals(StatusCarro.ALUGADO);
    }

    public void encerrarAluguel() {
        if (!estaAlugado()) {
            throw new IllegalArgumentException("O veículo " + this + " não está alugado.");
        }
        this.status = StatusCarro.DISPONIVEL;
    }

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

    public void setQuilometragem(Integer quilometragem) {
        this.quilometragem = quilometragem;
    }

    public StatusCarro getStatus() {
        return status;
    }

    public List<CaracteristicaCarro> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<CaracteristicaCarro> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @Override
    public String toString() {
        return "[" + this.modelo + " | " + this.marca + " | " + this.ano + "]";
    }

}
