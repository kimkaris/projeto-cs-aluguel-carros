package com.motorizadinhos.motorizadinhosapp.application.entity.endereco;

import com.motorizadinhos.motorizadinhosapp.application.entity.pessoa.Pessoa;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @Column(name = "id", length = 36, unique = true, nullable = false)
    private final UUID id = UUID.randomUUID();
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Pessoa pessoa;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "estado", length = 2, nullable = false)
    private Estado estado;
    @Column(name = "cidade", length = 80, nullable = false)
    private String cidade;
    @Column(name = "bairro", length = 80, nullable = false)
    private String bairro;
    @Column(name = "logradouro", length = 80, nullable = false)
    private String logradouro;
    @Column(name = "numero", length = 20, nullable = false)
    private String numero;

    protected Endereco() {}

    private Endereco(Builder builder) {
        this.estado = builder.estado;
        this.cidade = builder.cidade;
        this.bairro = builder.bairro;
        this.logradouro = builder.logradouro;
        this.numero = builder.numero;
    }

    public static class Builder {
        private final Estado estado;
        private final String cidade;
        private String bairro;
        private String logradouro;
        private String numero;

        public Builder(Estado estado, String cidade) {
            this.estado = estado;
            this.cidade = cidade.toUpperCase();
        }

        public Builder noBairro(String bairro) {
            this.bairro = bairro.toUpperCase();
            return this;
        }

        public Builder noLogradouro(String logradouro) {
            this.logradouro = logradouro.toUpperCase();
            return this;
        }

        public Builder noNumero(String numero) {
            this.numero = numero.toUpperCase();
            return this;
        }

        public Endereco build() {
            return new Endereco(this);
        }
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
