package tn.esprit.tpprojet.services;

import tn.esprit.tpprojet.entities.Entreprise;

import java.util.List;

public interface IEntrepriseService {
    Entreprise addOrUpdateEntreprise(Entreprise entreprise);
    void deleteEntreprise(long id);
    List<Entreprise> findAllEntreprise();
    Entreprise findEntrepriseById(long id);
}
