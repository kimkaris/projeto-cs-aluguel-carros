package com.motorizadinhos.motorizadinhosapp.presentation.funcionario;

import com.motorizadinhos.motorizadinhosapp.application.entity.funcionario.Funcionario;
import com.motorizadinhos.motorizadinhosapp.application.service.funcionario.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public List<Funcionario> getAllFuncionario() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Funcionario getFuncionarioById(@PathVariable("id") UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public Funcionario saveFuncionario(FuncionarioMutationDTO creationDTO) {
        return service.save(creationDTO);
    }

    @PutMapping("/{id}")
    public Funcionario updateFuncionario(@PathVariable("id") UUID id, FuncionarioMutationDTO updateDTO) {
        return service.update(id, updateDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteFuncionario(@PathVariable("id") UUID id) {
        service.delete(id);
    }

}
