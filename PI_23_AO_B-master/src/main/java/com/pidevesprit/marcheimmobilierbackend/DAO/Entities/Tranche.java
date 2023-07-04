package com.pidevesprit.marcheimmobilierbackend.DAO.Entities;

import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.Banque;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.TypePayement;
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
public class Tranche implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTranche;
    @Temporal(TemporalType.DATE)
    private Date dateEcheance;
    private boolean etatPayement;
    private double montantEcheance;
    private Long referencePayement;
    private String description;
    @Enumerated(EnumType.STRING)
    private Banque banque;


    @Enumerated(EnumType.STRING)
    private TypePayement modePayement;

    // @JsonIgnore
    @ManyToOne
    private Contrat contrat;


}
