package com.motorizadinhos.motorizadinhosapp.application.repository.aluguel;

import com.motorizadinhos.motorizadinhosapp.application.entity.aluguel.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AluguelRepository extends JpaRepository<Aluguel, UUID> {}