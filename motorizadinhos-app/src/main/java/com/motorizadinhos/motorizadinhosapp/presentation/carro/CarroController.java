package com.motorizadinhos.motorizadinhosapp.presentation.carro;

import com.motorizadinhos.motorizadinhosapp.application.entity.carro.Carro;
import com.motorizadinhos.motorizadinhosapp.application.service.carro.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService service;

    @GetMapping
    public List<Carro> getAllCarro() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Carro getCarroById(@PathVariable("id") UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public Carro saveCarro(CarroMutationDTO creationDTO) {
        return service.save(creationDTO);
    }

    @PutMapping("/{id}")
    public Carro updateCarro(@PathVariable("id") UUID id, CarroMutationDTO updateDTO) {
        return service.update(id, updateDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCarro(@PathVariable("id") UUID id) {
        service.delete(id);
    }

}
