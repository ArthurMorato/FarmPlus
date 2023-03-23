package com.arthurmorato.farmplus.repository;

import com.arthurmorato.gadoplus.entity.ConfiguracaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfiguracaoRepository extends JpaRepository<ConfiguracaoEntity, Long> {

    ConfiguracaoEntity findByTipo(String tipo);

    List<ConfiguracaoEntity> findByValor(String valor);

    List<ConfiguracaoEntity> findByTipoAndValor(String tipo, String valor);

    List<ConfiguracaoEntity> findByTipoOrderByValorAsc(String tipo);

    List<ConfiguracaoEntity> findByTipoOrderByValorDesc(String tipo);

}
