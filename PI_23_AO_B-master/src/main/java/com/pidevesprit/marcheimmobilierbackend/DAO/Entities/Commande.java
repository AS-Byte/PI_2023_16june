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
public class Commande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;
    private String reference;
    @Temporal(TemporalType.DATE)
    private Date dateCommande;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    private List<Meuble> meublesList;

    @ManyToOne
    private User acheteur;

    @ManyToMany(mappedBy = "CommandesList", cascade = CascadeType.ALL)
    private List<Livraison> LivraisonsList;
}
