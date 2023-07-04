package com.pidevesprit.marcheimmobilierbackend.DAO.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livraison implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivraison;
    @Temporal(TemporalType.DATE)
    private Date dateLivraison;
    private String adresse;
    private double fraisLivraison;

    @ManyToOne
    private User livreur;

    @ManyToMany
    private List<Commande> CommandesList;
}
