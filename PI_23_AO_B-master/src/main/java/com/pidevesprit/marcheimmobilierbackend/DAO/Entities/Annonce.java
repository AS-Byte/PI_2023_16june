package com.pidevesprit.marcheimmobilierbackend.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.TypeAnnonce;
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
public class Annonce implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnnonce;
    private String adresseAnnonce;
    private Double superficie;
    @Temporal(TemporalType.DATE)
    private Date dateAnnonce;
    private String description;
    @Enumerated(EnumType.STRING)
    private TypeAnnonce typeAnnonce;


    //(Relation Annonce-User)
    @JsonIgnore
    @ManyToOne
    private User annonceur;


    @JsonIgnore
    @OneToMany
    private List<RDV> listRDVs;


    @JsonIgnore
    @ManyToOne
    private Categorie category;

    //(Relation Annonce-Contrat)
    @JsonIgnore
    @OneToMany
    private List<Contrat> contratList;


    //(Relation Annonce-AnnonceurDisponibility)=> disponibilité de l'annonceur
    @JsonIgnore
    @OneToMany(mappedBy = "annonce")
    private List<AnnonceurDisponibility> disponibilityList;


}
