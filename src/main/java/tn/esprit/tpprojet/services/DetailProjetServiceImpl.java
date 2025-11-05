package tn.esprit.tpprojet.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpprojet.entities.DetailProjet;
import tn.esprit.tpprojet.repositories.DetailProjetRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class DetailProjetServiceImpl implements IDetailProjetService{
    final DetailProjetRepository detailProjetRepository;

    @Override
    public DetailProjet addOrUpdateDetailProjet(DetailProjet detailprojet) {
        return detailProjetRepository.save(detailprojet);
    }

    @Override
    public void deleteDetailProjet(long id) {
        detailProjetRepository.deleteById(id);
    }

    @Override
    public List<DetailProjet> findAllDetailProjet() {
        return detailProjetRepository.findAll();
    }

    @Override
    public DetailProjet findDetailProjetById(long id) {
        return detailProjetRepository.findById(id).get();
    }
}
