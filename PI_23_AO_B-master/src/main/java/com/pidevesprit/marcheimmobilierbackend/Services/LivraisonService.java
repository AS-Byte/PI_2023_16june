package com.pidevesprit.marcheimmobilierbackend.Services;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Livraison;
import com.pidevesprit.marcheimmobilierbackend.DAO.Repositories.LivraisonRepository;
import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.ILivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivraisonService implements ILivraisonService {

    @Autowired
    private LivraisonRepository livraisonRepo;


    @Override
    public List<Livraison> findAllLivraisons() {
        return (List<Livraison>) livraisonRepo.findAll();
    }

    @Override
    public Livraison findMLivraisonById(Long id) {
        return livraisonRepo.findById(id).get();
    }

    @Override
    public Livraison addLivraison(Livraison livraison) {
        return livraisonRepo.save(livraison);
    }

    @Override
    public Livraison updateLivraison(Livraison livraison) {
        return livraisonRepo.save(livraison);
    }

    @Override
    public void deleteLivraison(Livraison livraison) {
        livraisonRepo.delete(livraison);
    }

    @Override
    public void deleteLivraisonByid(Long id) {
        livraisonRepo.deleteById(id);
    }
}
