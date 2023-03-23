package com.arthurmorato.farmplus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CadastroAnimaisService {

    @Autowired
    private AnimalRepository animalRepository;

    public void cadastrarAnimal(AnimalEntity animal) {
        // Realizar validações nos dados do animal antes de persisti-lo no banco de dados
        animalRepository.save(animal);
    }

    public void atualizarAnimal(AnimalEntity animal) {
        // Realizar validações nos dados do animal antes de atualizá-lo no banco de dados
        animalRepository.save(animal);
    }

    public void registrarVacina(VacinaEntity vacina) {
        // Realizar validações nos dados da vacina antes de persisti-la no banco de dados
        AnimalEntity animal = vacina.getAnimal();
        animal.getHistoricoVacinas().add(vacina);
        animalRepository.save(animal);
    }

    public AnimalEntity buscarAnimalPorId(Long id) {
        return animalRepository.findById(id).orElse(null);
    }
}

