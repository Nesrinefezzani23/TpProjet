package tn.esprit.tpprojet.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.annotation.processing.Generated;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProjet;
    private String sujet;
    @OneToOne(cascade = CascadeType.ALL)
    DetailProjet detailProjet;
    @ManyToMany(mappedBy = "projets")
    Set<Equipe> equipes;
}
