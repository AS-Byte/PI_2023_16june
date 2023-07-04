package com.pidevesprit.marcheimmobilierbackend.Services.Interfaces;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.AnnonceurDisponibility;

import java.util.Date;
import java.util.List;

public interface IAnnonceurDisponibilityService {

    //CRUD
    AnnonceurDisponibility addDisponibilityEtAffecterAnnonce(Long id, AnnonceurDisponibility disponibility);

    AnnonceurDisponibility updateAnnonceurDisponibility(AnnonceurDisponibility AnnonceurDisponiblity);

    void deleteAnnonceurDisponibility(AnnonceurDisponibility AnnonceurDisponiblity);

    void deleteAnnonceurDisponibilityById(Long id);

    AnnonceurDisponibility getAnnonceurDisponibilityById(Long id);

    List<AnnonceurDisponibility> getAllAnnonceurDisponibility();


    //Fonctions Avancées

    List<AnnonceurDisponibility> searchDisponibilityByDateDisponible(Date date);

    List<AnnonceurDisponibility> searchDisponibilityByHeureDebutAndFin(int heureDebut, int heureFin);

    List<AnnonceurDisponibility> searchDisponibilityByIdAnnonceur(long id);


}
