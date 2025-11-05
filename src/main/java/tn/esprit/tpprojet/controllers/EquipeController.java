package tn.esprit.tpprojet.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpprojet.entities.Equipe;
import tn.esprit.tpprojet.services.IEquipeService;

import java.util.List;

@RestController
@RequestMapping("/equipeController")
@AllArgsConstructor
public class EquipeController {
    final IEquipeService equipeService;

    @PostMapping("/addEquipe")
    Equipe ajouterEquipe(@RequestBody Equipe projet){
        return equipeService.addOrUpdateEquipe(projet);
    }

    @PutMapping("/updateEquipe")
    Equipe modifierEquipe(@RequestBody Equipe projet){
        return equipeService.addOrUpdateEquipe(projet);
    }

    @DeleteMapping("/deleteEquipe/{idEquipe}")
    void supprimerEquipe(@PathVariable("idEquipe") long id){
        equipeService.deleteEquipe(id);
    }

    @GetMapping("/getAllEquipes")
    List<Equipe> getAllEquipes(){
        return equipeService.findAllEquipe();
    }

    @GetMapping("/getEquipeById/{idEquipe}")
    Equipe getEquipeById(@PathVariable("idEquipe") long id){
        return equipeService.findEquipeById(id);
    }
}
