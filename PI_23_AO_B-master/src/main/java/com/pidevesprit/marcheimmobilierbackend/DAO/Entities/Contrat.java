package com.pidevesprit.marcheimmobilierbackend.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.Banque;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.EtatContrat;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.TypeContrat;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.TypePayement;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    private boolean archive;

    private double montant;
    private double montantMensuel;
    private double commission;
    @Enumerated(EnumType.STRING)
    private TypePayement modalitePayement;
    @Enumerated(EnumType.STRING)
    private Banque bank;


    @Enumerated(EnumType.STRING)
    private TypeContrat typeContrat;

    @Enumerated(EnumType.STRING)
    private EtatContrat etatContrat;


    //(Relation Contrat-User)
    //@JsonIgnore
    @ManyToOne
    private User signataire;//en tant que demandeur (acheteur ou locataire)
    //(Relation Contrat-Tranche)
    @JsonIgnore
    @OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL)
    private List<Tranche> trancheList;


}
