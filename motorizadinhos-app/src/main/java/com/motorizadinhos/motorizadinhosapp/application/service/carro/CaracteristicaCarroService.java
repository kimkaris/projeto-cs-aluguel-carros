package com.motorizadinhos.motorizadinhosapp.application.service.carro;

import com.motorizadinhos.motorizadinhosapp.application.entity.carro.CaracteristicaCarro;
import com.motorizadinhos.motorizadinhosapp.application.repository.carro.CaracteristicaCarroRepository;
import com.motorizadinhos.motorizadinhosapp.presentation.carro.CaracteristicaCarroMutationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class CaracteristicaCarroService {

    @Autowired
    private CaracteristicaCarroRepository repository;

    public List<CaracteristicaCarro> getAll() {
        return repository.findAll();
    }

    public List<CaracteristicaCarro> getAllByIds(List<UUID> ids) {
        return repository.findAllById(ids);
    }

    public CaracteristicaCarro save(CaracteristicaCarroMutationDTO creationDTO) {
        CaracteristicaCarro caracteristica = construirCaracteristica(creationDTO);
        return persist(caracteristica);
    }

    private CaracteristicaCarro construirCaracteristica(CaracteristicaCarroMutationDTO dto) {
        return new CaracteristicaCarro(dto.getCaracteristica(), dto.getDescricao());
    }

    public CaracteristicaCarro update(UUID id, CaracteristicaCarroMutationDTO update) {
        CaracteristicaCarro caracteristica = getById(id);
        caracteristica.setCaracteristica(update.getCaracteristica());
        caracteristica.setDescricao(update.getDescricao());
        return persist(caracteristica);
    }

    public CaracteristicaCarro getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Caracteristica de ID [" + id + "] não encontrado."));
    }

    private CaracteristicaCarro persist(CaracteristicaCarro caracteristica) {
        return repository.save(caracteristica);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
