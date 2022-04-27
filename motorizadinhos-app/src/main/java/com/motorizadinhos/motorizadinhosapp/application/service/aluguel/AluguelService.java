package com.motorizadinhos.motorizadinhosapp.application.service.aluguel;

import com.motorizadinhos.motorizadinhosapp.application.entity.aluguel.Aluguel;
import com.motorizadinhos.motorizadinhosapp.application.entity.carro.Carro;
import com.motorizadinhos.motorizadinhosapp.application.entity.funcionario.Funcionario;
import com.motorizadinhos.motorizadinhosapp.application.repository.aluguel.AluguelRepository;
import com.motorizadinhos.motorizadinhosapp.application.service.carro.CarroService;
import com.motorizadinhos.motorizadinhosapp.application.service.funcionario.FuncionarioService;
import com.motorizadinhos.motorizadinhosapp.presentation.aluguel.AluguelMutationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository repository;

    @Autowired
    private CarroService carroService;
    
    @Autowired
    private FuncionarioService funcionarioService;
    
    public List<Aluguel> getAll() {
        return repository.findAll();
    }

    public Aluguel save(AluguelMutationDTO creationDTO) {
        Carro carro = carroService.getById(creationDTO.getCarro());
        String cliente = creationDTO.getCliente();
        Funcionario responsavel = funcionarioService.getById(creationDTO.getResponsavel());
        Aluguel aluguel = construirAluguel(carro, cliente, responsavel);
        return persist(aluguel);
    }

    private Aluguel construirAluguel(Carro carro, String cliente, Funcionario responsavel) {
        return new Aluguel(carro, cliente, responsavel);
    }

    public Aluguel encerrarAluguel(UUID id) {
        Aluguel aluguel = getById(id);
        aluguel.encerrarAluguel();
        return persist(aluguel);
    }

    public Aluguel getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluguel de ID [" + id + "] não encontrado."));
    }

    private Aluguel persist(Aluguel aluguel) {
        return repository.save(aluguel);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
    
}
