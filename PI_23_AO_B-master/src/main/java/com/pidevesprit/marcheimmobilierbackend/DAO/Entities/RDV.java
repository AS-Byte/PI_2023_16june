package com.pidevesprit.marcheimmobilierbackend.DAO.Entities;

import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.TypeFeedback;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RDV implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRDV;
    @Temporal(TemporalType.DATE)
    private Date dateRDV;
    @Temporal(TemporalType.TIME)
    private Date timeRDV;
    private int dureeRDV;//en heure
    private String contenuFeedback;
    private int noteVisite;
    @Enumerated(EnumType.STRING)
    private TypeFeedback typeFeedback;


    //(Relation User-RDV)
    //@JsonIgnore
    @ManyToOne
    private User visiteur;


}
