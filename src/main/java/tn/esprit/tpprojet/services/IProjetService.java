package tn.esprit.tpprojet.services;

import org.springframework.data.repository.query.Param;
import tn.esprit.tpprojet.entities.DetailProjet;
import tn.esprit.tpprojet.entities.Entreprise;
import tn.esprit.tpprojet.entities.Equipe;
import tn.esprit.tpprojet.entities.Projet;

import java.util.List;

public interface IProjetService {
    Projet addOrUpdateProjet(Projet projet);
    void deleteProjet(long id);
    List<Projet> findAllProjet();
    Projet findProjetById(long id);
    Projet assignProjetDToProject(long idProjet, long idPd);
    Equipe assignProjectToEquipe(long idProjet, long idEquipe);
    Equipe assignProjectsToEquipe(long idEquipe, List<Long> idProjet);
    Projet addProjectAndAssignProjetD(Projet projet, long idPd);
    List<DetailProjet> findByTechnologiesContains(String technologie);
    List<Entreprise> retrieveByAddress(String adresse);
}
