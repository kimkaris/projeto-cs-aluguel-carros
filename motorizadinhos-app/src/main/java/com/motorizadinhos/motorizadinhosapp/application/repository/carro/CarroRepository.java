package com.motorizadinhos.motorizadinhosapp.application.repository.carro;

import com.motorizadinhos.motorizadinhosapp.application.entity.carro.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarroRepository extends JpaRepository<Carro, UUID> {}