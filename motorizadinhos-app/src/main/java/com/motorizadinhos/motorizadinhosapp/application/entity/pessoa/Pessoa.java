package com.motorizadinhos.motorizadinhosapp.application.entity.pessoa;

import com.motorizadinhos.motorizadinhosapp.application.entity.endereco.Endereco;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

@Entity
@Inheritance(strategy = TABLE_PER_CLASS)
public abstract class Pessoa {

    @Id
    @Column(name = "id", length = 36, unique = true, nullable = false)
    private final UUID id = UUID.randomUUID();
    @Column(name = "nome", length = 60, nullable = false)
    protected String nome;
    @Column(name = "sobrenome", length = 20, nullable = false)
    protected String sobrenome;
    @Column(name = "data_nascimento", nullable = false)
    protected LocalDate dataNascimento;
    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    protected String cpf;
    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    protected Contato contato;
    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    protected Endereco endereco;

    protected Pessoa() {}

    protected Pessoa(String nome, String sobrenome, LocalDate dataNascimento, String cpf, Contato contato, Endereco endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.cpf = new CPF(cpf).getCpf();
        this.contato = contato;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public Contato getContato() {
        return contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

}
