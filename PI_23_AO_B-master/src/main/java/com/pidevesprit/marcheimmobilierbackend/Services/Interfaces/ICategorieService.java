package com.pidevesprit.marcheimmobilierbackend.Services.Interfaces;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Categorie;

import java.util.List;

public interface ICategorieService {
    Categorie addCategorie(Categorie anc);

    Categorie updateCategorie(Categorie anc);

    void deleteCategorie(Categorie anc);

    void deleteCategorie(Long id);

    List<Categorie> findAllCategorie();

    Categorie findCategorieId(Long id);
}
