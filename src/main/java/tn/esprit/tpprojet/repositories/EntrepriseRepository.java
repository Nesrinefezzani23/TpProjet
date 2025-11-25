package tn.esprit.tpprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tpprojet.entities.Entreprise;

import java.util.List;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
    @Query("SELECT e FROM Entreprise e where e.adresseEntreprise=:adresse")
    List<Entreprise> retrieveByAddress(@Param("adresse")String adresse);

}
