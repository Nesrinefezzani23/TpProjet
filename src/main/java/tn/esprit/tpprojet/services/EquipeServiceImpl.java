package tn.esprit.tpprojet.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpprojet.entities.Equipe;
import tn.esprit.tpprojet.repositories.EquipeRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class EquipeServiceImpl implements IEquipeService{
    final EquipeRepository equipeRepository;

    @Override
    public Equipe addOrUpdateEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public void deleteEquipe(long id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public List<Equipe> findAllEquipe() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe findEquipeById(long id) {
        return equipeRepository.findById(id).get();
    }
}
