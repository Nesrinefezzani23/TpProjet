package tn.esprit.tpprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpprojet.entities.Projet;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {
}
