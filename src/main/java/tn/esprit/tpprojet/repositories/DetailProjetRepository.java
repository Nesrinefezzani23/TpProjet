package tn.esprit.tpprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpprojet.entities.DetailProjet;
import tn.esprit.tpprojet.entities.Projet;

import java.util.List;

@Repository
public interface DetailProjetRepository extends JpaRepository<DetailProjet, Long> {
    List<DetailProjet> findByTechnologiesContains(String technologies);
}
