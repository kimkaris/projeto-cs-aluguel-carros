package com.motorizadinhos.motorizadinhosapp.application.entity.aluguel;

import com.motorizadinhos.motorizadinhosapp.application.entity.carro.Carro;
import com.motorizadinhos.motorizadinhosapp.application.entity.funcionario.Funcionario;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "aluguel")
public class Aluguel {

    @Id
    @Column(name = "id", length = 36, unique = true, nullable = false)
    private final UUID id = UUID.randomUUID();
    @ManyToOne
    @JoinColumn(name = "id_carro", referencedColumnName = "id")
    private Carro carro;
    @Column(name = "cliente", length = 80, nullable = false)
    private String cliente;
    @ManyToOne
    @JoinColumn(name = "id_responsavel", referencedColumnName = "id")
    private Funcionario responsavel;
    @Column(name = "inicio_aluguel", nullable = false)
    private final LocalDateTime inicioAluguel = LocalDateTime.now();
    @Column(name = "encerramento_aluguel", nullable = false)
    private LocalDateTime encerramentoAluguel;
    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    protected Aluguel() {}

    public Aluguel(Carro carro, String cliente, Funcionario responsavel) {
        this.carro = carro;
        this.cliente = cliente;
        this.responsavel = responsavel;
    }

    public void encerrarAluguel() {
        this.encerramentoAluguel = LocalDateTime.now();
        this.ativo = false;
    }

    public Carro getCarro() {
        return carro;
    }

    public String getCliente() {
        return cliente;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public LocalDateTime getInicioAluguel() {
        return inicioAluguel;
    }

    public LocalDateTime getEncerramentoAluguel() {
        return encerramentoAluguel;
    }

    public Boolean isAtivo() {
        return ativo;
    }

}
