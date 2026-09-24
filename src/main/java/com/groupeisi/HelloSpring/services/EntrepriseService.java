package com.groupeisi.HelloSpring.services;

import com.groupeisi.HelloSpring.entities.Entreprise;
import com.groupeisi.HelloSpring.entities.Etudiant;
import com.groupeisi.HelloSpring.entities.Stage;
import com.groupeisi.HelloSpring.repositories.EntrepriseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EntrepriseService {

    private final EntrepriseRepository entrepriseRepository;

    // La fonction qui permet de recuperer toutes les entreprises puis de les envoyees au controller.
    public  List<Entreprise> findAll() {
        return entrepriseRepository.findAll();
    }

    public Optional<Entreprise> findById(String raisonSociale)
    {
        return  entrepriseRepository.findById(raisonSociale);
    }

    // lA FONCTION QUI NOUS PERMETTRA DE CREER UNE ENTREPRISE DANS LA BASE DE DONNEES
    public Entreprise createEntreprise(Entreprise entreprise){
        return entrepriseRepository.save(entreprise);
    }

    // lA FONCTION QUI NOUS PERMETTRA DE SUPPRIMER UNE ENTREPRISE DANS LA BASE DE DONNEES PAR SON IDENTIFIANT
    public void deleteEntreprise(String raisonSociale){
        entrepriseRepository.deleteById(raisonSociale);
    }
    public Entreprise update(Entreprise entreprise) {
        entreprise=entrepriseRepository.save(entreprise);
        return entreprise;
    }


}
