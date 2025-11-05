package tn.esprit.tpprojet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DetailProjet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idDetailProjet;
    String description;
    String technologies;
    long cout;
    Date dateDebut;

    @OneToOne(mappedBy = "detailProjet")
            @JsonIgnore //l'enleve du corps json
            @ToString.Exclude //l'enleve de la console
    Projet projet;
}
