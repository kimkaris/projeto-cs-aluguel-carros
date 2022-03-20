package com.motorizadinhos.motorizadinhosapp.application.funcionario;

import com.motorizadinhos.motorizadinhosapp.application.endereco.Endereco;
import com.motorizadinhos.motorizadinhosapp.application.pessoa.Contato;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    @Mock
    private Contato contato;

    @Mock
    private Endereco endereco;

    private final LocalDate fundacaoUem = LocalDate.of(1969, 11, 6);
    private final Funcionario funcionario = new Funcionario.Builder(fundacaoUem, "304.329.050-06", "uem.maringa@motorizadinhos.br")
            .comNomeSobrenome("Uem", "Maringá")
            .comContato(contato)
            .comEndereco(endereco)
            .build();

    @Test
    public void deveCriarNomeESobrenomeComLetraMaiuscula() {
        assertEquals(funcionario.getNome(), "UEM");
        assertEquals(funcionario.getSobrenome(), "MARINGÁ");
    }

    @Test
    public void deveCriarCpfSomenteComOsNumeros() {
        assertEquals(funcionario.getCpf(), "30432905006");
    }

    @Test
    public void deveCriarFuncionarioComOsDadosCorretos() {
        assertNull(funcionario.getSenha());
        assertEquals(funcionario.getContato(), contato);
        assertEquals(funcionario.getEndereco(), endereco);
        assertTrue(funcionario.isAtivo());
        assertFalse(funcionario.isAdministrador());
    }

    @Test
    public void deveInativarEReativarFuncionario() {
        assertTrue(funcionario.isAtivo());
        funcionario.inativar();
        assertFalse(funcionario.isAtivo());
        funcionario.reativar();
        assertTrue(funcionario.isAtivo());
    }

    @Test
    public void deveLancarExcecaoAoReativarFuncionarioAtivo() {
        assertTrue(funcionario.isAtivo());
        assertThrows(IllegalStateException.class, funcionario::reativar);
    }

    @Test
    public void deveLancarExcecaoAoInativarFuncionarioInativo() {
        funcionario.inativar();
        assertFalse(funcionario.isAtivo());
        assertThrows(IllegalStateException.class, funcionario::inativar);
    }

}