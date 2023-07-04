package com.pidevesprit.marcheimmobilierbackend.Services;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Categorie;
import com.pidevesprit.marcheimmobilierbackend.DAO.Repositories.CategorieRepository;
import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.ICategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService implements ICategorieService {

    @Autowired
    private CategorieRepository categorieRepo;

    @Override
    public Categorie addCategorie(Categorie anc) {
        return categorieRepo.save(anc);
    }

    @Override
    public Categorie updateCategorie(Categorie anc) {
        return categorieRepo.save(anc);
    }

    @Override
    public void deleteCategorie(Categorie anc) {
        categorieRepo.delete(anc);
    }

    @Override
    public void deleteCategorie(Long id) {
        categorieRepo.deleteById(id);
    }

    @Override
    public List<Categorie> findAllCategorie() {
        return (List<Categorie>) categorieRepo.findAll();
    }

    @Override
    public Categorie findCategorieId(Long id) {
        return categorieRepo.findById(id).get();
    }
}
