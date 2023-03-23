package com.arthurmorato.farmplus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class RegistroDespesasService {

    @Autowired
    private DespesaRepository despesaRepository;

    public void cadastrarDespesa(DespesaEntity despesa) {
        despesaRepository.save(despesa);
    }

    public List<DespesaEntity> listarDespesasPorPeriodo(LocalDate inicio, LocalDate fim) {
        return despesaRepository.findByDataDespesaBetween(inicio, fim);
    }

    public Double calcularCustoMedioProducaoPorAnimal() {
        // Implementação do cálculo de custo médio de produção por animal
        return 0.0;
    }
}

