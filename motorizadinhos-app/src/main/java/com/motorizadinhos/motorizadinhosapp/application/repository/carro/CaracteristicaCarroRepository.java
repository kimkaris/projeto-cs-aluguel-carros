package com.motorizadinhos.motorizadinhosapp.application.repository.carro;

import com.motorizadinhos.motorizadinhosapp.application.entity.carro.CaracteristicaCarro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CaracteristicaCarroRepository extends JpaRepository<CaracteristicaCarro, UUID> {}