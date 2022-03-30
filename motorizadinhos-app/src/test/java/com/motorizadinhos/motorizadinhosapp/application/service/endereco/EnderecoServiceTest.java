package com.motorizadinhos.motorizadinhosapp.application.service.endereco;

import com.motorizadinhos.motorizadinhosapp.application.entity.endereco.Endereco;
import com.motorizadinhos.motorizadinhosapp.application.entity.endereco.Estado;
import com.motorizadinhos.motorizadinhosapp.application.repository.endereco.EnderecoRepository;
import com.motorizadinhos.motorizadinhosapp.presentation.endereco.EnderecoMutationDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class EnderecoServiceTest {

    @Mock
    private Endereco endereco;
    private final UUID enderecoId = UUID.fromString("ab34d914-3050-4ace-88d3-e1673fbc8089");
    private final EnderecoMutationDTO mutationDTO = new EnderecoMutationDTO(Estado.PR, "Maringá", "Zona 7", "Avenida Colombo", "5790");

    @Mock
    private EnderecoRepository repository;
    @InjectMocks
    private EnderecoService service;

    @Test
    void deveBuscarTodosOsEnderecosDoRepository() {
        List<Endereco> enderecos = List.of(endereco);
        when(repository.findAll()).thenReturn(enderecos);

        List<Endereco> resposta = service.getAll();
        assertEquals(1, resposta.size());
        assertEquals(endereco, resposta.get(0));
        verify(repository).findAll();
    }

    @Test
    void deveSalvarEnderecoViaRepository() {
        when(repository.save(any())).thenReturn(endereco);

        Endereco resposta = service.save(mutationDTO);
        assertEquals(endereco, resposta);
        verify(repository).save(any());
    }

    @Test
    void deveAtualizarEnderecoViaRepository() {
        when(repository.findById(enderecoId)).thenReturn(Optional.of(endereco));
        when(repository.save(any())).thenReturn(endereco);

        Endereco resposta = service.update(enderecoId, mutationDTO);
        assertEquals(endereco, resposta);
        verify(repository).save(any());
    }

    @Test
    void deveBuscarUmEnderecoDoRepositoryPorId() {
        when(repository.findById(enderecoId)).thenReturn(Optional.of(endereco));

        Endereco resposta = service.getById(enderecoId);
        assertEquals(endereco, resposta);
        verify(repository).findById(any());
    }

    @Test
    void deveBuscarUmEnderecoDoRepositoryPorId_eLancarExcecaoQuandoNaoEncontrado() {
        when(repository.findById(enderecoId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> service.getById(enderecoId));
        verify(repository).findById(any());
    }

}