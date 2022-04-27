package com.motorizadinhos.motorizadinhosapp.application.service.carro;

import com.motorizadinhos.motorizadinhosapp.application.entity.carro.CaracteristicaCarro;
import com.motorizadinhos.motorizadinhosapp.application.entity.carro.Carro;
import com.motorizadinhos.motorizadinhosapp.application.repository.carro.CarroRepository;
import com.motorizadinhos.motorizadinhosapp.presentation.carro.CarroMutationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    @Autowired
    private CaracteristicaCarroService caracteristicasService;

    public List<Carro> getAll() {
        return repository.findAll();
    }

    public Carro save(CarroMutationDTO creationDTO) {
        List<CaracteristicaCarro> caracteristicas = getCaracteristicasByIds(creationDTO.getCaracteristicas());
        Carro carro = construirCarro(creationDTO, caracteristicas);
        return persist(carro);
    }

    private Carro construirCarro(CarroMutationDTO dto, List<CaracteristicaCarro> caracteristicas) {
        return new Carro.Builder(dto.getModelo(), dto.getMarca(), dto.getAno())
                .comQuilometragem(dto.getQuilometragem())
                .comAsCaracteristicas(caracteristicas)
                .build();
    }

    public Carro update(UUID id, CarroMutationDTO update) {
        List<CaracteristicaCarro> caracteristicas = getCaracteristicasByIds(update.getCaracteristicas());
        Carro carro = getById(id);
        carro.setQuilometragem(update.getQuilometragem());
        carro.setCaracteristicas(caracteristicas);
        return persist(carro);
    }

    private List<CaracteristicaCarro> getCaracteristicasByIds(List<UUID> ids) {
        return caracteristicasService.getAllByIds(ids);
    }

    public Carro getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carro de ID [" + id + "] não encontrado."));
    }

    private Carro persist(Carro carro) {
        return repository.save(carro);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
    
}
