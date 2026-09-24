package com.groupeisi.HelloSpring.controllers;

import com.groupeisi.HelloSpring.entities.Entreprise;
import com.groupeisi.HelloSpring.entities.Stage;
import com.groupeisi.HelloSpring.services.StageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/stages")
@Tag(
        name = "Gestion des stages",
        description = "La ressource permettant de faire le gestion complete des  stages")
public class StageController {

    private final StageService stageService;

    @Operation(
            summary = "Liste des stages",
            description = "Retourne la liste de tous les stages"
    )
    @GetMapping
    private List<Stage> getAllStages() {
        return stageService.findAll();
    }

    @Operation(
            summary = "Affiche un stage",
            description = "Retourne un stage en fonction de son identifiant"
    )
    @Parameter(
            name = "identifiant",
            example = "1",
            required = true,
            description = "L'identifiant est un parametre obligatoire"
    )
    @GetMapping("{identifiant}")
    public Stage getStagebyid(@PathVariable Long identifiant) {
        log.info("Getting stage with id: {}", identifiant);
        Optional<Stage> stage = stageService.findById(identifiant);
        if(stage.isPresent()){
            return stage.get();
        }else {
            return  null;
        }
    }

    @Operation(
            summary = "Ajouter un stage",
            description = "Ajoute un stage dans la base de donnees"
    )
    @PostMapping
    public Stage createStage(@RequestBody Stage stageCreate){
        log.info("Saving entreprise : {}", stageCreate);
        Stage stageReturn = stageService.createStage(stageCreate);
        return stageReturn;

    }

    @Operation(
            summary = "Suppression d'un stage",
            description = "Supprime un stage en fonction de son identifiant"
    )
    @Parameter(
            name = "identifiant",
            required = true,
            example = "1",
            description = "L'identifiant est un parametre obligatoire"
    )
    @DeleteMapping("{identifiant}")
    public void deleteStage(@PathVariable Long identifiant){
        stageService.deleteStage(identifiant);
    }


    @Operation(
            summary = "Modification d'un stage",
            description = "Met à jour un stage en fonction de son identifiant"
    )
    @Parameter(
            name = "identifiant",
            required = true,
            example = "1",
            description = "L'identifiant est un parametre obligatoire"
    )
    @PutMapping("/{identifiant}")
    public Stage update(
            @PathVariable String identifiant,
            @RequestBody Stage stage) {
        log.info("Updating stage : {}", stage.getId());
        Stage result=stageService.update(stage);
        log.info("stage cree avec succes");
        return result;
    }




}
