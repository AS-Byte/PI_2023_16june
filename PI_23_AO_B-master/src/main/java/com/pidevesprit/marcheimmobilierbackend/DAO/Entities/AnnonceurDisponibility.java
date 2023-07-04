package com.pidevesprit.marcheimmobilierbackend.DAO.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnnonceurDisponibility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDisponibilite;
    @Temporal(TemporalType.DATE)
    private Date dateDisponible;

    @Temporal(TemporalType.TIME)
    private Date heureDebut;
    @Temporal(TemporalType.TIME)
    private Date heureFin;


    //(Relation Annonce-AnnonceurDisponibility)
    //@JsonIgnore
    @ManyToOne
    private Annonce annonce;


}
