package tn.esprit.tpprojet.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpprojet.entities.Entreprise;
import tn.esprit.tpprojet.repositories.EntrepriseRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class EntrepriseServiceImpl implements IEntrepriseService{
    final EntrepriseRepository entrepriseRepository;
    @Override
    public Entreprise addOrUpdateEntreprise(Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    @Override
    public void deleteEntreprise(long id) {
        entrepriseRepository.deleteById(id);
    }

    @Override
    public List<Entreprise> findAllEntreprise() {
        return entrepriseRepository.findAll();
    }

    @Override
    public Entreprise findEntrepriseById(long id) {
        return entrepriseRepository.findById(id).get();
    }
}
