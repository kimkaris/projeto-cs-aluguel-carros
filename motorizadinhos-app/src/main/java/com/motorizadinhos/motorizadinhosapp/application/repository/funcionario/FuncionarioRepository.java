package com.motorizadinhos.motorizadinhosapp.application.repository.funcionario;

import com.motorizadinhos.motorizadinhosapp.application.entity.funcionario.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {}
