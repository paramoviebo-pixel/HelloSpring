package com.groupeisi.HelloSpring.controllers;


import com.groupeisi.HelloSpring.entities.Entreprise;
import com.groupeisi.HelloSpring.services.EntrepriseService;
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
@RequestMapping("/entreprises")
@Tag(
        name = "Gestion des entreprises",
        description = "La ressource permettant de faire le gestion complete des entreprises ")
public class EntrepriseController {

    private final EntrepriseService  entrepriseService;
    @Operation(
            summary = "Liste des entreprises",
            description = "Retourne la liste de toutes les entreprises"
    )
    @GetMapping
    private List<Entreprise> getAllEtudiants() {

        return entrepriseService.findAll();
    }

    @Operation(
            summary = "Affiche une entreprise",
            description = "Retourne une entreprise en fonction de son identifiant"
    )
    @Parameter(
            name = "raisonSociale",
            example = "Sonatel",
            required = true,
            description = "La raison sociale est un parametre obligatoire"
    )
    @GetMapping("{raisonSociale}")
    public Entreprise getEntreprisebyid(@PathVariable String raisonSociale) {
        log.info("Getting entreprise with raison sociale: {}", raisonSociale);
        Optional<Entreprise> entreprise = entrepriseService.findById(raisonSociale);
        if(entreprise.isPresent()){
            return entreprise.get();
        }else {
            return null;
        }
    }

    @Operation(
            summary = "Ajout d'une entreprise",
            description = "Ajoute une entreprise dans la base de donnees."
    )
    @PostMapping
    public Entreprise createEntreprise(@RequestBody Entreprise entrepriseCreate){
        log.info("Saving entreprise : {}", entrepriseCreate);
        Entreprise entrepriseReturn = entrepriseService.createEntreprise(entrepriseCreate);
        return entrepriseReturn;
    }

    @Operation(
            summary = "Suppression d'une entreprise",
            description = "Supprime une entreprise en fonction de son identifiant"
    )
    @Parameter(
            name = "raisonSociale",
            required = true,
            example = "Sonatel",
            description = "La raison sociale est un parametre obligatoire"
    )
    @DeleteMapping("{raisonSociale}")
    public void deleteEntreprise(@PathVariable String raisonSociale){
        log.info("Delete entreprise : {}", raisonSociale);
        entrepriseService.deleteEntreprise(raisonSociale);

    }

    @Operation(
            summary = "Modification d'un entreprise",
            description = "Met à jour une entreprise en fonction de son identifiant"
    )
    @Parameter(
            name = "raisonSociale",
            required = true,
            example = "Sonatel",
            description = "La raison sociale est un parametre obligatoire"
    )
    @PutMapping("/{raisonSociale}")
    public Entreprise update(
            @PathVariable String raisonSociale,
            @RequestBody Entreprise entreprise) {
        log.info("Updating entreprise : {}", entreprise.getRaisonSociale());
        Entreprise result=entrepriseService.update(entreprise);
        log.info("entreprise cree avec succes");
        return result;
    }


}


