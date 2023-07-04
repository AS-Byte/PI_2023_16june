package com.pidevesprit.marcheimmobilierbackend.Services;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Annonce;
import com.pidevesprit.marcheimmobilierbackend.DAO.Repositories.AnnonceRepository;
import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.IAnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnonceService implements IAnnonceService {

    @Autowired
    private AnnonceRepository annonceRepo;

    @Override
    public Annonce addAnnonce(Annonce anc) {
        return annonceRepo.save(anc);
    }

    @Override
    public Annonce updateAnnonce(Annonce anc) {
        return annonceRepo.save(anc);
    }

    @Override
    public void deleteAnnonce(Annonce anc) {
        annonceRepo.delete(anc);
    }

    @Override
    public void deleteAnnonce(Long id) {
        annonceRepo.deleteById(id);
    }

    @Override
    public List<Annonce> findAllAnnonce() {
        return (List<Annonce>) annonceRepo.findAll();
    }

    @Override
    public Annonce findAnnonceyId(Long id) {
        return annonceRepo.findById(id).get();
    }
}
