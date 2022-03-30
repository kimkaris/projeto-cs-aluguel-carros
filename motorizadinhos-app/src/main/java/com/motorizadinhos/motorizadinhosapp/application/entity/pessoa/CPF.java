package com.motorizadinhos.motorizadinhosapp.application.entity.pessoa;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class CPF {

    private final String cpf;

    public CPF(String cpf) {
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");
        validarCpf(cpfLimpo);
        this.cpf = cpfLimpo;
    }

    private void validarCpf(String cpf) {
        try {
            new CPFValidator().assertValid(cpf);
        } catch (InvalidStateException ex) {
            throw new IllegalArgumentException("CPF " + cpf + " é inválido.");
        }
    }

    public String getCpf() {
        return cpf;
    }

}
