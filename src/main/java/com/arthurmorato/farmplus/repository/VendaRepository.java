package com.arthurmorato.farmplus.repository;

import com.arthurmorato.gadoplus.entity.VendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<VendaEntity, Long> {

    // Busca as vendas realizadas em um período específico
    List<VendaEntity> findByDataVendaBetween(LocalDate dataInicio, LocalDate dataFim);

    // Busca todas as vendas de um animal específico
    List<VendaEntity> findByAnimalVendidoId(Long idAnimal);

    // Busca o valor total das vendas realizadas em um período específico
    Double sumValorByDataVendaBetween(LocalDate dataInicio, LocalDate dataFim);

    // Busca o valor médio das vendas realizadas em um período específico
    Double avgValorByDataVendaBetween(LocalDate dataInicio, LocalDate dataFim);

    // Busca a quantidade total de vendas realizadas em um período específico
    Long countByDataVendaBetween(LocalDate dataInicio, LocalDate dataFim);

}
