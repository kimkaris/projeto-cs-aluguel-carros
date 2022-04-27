package com.motorizadinhos.motorizadinhosapp.application.entity.funcionario;

import com.motorizadinhos.motorizadinhosapp.application.entity.aluguel.Aluguel;
import com.motorizadinhos.motorizadinhosapp.application.entity.carro.Carro;
import com.motorizadinhos.motorizadinhosapp.application.entity.endereco.Endereco;
import com.motorizadinhos.motorizadinhosapp.application.entity.pessoa.Contato;
import com.motorizadinhos.motorizadinhosapp.application.entity.pessoa.Pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa {

    @Column(name = "email", length = 120, unique = true, nullable = false)
    private final String email;
    @Column(name = "senha", length = 20, nullable = false)
    private String senha;
    @Column(name = "administrador", nullable = false)
    private Boolean administrador = false;
    @Column(name = "ativo", nullable = false)
    private Boolean ativo = false;

    protected Funcionario() {
        this.email = super.nome.toLowerCase() + "." + super.sobrenome.toLowerCase() + "@uem.br";
    }

    private Funcionario(Builder builder) {
        super(builder.nome, builder.sobrenome, builder.dataNascimento, builder.cpf, builder.contato, builder.endereco);
        this.email = builder.email;
        this.senha = builder.senha;
        this.administrador = builder.administrador;
        this.ativo = true;
    }

    public static class Builder {
        private final LocalDate dataNascimento;
        private final String cpf;
        private final String email;
        private String nome;
        private String sobrenome;
        private Contato contato;
        private Endereco endereco;
        private String senha;
        private Boolean administrador = false;

        public Builder(LocalDate dataNascimento, String cpf, String email) {
            this.dataNascimento = dataNascimento;
            this.cpf = cpf;
            this.email = email;
        }

        public Builder comNomeSobrenome(String nome, String sobrenome) {
            this.nome = nome.toUpperCase();
            this.sobrenome = sobrenome.toUpperCase();
            return this;
        }

        public Builder comContato(Contato contato) {
            this.contato = contato;
            return this;
        }

        public Builder comEndereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public Builder comSenha(String senha) {
            this.senha = senha;
            return this;
        }

        public Builder administrador() {
            this.administrador = true;
            return this;
        }

        public Funcionario build() {
            return new Funcionario(this);
        }
    }

    public Aluguel alugarCarroPara(Carro carro, String cliente) {
        return new Aluguel(carro, cliente, this);
    }

    public void inativar() {
        if (!ativo) {
            throw new IllegalStateException("O funcionário já está inativo");
        }
        this.ativo = false;
    }

    public void reativar() {
        if (ativo) {
            throw new IllegalStateException("O funcionário já está ativo");
        }
        this.ativo = true;
    }

    public void autenticar(String senha) {
        if (!this.senha.equals(senha)) {
            throw new IllegalArgumentException("Senha incorreta!");
        }
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean isAdministrador() {
        return administrador;
    }

    public Boolean isAtivo() {
        return ativo;
    }

}
