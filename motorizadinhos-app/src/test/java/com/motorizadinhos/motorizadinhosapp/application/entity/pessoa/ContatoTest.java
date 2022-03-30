package com.motorizadinhos.motorizadinhosapp.application.entity.pessoa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContatoTest {

    @Test
    public void deveCriarTodosOsAtributosComoForamPassados() {
        Contato contato = new Contato.Builder("uem.maringa@motorizadinhos.br")
                .comTelefoneFixo("(44) 3745-8522")
                .comTelefoneCelular("(44) 9 3012-7216")
                .build();

        assertEquals(contato.getEmail(), "uem.maringa@motorizadinhos.br");
        assertEquals(contato.getTelefoneFixo(), "4437458522");
        assertEquals(contato.getTelefoneCelular(), "44930127216");
    }

}