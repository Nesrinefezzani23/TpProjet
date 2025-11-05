package tn.esprit.tpprojet.services;

import tn.esprit.tpprojet.entities.Equipe;

import java.util.List;

public interface IEquipeService {
    Equipe addOrUpdateEquipe(Equipe equipe);
    void deleteEquipe(long id);
    List<Equipe> findAllEquipe();
    Equipe findEquipeById(long id);
}
