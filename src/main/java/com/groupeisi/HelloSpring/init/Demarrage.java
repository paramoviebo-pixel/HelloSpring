package com.groupeisi.HelloSpring.init;

import com.groupeisi.HelloSpring.entities.Entreprise;
import com.groupeisi.HelloSpring.entities.Stage;
import com.groupeisi.HelloSpring.entities.Etudiant;
import com.groupeisi.HelloSpring.repositories.EntrepriseRepository;
import com.groupeisi.HelloSpring.repositories.EtudiantRepository;
import com.groupeisi.HelloSpring.repositories.StageRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Component
public class Demarrage implements CommandLineRunner {


    private final EtudiantRepository etudiantRepository;
    private final EntrepriseRepository entrepriseRepository;

    private final StageRepository stageRepository;

  // variable d'entreprise initialisé
  private final List<Entreprise> entreprises = Arrays.asList(

          new Entreprise(
                  "Sonatel",
                  "Télécommunications",
                  "Dakar, Sénégal",
                  "contact@sonatel.sn",
                  "+221338391212"
          ),

          new Entreprise(
                  "SENEGAL AIRLINES",
                  "Transport aérien",
                  "Dakar, Sénégal",
                  "contact@senegalairlines.sn",
                  "+221338690000"
          ),

          new Entreprise(
                  "Kirène",
                  "Agroalimentaire",
                  "Dakar, Sénégal",
                  "contact@kirene.sn",
                  "+221338399999"
          ),

          new Entreprise(
                  "CBAO",
                  "Banque",
                  "Dakar, Sénégal",
                  "contact@cbao.sn",
                  "+221338499696"
          ),

          new Entreprise(
                  "Orange Sénégal",
                  "Télécommunications",
                  "Dakar, Sénégal",
                  "contact@orange.sn",
                  "+221338123456"
          )
  );
    //listes des stages

    List<Stage> stages = Arrays.asList(

            new Stage(
                    "Développement d'une application web avec Spring Boot",
                    LocalDate.of(2026, 1, 15),
                    LocalDate.of(2026, 4, 15),
                    "EN_COURS"
            ),

            new Stage(
                    "Conception d'une application mobile Android",
                    LocalDate.of(2026, 2, 1),
                    LocalDate.of(2026, 5, 1),
                    "EN_COURS"
            ),

            new Stage(
                    "Mise en place d'une base de données PostgreSQL",
                    LocalDate.of(2026, 1, 10),
                    LocalDate.of(2026, 3, 10),
                    "TERMINE"
            ),

            new Stage(
                    "Développement d'une API REST avec Spring Boot",
                    LocalDate.of(2026, 3, 1),
                    LocalDate.of(2026, 6, 1),
                    "EN_COURS"
            ),

            new Stage(
                    "Création d'une plateforme de gestion des entreprises",
                    LocalDate.of(2026, 4, 1),
                    LocalDate.of(2026, 7, 1),
                    "PLANIFIE"
            )
    );
    // 100 prénoms africains : 80 sénégalais + 20 autres africains
    private String[] prenomsAfricains = {
            // 80 prénoms sénégalais
            "Amadou", "Mamadou", "Ibrahima", "Ousmane", "Cheikh",
            "Abdoulaye", "Modou", "Babacar", "Pape", "Serigne",
            "Moussa", "Samba", "Lamine", "Boubacar", "Alioune",
            "Malick", "Mansour", "Souleymane", "Daouda", "Tidiane",
            "Thierno", "Saliou", "Assane", "Abdou", "Matar",
            "Mor", "El Hadji", "Massamba", "Demba", "Balla",
            "Youssoupha", "Birame", "Makhtar", "Cheikhouna", "Ibra",
            "Fatou", "Awa", "Mariama", "Astou", "Aminata",
            "Mame", "Khady", "Ndeye", "Sokhna", "Rama",
            "Coumba", "Adama", "Bineta", "Diary", "Anta",
            "Rokhaya", "Ndèye", "Seynabou", "Sokhna", "Maguette",
            "Dieynaba", "Nabou", "Fama", "Mame Diarra", "Mame Fatou",
            "Mame Awa", "Mame Khady", "Mame Astou", "Mame Coumba",
            "Mame Mariama", "Mame Aminata", "Mame Sokhna", "Mame Anta",
            "Mame Bineta", "Mame Seynabou", "Aïssatou", "Binta",
            "Kiné", "Nafi", "Yacine", "Fari", "Sokhna",
            "Ndèye Fatou", "Ndèye Awa", "Ndèye Astou",

            // 20 autres prénoms africains
            "Kwame", "Kofi", "Chinua", "Chinedu", "Ngozi",
            "Amara", "Zuberi", "Jelani", "Amani", "Baraka",
            "Nia", "Zuri", "Thabo", "Lerato", "Sipho",
            "Nomsa", "Tendai", "Tariro", "Chipo", "Mpho"
    };

    // 50 noms de famille africains : 40 sénégalais + 10 autres africains
    String[] nomsFamilleAfricains = {
            // 40 noms de famille sénégalais
            "Diop", "Ndiaye", "Fall", "Sow", "Ba",
            "Diallo", "Gueye", "Faye", "Sarr", "Sy",
            "Seck", "Mbaye", "Diouf", "Thiam", "Cissé",
            "Kane", "Dieng", "Niang", "Ndour", "Wade",
            "Tall", "Bâ", "Camara", "Touré", "Dramé",
            "Gassama", "Daff", "Sagna", "Badiane", "Mané",
            "Sonko", "Baldé", "Diedhiou", "Beye", "Ndao",
            "Lo", "Samb", "Gningue", "Bodian", "Coly",

            // 10 autres noms de famille africains
            "Mensah", "Okafor", "Nwosu", "Adeyemi", "Oluwole",
            "Mbeki", "Mahlangu", "Dlamini", "Chirwa", "Mwangi"
    };



    @Override
    public void run(String... args) throws Exception {
        log.info("Demarrage"); //trace/debug/info/warn/error
        long nbEntreprise= entrepriseRepository.count();
        long nbStage= stageRepository.count();
        long nbEtudiants = etudiantRepository.count();
        log.info("il existe {} étudiant(s) en base", nbEtudiants);
        log.info("il existe {} stage(s) en base", nbStage);
        log.info("il existe {} entreprise(s) en base", nbEntreprise);

        if (nbEtudiants == 0) {
            log.warn("aucun etudfiant en base, initialisation des etudiants");
            int nbNEwEtudiant = (int)(Math.random()*20)+400;
            log.warn("{} seront crees", nbNEwEtudiant);
            for (int i=0; i<nbNEwEtudiant; i++) {
                int idxPrenom = (int)(Math.random()*prenomsAfricains.length);
                log.trace("indice prenom {}", idxPrenom);
                String prenom = prenomsAfricains[idxPrenom];
                log.trace("prenom {}", prenom);

                int idxNom = (int)(Math.random()*nomsFamilleAfricains.length);
                log.trace("indice nom {}", idxNom);
                String nom = nomsFamilleAfricains[idxNom];
                log.trace("nom {}", nom);

                Etudiant etudiant= new Etudiant();
                etudiant.setNom(nom);
                etudiant.setPrenom(prenom);
                etudiant.setEmail(prenom.charAt(0)+nom+i+"@groupeisi.com");
                etudiant.setNumCarte("2026GL"+(i+1));
                etudiantRepository.save(etudiant);
            }

        }else{
            log.info("il ya desja des données en base (pas d'initialisation a faire)");
        }
// initialisation en base de l'entité entreprise
        if (nbEntreprise == 0) {
            log.warn("aucune entreprise en base, initialisation des etudiants");
            entrepriseRepository.saveAll(entreprises);
        }else {
            log.info("il ya desja des données en base (pas d'initialisation a faire)");
        }
        // initialisation en base de l'entité stage
        if (nbStage== 0) {
            log.warn("aucun stage en base, initialisation des etudiants");
            stageRepository.saveAll(stages);
        }else {
            log.info("il ya desja des données en base (pas d'initialisation a faire)");
        }

    }
}
