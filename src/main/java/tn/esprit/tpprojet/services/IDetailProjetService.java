package tn.esprit.tpprojet.services;

import tn.esprit.tpprojet.entities.DetailProjet;

import java.util.List;

public interface IDetailProjetService {
    DetailProjet addOrUpdateDetailProjet(DetailProjet detailprojet);
    void deleteDetailProjet(long id);
    List<DetailProjet> findAllDetailProjet();
    DetailProjet findDetailProjetById(long id);
}
