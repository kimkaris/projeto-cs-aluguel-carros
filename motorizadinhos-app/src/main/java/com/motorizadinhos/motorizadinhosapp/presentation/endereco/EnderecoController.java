package com.motorizadinhos.motorizadinhosapp.presentation.endereco;

import com.motorizadinhos.motorizadinhosapp.application.entity.endereco.Endereco;
import com.motorizadinhos.motorizadinhosapp.application.service.endereco.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping
    public List<Endereco> getAllEndereco() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Endereco getEnderecoById(@PathVariable("id") UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public Endereco saveEndereco(EnderecoMutationDTO creationDTO) {
        return service.save(creationDTO);
    }

    @PutMapping("/{id}")
    public Endereco updateEndereco(@PathVariable("id") UUID id, EnderecoMutationDTO updateDTO) {
        return service.update(id, updateDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEndereco(@PathVariable("id") UUID id) {
        service.delete(id);
    }

}
