package com.pidevesprit.marcheimmobilierbackend.Services.Interfaces;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.*;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.EtatContrat;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.TypeContrat;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.TypePayement;

import java.util.Date;
import java.util.List;

public interface IContratService {
    //CRUD
    Contrat addContratEtAffecterSignataire(String email, Contrat contrat);

    Contrat updateContrat(Contrat contrat);

    void deleteContrat(Contrat contrat);

    void deleteContratById(Long id);

    Contrat getContratById(Long id);

    List<Contrat> findAllContrats();


    //Fonctions avancées


    List<Contrat> searchContratByArchive(boolean archive);

    List<Contrat> searchContratBetweenTwoDates(Date date1, Date date2);

    List<Contrat> searchContratByEtatContrat(EtatContrat etat);

    List<Contrat> searchContratByModalitePayement(TypePayement modalite);

    List<Contrat> searchContratByTypeContrat(TypeContrat type);

    List<Contrat> searchContratByMontant(double montant);

    List<Contrat> searchContratByCommission(double commission);

    List<Contrat> searchContratByIdSignataire(Long idSignataire);

    int nbrContratByProfession(String profession);

    Double commissionTotale();

    Double commissionTotaleByTypeContrat(TypeContrat typeContrat);

    Tranche updateTranche(Long idContrat);

    List<Tranche> addTranchesEtAffecterAContratLocation();


}
