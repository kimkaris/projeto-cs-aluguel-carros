package com.motorizadinhos.motorizadinhosapp.presentation.carro;

import com.motorizadinhos.motorizadinhosapp.application.entity.carro.CaracteristicaCarro;
import com.motorizadinhos.motorizadinhosapp.application.service.carro.CaracteristicaCarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/carros/caracteristicas")
public class CaracteristicaCarroController {

    @Autowired
    private CaracteristicaCarroService service;

    @GetMapping
    public List<CaracteristicaCarro> getAllCaracteristica() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CaracteristicaCarro getCaracteristicaById(@PathVariable("id") UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public CaracteristicaCarro saveCaracteristica(CaracteristicaCarroMutationDTO creationDTO) {
        return service.save(creationDTO);
    }

    @PutMapping("/{id}")
    public CaracteristicaCarro updateCaracteristica(@PathVariable("id") UUID id, CaracteristicaCarroMutationDTO updateDTO) {
        return service.update(id, updateDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCaracteristica(@PathVariable("id") UUID id) {
        service.delete(id);
    }

}
