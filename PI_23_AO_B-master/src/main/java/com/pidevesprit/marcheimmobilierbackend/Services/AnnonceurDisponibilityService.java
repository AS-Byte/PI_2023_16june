package com.pidevesprit.marcheimmobilierbackend.Services;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Annonce;
import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.AnnonceurDisponibility;
import com.pidevesprit.marcheimmobilierbackend.DAO.Repositories.AnnonceRepository;
import com.pidevesprit.marcheimmobilierbackend.DAO.Repositories.AnnonceurDisponibilityRepository;
import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.IAnnonceurDisponibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AnnonceurDisponibilityService implements IAnnonceurDisponibilityService {

    @Autowired
    private AnnonceurDisponibilityRepository AnnonceurDispoRepo;
    @Autowired
    private AnnonceRepository annonceRepo;


    @Override
    public AnnonceurDisponibility addDisponibilityEtAffecterAnnonce(Long id, AnnonceurDisponibility disponibility) {

        Annonce annonceaffecte = annonceRepo.findById(id).get();
        disponibility.setDateDisponible(disponibility.getDateDisponible());
        disponibility.setAnnonce(annonceaffecte);
        disponibility.setHeureDebut(disponibility.getHeureDebut());
        disponibility.setHeureFin((disponibility.getHeureFin()));


        return AnnonceurDispoRepo.save(disponibility);
    }

    @Override
    public AnnonceurDisponibility updateAnnonceurDisponibility(AnnonceurDisponibility AnnonceurDisponiblity) {
        return AnnonceurDispoRepo.save(AnnonceurDisponiblity);
    }

    @Override
    public void deleteAnnonceurDisponibility(AnnonceurDisponibility AnnonceurDisponiblity) {
        AnnonceurDispoRepo.delete(AnnonceurDisponiblity);
    }

    @Override
    public void deleteAnnonceurDisponibilityById(Long id) {
        AnnonceurDispoRepo.deleteById(id);
    }

    @Override
    public AnnonceurDisponibility getAnnonceurDisponibilityById(Long id) {
        return AnnonceurDispoRepo.findById(id).get();
    }

    @Override
    public List<AnnonceurDisponibility> getAllAnnonceurDisponibility() {
        return (List<AnnonceurDisponibility>) AnnonceurDispoRepo.findAll();
    }

    @Override
    public List<AnnonceurDisponibility> searchDisponibilityByDateDisponible(Date date) {
        return AnnonceurDispoRepo.getByDateDisponible(date);
    }

    @Override
    public List<AnnonceurDisponibility> searchDisponibilityByHeureDebutAndFin(int heureDebut, int heureFin) {
        return AnnonceurDispoRepo.getByHeureDebutAndHeureFin(heureDebut, heureFin);
    }

    @Override
    public List<AnnonceurDisponibility> searchDisponibilityByIdAnnonceur(long id) {
        return AnnonceurDispoRepo.getAnnonceurDisponibilitiesByAnnonceurId(id);
    }
}
