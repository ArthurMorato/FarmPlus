package com.arthurmorato.farmplus.repository;

import java.util.List;

import com.arthurmorato.gadoplus.entity.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {

    // Busca todos os animais cadastrados no sistema
    List<AnimalEntity> findAll();

    // Busca um animal pelo id
    AnimalEntity findById(long id);

    // Busca animais por raça
    List<AnimalEntity> findByRaca(String raca);

    // Busca animais por idade maior ou igual a uma determinada idade
    List<AnimalEntity> findByIdadeGreaterThanEqual(int idade);

    // Busca animais por idade menor ou igual a uma determinada idade
    List<AnimalEntity> findByIdadeLessThanEqual(int idade);

    // Busca animais por idade entre uma idade mínima e máxima
    List<AnimalEntity> findByIdadeBetween(int idadeMin, int idadeMax);

    // Busca animais por peso maior ou igual a um determinado peso
    List<AnimalEntity> findByPesoGreaterThanEqual(double peso);

    // Busca animais por peso menor ou igual a um determinado peso
    List<AnimalEntity> findByPesoLessThanEqual(double peso);

    // Busca animais por peso entre um peso mínimo e máximo
    List<AnimalEntity> findByPesoBetween(double pesoMin, double pesoMax);

    // Busca animais por histórico de vacinação
    List<AnimalEntity> findByHistoricoDeVacinação(boolean vacinado);

    // Salva um animal no banco de dados
    AnimalEntity save(AnimalEntity animal);

    // Exclui um animal do banco de dados
    void delete(AnimalEntity animal);
}

