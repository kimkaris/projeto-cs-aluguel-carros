package com.motorizadinhos.motorizadinhosapp.presentation.aluguel;

import com.motorizadinhos.motorizadinhosapp.application.entity.aluguel.Aluguel;
import com.motorizadinhos.motorizadinhosapp.application.service.aluguel.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    @Autowired
    private AluguelService service;

    @GetMapping
    public List<Aluguel> getAllAluguel() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Aluguel getAluguelById(@PathVariable("id") UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public Aluguel saveAluguel(AluguelMutationDTO creationDTO) {
        return service.save(creationDTO);
    }

    @PutMapping("/{id}/encerrar")
    public Aluguel encerrarAluguel(@PathVariable("id") UUID id) {
        return service.encerrarAluguel(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAluguel(@PathVariable("id") UUID id) {
        service.delete(id);
    }

}
