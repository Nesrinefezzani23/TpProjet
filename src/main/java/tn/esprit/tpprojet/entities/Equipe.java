package tn.esprit.tpprojet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idEquipe;
    String nomEquipe;
    @Enumerated(EnumType.STRING)
    Domaine domaine;
    @ManyToMany
    Set<Projet> projets;
    @ManyToOne
    Entreprise entreprise;
}
