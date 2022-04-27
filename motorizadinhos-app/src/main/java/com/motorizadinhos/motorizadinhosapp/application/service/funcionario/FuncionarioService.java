package com.motorizadinhos.motorizadinhosapp.application.service.funcionario;

import com.motorizadinhos.motorizadinhosapp.application.entity.funcionario.Funcionario;
import com.motorizadinhos.motorizadinhosapp.application.entity.pessoa.Contato;
import com.motorizadinhos.motorizadinhosapp.application.repository.funcionario.FuncionarioRepository;
import com.motorizadinhos.motorizadinhosapp.application.service.endereco.EnderecoService;
import com.motorizadinhos.motorizadinhosapp.presentation.funcionario.ContatoMutationDTO;
import com.motorizadinhos.motorizadinhosapp.presentation.funcionario.FuncionarioMutationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    private EnderecoService enderecoService;

    public List<Funcionario> getAll() {
        return repository.findAll();
    }

    public Funcionario save(FuncionarioMutationDTO creationDTO) {
        Funcionario funcionario = construirFuncinoario(creationDTO);
        return persist(funcionario);
    }

    private Funcionario construirFuncinoario(FuncionarioMutationDTO dto) {
        return new Funcionario.Builder(dto.getDataNascimento(), dto.getCpf(), dto.getEmail())
                .comNomeSobrenome(dto.getNome(), dto.getSobrenome())
                .comSenha(dto.getSenhaAtual())
                .comContato(construirContato(dto.getContato()))
                .comEndereco(enderecoService.getById(dto.getEnderecoId()))
                .build();
    }

    private Contato construirContato(ContatoMutationDTO creationDTO) {
        return Objects.isNull(creationDTO) ? null : new Contato.Builder(creationDTO.getEmail())
                .comTelefoneFixo(creationDTO.getTelefoneFixo())
                .comTelefoneCelular(creationDTO.getTelefoneCelular())
                .build();
    }

    public Funcionario update(UUID id, FuncionarioMutationDTO update) {
        Funcionario funcionario = getById(id);
        funcionario.autenticar(update.getSenhaAtual());
        funcionario.setNome(update.getNome());
        funcionario.setSobrenome(update.getSobrenome());
        if (Objects.nonNull(update.getSenhaNova()) && !update.getSenhaNova().isBlank()) {
            updatePassword(funcionario, update);
        }
        return persist(funcionario);
    }

    private void updatePassword(Funcionario funcionario, FuncionarioMutationDTO update) {
        if (!update.getSenhaNova().isBlank()) {
            funcionario.setSenha(update.getSenhaNova());
        }
    }

    public Funcionario getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funcionario de ID [" + id + "] não encontrado."));
    }

    private Funcionario persist(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
