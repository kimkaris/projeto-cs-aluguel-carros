package com.motorizadinhos.motorizadinhosapp.presentation.funcionario;

public class ContatoMutationDTO {

    private String email;
    private String telefoneFixo;
    private String telefoneCelular;

    private ContatoMutationDTO() {}

    public String getEmail() {
        return email;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

}
