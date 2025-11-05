package tn.esprit.tpprojet.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpprojet.entities.Equipe;
import tn.esprit.tpprojet.entities.Projet;
import tn.esprit.tpprojet.services.IProjetService;

import java.util.List;

@RestController
@RequestMapping("/projetController")
@AllArgsConstructor
public class ProjetController {
    final IProjetService projetService;

    @PostMapping("/addProject")
    Projet ajouterProjet(@RequestBody Projet projet){
        return projetService.addOrUpdateProjet(projet);
    }

    @PutMapping("/updateProject")
    Projet modifierProjet(@RequestBody Projet projet){
        return projetService.addOrUpdateProjet(projet);
    }

    @DeleteMapping("/deleteProject/{idProject}")
    void supprimerProjet(@PathVariable("idProject") long id){
        projetService.deleteProjet(id);
    }

    @GetMapping("/getAllProjects")
    List<Projet> getAllProjets(){
        return projetService.findAllProjet();
    }

    @GetMapping("/getProjectById/{idProject}")
    Projet getProjetById(@PathVariable("idProject") long id){
        return projetService.findProjetById(id);
    }

    @PutMapping("/assignProjetDToProject/{idProject}/{idPd}")
    Projet assignProjetDToProject(@PathVariable("idProject") long idProject, @PathVariable("idPd") long idPd){
        return projetService.assignProjetDToProject(idProject, idPd);
    }

    @PutMapping("/assignProjectToEquipe/{idProject}/{idEquipe}")
    Equipe assignProjectToEquipe(@PathVariable("idProject") long idProject, @PathVariable("idEquipe") long idEquipe){
        return projetService.assignProjectToEquipe(idProject, idEquipe);
    }

    @PutMapping("/assignProjectsToEquipe/{idEquipe}/{idProject}")
    Equipe assignProjectsToEquipe(@PathVariable("idEquipe") long idEquipe, @PathVariable("idEquipe") List<Long> idProject){
        return projetService.assignProjectsToEquipe(idEquipe, idProject);
    }

    @PostMapping("/addProjectAndAssignProjetD/{idPd}")
    Projet addProjectAndAssignProjetD(@RequestBody Projet projet, @PathVariable long idPd){
        return projetService.addProjectAndAssignProjetD(projet, idPd);
    }
}
