package com.pidevesprit.marcheimmobilierbackend.Services.Interfaces;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Livraison;

import java.util.List;

public interface ILivraisonService {

    List<Livraison> findAllLivraisons();

    Livraison findMLivraisonById(Long id);

    Livraison addLivraison(Livraison livraison);

    Livraison updateLivraison(Livraison livraison);

    void deleteLivraison(Livraison livraison);

    void deleteLivraisonByid(Long id);
}
