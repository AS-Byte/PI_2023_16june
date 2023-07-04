package com.pidevesprit.marcheimmobilierbackend.Services.Interfaces;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Commande;

import java.util.List;

public interface ICommandeService {

    List<Commande> findAllCommandes();

    Commande findCommandeById(Long id);

    Commande addCommande(Commande commande);

    Commande updateCommande(Commande commande);

    void deleteCommande(Commande commande);

    void deleteCommandeByid(Long id);
}
