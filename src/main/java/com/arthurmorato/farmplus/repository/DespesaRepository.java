package com.arthurmorato.farmplus.repository;

import java.time.LocalDate;
import java.util.List;

import com.arthurmorato.gadoplus.entity.DespesaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DespesaRepository extends JpaRepository<DespesaEntity, Long> {

    // busca todas as despesas cadastradas
    List<DespesaEntity> findAll();

    // busca todas as despesas de um determinado tipo
    List<DespesaEntity> findByTipo(String tipo);

    // busca todas as despesas realizadas em um determinado período
    List<DespesaEntity> findByDataBetween(LocalDate inicio, LocalDate fim);

    // busca o total gasto em despesas de um determinado tipo em um período
    Double sumByTipoAndDataBetween(String tipo, LocalDate inicio, LocalDate fim);

    // busca a despesa com o valor mais alto de um determinado tipo em um período
    DespesaEntity findTopByTipoAndDataBetweenOrderByValorDesc(String tipo, LocalDate inicio, LocalDate fim);

}
