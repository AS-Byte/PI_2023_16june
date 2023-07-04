package com.pidevesprit.marcheimmobilierbackend.Services;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Commentaire;
import com.pidevesprit.marcheimmobilierbackend.DAO.Repositories.CommentaireRepository;
import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.ICommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaireService implements ICommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    @Override
    public List<Commentaire> getAllCommentaire() {

        return (List<Commentaire>) commentaireRepository.findAll();
    }

    @Override
    public Commentaire getCommentaire(Long commentaireId) {

        return commentaireRepository.findById(commentaireId).orElse(null);
    }

    @Override
    public Commentaire addCommentaire(Commentaire cm) {

        return commentaireRepository.save(cm);
    }

    @Override
    public void deleteCommentaire(Long commentaireId) {
        commentaireRepository.deleteById(commentaireId);

    }

    @Override
    public Commentaire updateCommentaire(Commentaire cm) {

        return commentaireRepository.save(cm);
    }
}
