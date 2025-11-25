package tn.esprit.tpprojet.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpprojet.entities.DetailProjet;
import tn.esprit.tpprojet.entities.Equipe;
import tn.esprit.tpprojet.entities.Projet;
import tn.esprit.tpprojet.repositories.DetailProjetRepository;
import tn.esprit.tpprojet.repositories.EquipeRepository;
import tn.esprit.tpprojet.repositories.ProjetRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
@Service
public class ProjetServiceImpl implements IProjetService{
    final ProjetRepository projetRepository;
    final DetailProjetRepository detailProjetRepository;
    private final EquipeRepository equipeRepository;

    @Override
    public Projet addOrUpdateProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public void deleteProjet(long id) {
        projetRepository.deleteById(id);
    }

    //@Scheduled(fixedDelay = 10000) en millisecondes
    //@Scheduled(fixedRate = 10, timeUnit = TimeUnit.SECONDS, initialDelay = 7)
    @Scheduled(cron = "10 * * * * *", zone = "Europe/Istanbul")
    @Override
    public List<Projet> findAllProjet() {
        List<Projet> projets = projetRepository.findAll();
        //Thread.sleep(5000); ajouter throws dans la fonction
        //ajoute le au delay donc y aura exec chaque 15 secondes, au lieu de 10s seulement
        for(Projet projet : projets) {
            log.info(projet.toString());
        }
        return projets;
        //return projetRepository.findAll();
    }

    @Override
    public Projet findProjetById(long id) {
        return projetRepository.findById(id).get();
    }

    @Override
    public Projet assignProjetDToProject(long idProjet, long idPd) {
        Projet projet = projetRepository.findById(idProjet).get();
        DetailProjet detailProjet = detailProjetRepository.findById(idPd).get();
        projet.setDetailProjet(detailProjet);
        return projetRepository.save(projet);
    }

    @Override
    public Equipe assignProjectToEquipe(long idProjet, long idEquipe) {
        Equipe equipe = equipeRepository.findById(idEquipe).get();
        Projet projet = projetRepository.findById(idProjet).get();
        equipe.getProjets().add(projet);
        return equipeRepository.save(equipe);
    }

    @Override
    public Equipe assignProjectsToEquipe(long idEquipe, List<Long> idProjet) {
        Equipe equipe = equipeRepository.findById(idEquipe).get();
        List<Projet> projet = projetRepository.findAllById(idProjet);
        equipe.getProjets().addAll(projet);
        return equipeRepository.save(equipe);
    }

    @Override
    public Projet addProjectAndAssignProjetD(Projet projet, long idPd) {
        DetailProjet projetDetail = detailProjetRepository.findById(idPd).get();
        projet.setDetailProjet(projetDetail);
        return null;
    }

    @Override
    public List<DetailProjet> findByTechnologiesContains(String technologie) {
        return detailProjetRepository.findByTechnologiesContains(technologie);
    }

}
