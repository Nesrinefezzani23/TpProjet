package tn.esprit.tpprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpprojet.entities.DetailProjet;

@Repository
public interface DetailProjetRepository extends JpaRepository<DetailProjet, Long> {
}
