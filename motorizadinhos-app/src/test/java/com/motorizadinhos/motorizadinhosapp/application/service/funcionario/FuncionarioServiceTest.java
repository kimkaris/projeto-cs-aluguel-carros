package com.motorizadinhos.motorizadinhosapp.application.service.funcionario;

import com.motorizadinhos.motorizadinhosapp.application.entity.endereco.Endereco;
import com.motorizadinhos.motorizadinhosapp.application.entity.funcionario.Funcionario;
import com.motorizadinhos.motorizadinhosapp.application.repository.funcionario.FuncionarioRepository;
import com.motorizadinhos.motorizadinhosapp.application.service.endereco.EnderecoService;
import com.motorizadinhos.motorizadinhosapp.presentation.funcionario.FuncionarioMutationDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class FuncionarioServiceTest {

    @Mock
    private Funcionario funcionario;
    @Mock
    private Endereco endereco;
    private final UUID funcionarioId = UUID.fromString("ab34d914-3050-4ace-88d3-e1673fbc8089");
    private final UUID enderecoId = UUID.fromString("bbce0419-9d32-4912-a228-41425dd922bd");
    private final LocalDate fundacaoUem = LocalDate.of(1969, 11, 6);
    private final FuncionarioMutationDTO mutationDTO = new FuncionarioMutationDTO("Uem", "Maringá", fundacaoUem, "304.329.050-06",
            "uem.maringa@motorizadinhos.br", "123", null, enderecoId, null);

    @Mock
    private FuncionarioRepository repository;
    @Mock
    private EnderecoService enderecoService;
    @InjectMocks
    private FuncionarioService service;

    @Test
    void deveBuscarTodosOsFuncionariosDoRepository() {
        List<Funcionario> funcionarios = List.of(funcionario);
        when(repository.findAll()).thenReturn(funcionarios);

        List<Funcionario> resposta = service.getAll();
        assertEquals(1, resposta.size());
        assertEquals(funcionario, resposta.get(0));
        verify(repository).findAll();
    }

    @Test
    void deveSalvarFuncionarioViaRepository() {
        when(repository.save(any())).thenReturn(funcionario);

        Funcionario resposta = service.save(mutationDTO);
        assertEquals(funcionario, resposta);
        verify(enderecoService).getById(any());
        verify(repository).save(any());
    }

    @Test
    void deveSalvarFuncionarioViaRepository_quandoEnderecoForEncontrado() {
        when(enderecoService.getById(eq(enderecoId))).thenReturn(endereco);
        when(repository.save(any())).thenReturn(funcionario);

        Funcionario resposta = service.save(mutationDTO);
        assertEquals(funcionario, resposta);
        verify(enderecoService).getById(eq(enderecoId));
        verify(repository).save(any());
    }

    @Test
    void deveAtualizarFuncionarioViaRepository() {
        when(repository.findById(funcionarioId)).thenReturn(Optional.of(funcionario));
        when(repository.save(any())).thenReturn(funcionario);

        Funcionario resposta = service.update(funcionarioId, mutationDTO);
        assertEquals(funcionario, resposta);
        verify(repository).save(any());
    }

    @Test
    void deveBuscarUmFuncionarioDoRepositoryPorId() {
        when(repository.findById(funcionarioId)).thenReturn(Optional.of(funcionario));

        Funcionario resposta = service.getById(funcionarioId);
        assertEquals(funcionario, resposta);
        verify(repository).findById(any());
    }

    @Test
    void deveBuscarUmFuncionarioDoRepositoryPorId_eLancarExcecaoQuandoNaoEncontrado() {
        when(repository.findById(funcionarioId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> service.getById(funcionarioId));
        verify(repository).findById(any());
    }
    
}