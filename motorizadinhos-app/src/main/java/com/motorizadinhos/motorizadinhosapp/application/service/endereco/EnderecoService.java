package com.motorizadinhos.motorizadinhosapp.application.service.endereco;

import com.motorizadinhos.motorizadinhosapp.application.entity.endereco.Endereco;
import com.motorizadinhos.motorizadinhosapp.application.repository.endereco.EnderecoRepository;
import com.motorizadinhos.motorizadinhosapp.presentation.endereco.EnderecoMutationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public List<Endereco> getAll() {
        return repository.findAll();
    }

    public Endereco save(EnderecoMutationDTO creationDTO) {
        Endereco endereco = construirEndereco(creationDTO);
        return persist(endereco);
    }

    private Endereco construirEndereco(EnderecoMutationDTO dto) {
        return new Endereco.Builder(dto.getEstado(), dto.getCidade())
                .noBairro(dto.getBairro())
                .noLogradouro(dto.getLogradouro())
                .noNumero(dto.getNumero())
                .build();
    }

    public Endereco update(UUID id, EnderecoMutationDTO update) {
        Endereco endereco = getById(id);
        endereco.setEstado(update.getEstado());
        endereco.setCidade(update.getCidade());
        endereco.setBairro(update.getBairro());
        endereco.setLogradouro(update.getLogradouro());
        endereco.setNumero(update.getNumero());
        return persist(endereco);
    }

    public Endereco getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Endereco de ID [" + id + "] não encontrado."));
    }

    private Endereco persist(Endereco endereco) {
        return repository.save(endereco);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
