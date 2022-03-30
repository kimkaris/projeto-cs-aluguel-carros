package com.motorizadinhos.motorizadinhosapp.presentation.funcionario;

import java.time.LocalDate;
import java.util.UUID;

public class FuncionarioMutationDTO {

    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String cpf;
    private String email;
    private String senhaAtual;
    private String senhaNova;
    private UUID enderecoId;
    private ContatoMutationDTO contato;

    public FuncionarioMutationDTO(String nome, String sobrenome, LocalDate dataNascimento, String cpf, String email, String senhaAtual,
                                  String senhaNova, UUID enderecoId, ContatoMutationDTO contato) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.email = email;
        this.senhaAtual = senhaAtual;
        this.senhaNova = senhaNova;
        this.enderecoId = enderecoId;
        this.contato = contato;
    }

    protected FuncionarioMutationDTO() {}

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getSenhaAtual() {
        return senhaAtual;
    }

    public String getSenhaNova() {
        return senhaNova;
    }

    public UUID getEnderecoId() {
        return enderecoId;
    }

    public ContatoMutationDTO getContato() {
        return contato;
    }

}
