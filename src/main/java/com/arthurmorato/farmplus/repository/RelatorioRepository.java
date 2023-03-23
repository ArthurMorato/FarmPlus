package com.arthurmorato.farmplus.repository;

import com.arthurmorato.gadoplus.entity.RelatorioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

public interface RelatorioRepository extends JpaRepository<RelatorioEntity, Long> {

    // Consulta relatórios pelo tipo
    List<RelatorioEntity> findByTipo(String tipo);

    // Consulta relatórios gerados em um período específico
    List<RelatorioEntity> findByDataGeracaoBetween(LocalDate dataInicio, LocalDate dataFim);

    // Consulta relatórios pelo conteúdo
    List<RelatorioEntity> findByConteudoContaining(String conteudo);

    // Consulta o último relatório gerado
    Optional<RelatorioEntity> findTopByOrderByDataGeracaoDesc();

}
