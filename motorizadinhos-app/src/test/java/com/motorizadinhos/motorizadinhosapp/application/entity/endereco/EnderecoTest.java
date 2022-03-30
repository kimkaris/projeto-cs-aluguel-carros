package com.motorizadinhos.motorizadinhosapp.application.entity.endereco;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnderecoTest {

    @Test
    public void deveCriarTodosOsAtributosComLetraMaiuscula() {
        Endereco endereco = new Endereco.Builder(Estado.PR, "Maringá")
                .noBairro("Zona 7")
                .noLogradouro("Avenida Colombo")
                .noNumero("5790")
                .build();

        assertEquals(endereco.getEstado(), Estado.PR);
        assertEquals(endereco.getCidade(), "MARINGÁ");
        assertEquals(endereco.getBairro(), "ZONA 7");
        assertEquals(endereco.getLogradouro(), "AVENIDA COLOMBO");
        assertEquals(endereco.getNumero(), "5790");
    }

}