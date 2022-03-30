package com.motorizadinhos.motorizadinhosapp.application.entity.pessoa;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "contato")
public class Contato {

    @Id
    @Column(name = "id", length = 36, unique = true, nullable = false)
    private final UUID id = UUID.randomUUID();
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Pessoa pessoa;
    @Column(name = "email", length = 120, unique = true, nullable = false)
    private String email;
    @Column(name = "telefone_fixo", length = 10)
    private String telefoneFixo;
    @Column(name = "telefone_celular", length = 11)
    private String telefoneCelular;

    protected Contato() {}

    private Contato(Builder builder) {
        this.email = builder.email;
        this.telefoneFixo = builder.telefoneFixo;
        this.telefoneCelular = builder.telefoneCelular;
    }

    public static class Builder {
        private final String email;
        private String telefoneFixo;
        private String telefoneCelular;

        public Builder(String email) {
            this.email = email;
        }

        public Builder comTelefoneFixo(String telefoneFixo) {
            this.telefoneFixo = telefoneFixo.replaceAll("[^0-9]","");
            return this;
        }

        public Builder comTelefoneCelular(String telefoneCelular) {
            this.telefoneCelular = telefoneCelular.replaceAll("[^0-9]","");;
            return this;
        }

        public Contato build() {
            return new Contato(this);
        }
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

}
