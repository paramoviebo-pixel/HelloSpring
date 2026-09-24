package com.groupeisi.HelloSpring.services;

import com.groupeisi.HelloSpring.entities.Stage;
import com.groupeisi.HelloSpring.repositories.StageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StageService {

    private final StageRepository stageRepository;

    public List<Stage> findAll() {
        return stageRepository.findAll();
    }

    public Optional<Stage> findById(Long identifiant)
    {
        return  stageRepository.findById(identifiant);
    }

    // lA FONCTION QUI NOUS PERMETTRA DE CREER UN STAGE DANS LA BASE DE DONNEES
    public Stage createStage(Stage stage){
        return stageRepository.save(stage);
    }

    // lA FONCTION QUI NOUS PERMETTRA DE SUPPRIMER  UN STAGE DANS LA BASE DE DONNEES
    public void deleteStage(Long identifiant){
        stageRepository.deleteById(identifiant);
    }

    public Stage update(Stage stage) {
        stage=stageRepository.save(stage);
        return stage;
    }


}
