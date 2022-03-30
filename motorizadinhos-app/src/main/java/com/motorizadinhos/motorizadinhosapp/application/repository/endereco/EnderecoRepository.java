package com.motorizadinhos.motorizadinhosapp.application.repository.endereco;

import com.motorizadinhos.motorizadinhosapp.application.entity.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {}