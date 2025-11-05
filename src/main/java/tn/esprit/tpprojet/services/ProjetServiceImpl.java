package tn.esprit.tpprojet.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpprojet.entities.DetailProjet;
import tn.esprit.tpprojet.entities.Equipe;
import tn.esprit.tpprojet.entities.Projet;
import tn.esprit.tpprojet.repositories.DetailProjetRepository;
import tn.esprit.tpprojet.repositories.EquipeRepository;
import tn.esprit.tpprojet.repositories.ProjetRepository;

import java.util.List;
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

    @Override
    public List<Projet> findAllProjet() {
        return projetRepository.findAll();
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

}
