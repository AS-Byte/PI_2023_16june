package com.pidevesprit.marcheimmobilierbackend.Services.Interfaces;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Commentaire;

import java.util.List;


public interface ICommentaireService {
    List<Commentaire> getAllCommentaire();

    Commentaire getCommentaire(Long commentaireId);

    Commentaire addCommentaire(Commentaire cm);

    void deleteCommentaire(Long commentaireId);

    Commentaire updateCommentaire(Commentaire cm);
}
