package com.pidevesprit.marcheimmobilierbackend.DAO.Entities;

import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.Disponibilite;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.EtatMeuble;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Meuble implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMeuble;
    @Enumerated(EnumType.STRING)
    private EtatMeuble etatMeuble;
    private double prix;
    private String description;
    private Date dateFabrication;
    @Enumerated(EnumType.STRING)
    private Disponibilite disponibilite;

    @ManyToOne
    private CategorieMeubles meubleCategory;
    @ManyToOne
    private User vendeur;

    @ManyToOne
    private Commande commande;


}
