package com.pidevesprit.marcheimmobilierbackend.Services;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.*;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.EtatContrat;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.TypeContrat;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.TypePayement;
import com.pidevesprit.marcheimmobilierbackend.DAO.Repositories.ContratRepository;
import com.pidevesprit.marcheimmobilierbackend.DAO.Repositories.TrancheRepository;
import com.pidevesprit.marcheimmobilierbackend.DAO.Repositories.UserRepository;
import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.IContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ContratService implements IContratService {

    @Autowired
    private ContratRepository contratRepo;
    @Autowired
    private TrancheRepository trancheRepo;
    @Autowired
    private UserRepository userRepo;

    public static Date getNextMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        if (calendar.get(Calendar.MONTH) == Calendar.DECEMBER) {
            calendar.set(Calendar.MONTH, Calendar.JANUARY);
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 1);
        } else {
            calendar.roll(Calendar.MONTH, true);
        }
        return calendar.getTime();
    }

    @Override
    public Contrat addContratEtAffecterSignataire(String email, Contrat contrat) {
        // User useraffecte=userRepo.findByEmail(email);


        Tranche tranche;
        String typemensualite = "Caution";
        long nbrMensualites = (calculDiff(contrat.getDateFin(), contrat.getDateDebut())) / 30;
        contrat.setMontantMensuel(contrat.getMontant() / nbrMensualites);
        contrat.setCommission(contrat.getMontant() * 10 / 100);
        // contrat.setSignataire(useraffecte);
        contratRepo.save(contrat);
        Date dateecheance = contrat.getDateDebut();
        if (contrat.getTypeContrat().toString().equals("LOCATION")) {

            tranche = Tranche.builder()
                    .dateEcheance(dateecheance)
                    .etatPayement(false)
                    .modePayement(contrat.getModalitePayement())
                    .montantEcheance(contrat.getMontant() / nbrMensualites)
                    .banque(contrat.getBank())
                    .description(typemensualite)
                    .contrat(contrat)
                    .build();
            trancheRepo.save(tranche);
            typemensualite = "Loyer";
            for (int j = 0; j < nbrMensualites; j++) {
                tranche = Tranche.builder()
                        .dateEcheance(dateecheance)
                        .etatPayement(false)
                        .modePayement(contrat.getModalitePayement())
                        .montantEcheance(contrat.getMontant() / nbrMensualites)
                        .banque(contrat.getBank())
                        .description(typemensualite)
                        .contrat(contrat)
                        .build();
                trancheRepo.save(tranche);
                dateecheance = getNextMonth(dateecheance);
            }
            contratRepo.save(contrat);


        }
        if (contrat.getTypeContrat().toString().equals("VENTE")) {
            contrat.setCommission(contrat.getMontant() * 20 / 100);
            contrat.setMontantMensuel(0);
            contrat.setArchive(false);
            // contrat.setSignataire(useraffecte);

            contratRepo.save(contrat);

        }

        //  contratRepo.save(contrat);

        return contrat;
        //Tranche tranche1=updateTranche(contrat.getIdContrat());


    }

    @Override
    public Contrat updateContrat(Contrat contrat) {
        Long idContrat = contrat.getIdContrat();
        Contrat contrat1 = contratRepo.findById(idContrat).get();
        contrat1.setIdContrat(contrat.getIdContrat());
        contrat1.setDateDebut(contrat.getDateDebut());
        contrat1.setDateFin(contrat.getDateFin());
        contrat1.setEtatContrat(contrat.getEtatContrat());
        contrat1.setTypeContrat(contrat.getTypeContrat());
        contrat1.setMontant(contrat.getMontant());
        contrat1.setCommission(contrat.getCommission());
        contrat1.setMontantMensuel(contrat.getMontantMensuel());
        contrat1.setModalitePayement(contrat.getModalitePayement());
        contrat1.setArchive(contrat.isArchive());
        contrat1.setBank(contrat.getBank());

        return contratRepo.save(contrat1);
    }

    @Override
    public void deleteContrat(Contrat contrat) {
        contratRepo.delete(contrat);
    }

    @Override
    public void deleteContratById(Long id) {
        contratRepo.deleteById(id);

    }

    @Override
    public Contrat getContratById(Long id) {
        return contratRepo.findById(id).get();
    }

    @Override
    public List<Contrat> findAllContrats() {
        return (List<Contrat>) contratRepo.findAll();
    }

    @Override
    public List<Contrat> searchContratByArchive(boolean archive) {
        return contratRepo.getByArchive(archive);
    }

    @Override
    public List<Contrat> searchContratBetweenTwoDates(Date date1, Date date2) {
        return contratRepo.getContratByDateDebutBetween(date1, date2);
    }

    @Override
    public List<Contrat> searchContratByEtatContrat(EtatContrat etat) {
        return contratRepo.getByEtatContrat(etat);
    }

    @Override
    public List<Contrat> searchContratByModalitePayement(TypePayement modalite) {
        return contratRepo.getByModalitePayement(modalite);
    }

    @Override
    public List<Contrat> searchContratByTypeContrat(TypeContrat type) {
        return contratRepo.getByTypeContrat(type);
    }

    @Override
    public List<Contrat> searchContratByMontant(double montant) {
        return contratRepo.getByMontant(montant);
    }

    @Override
    public List<Contrat> searchContratByCommission(double commission) {
        return contratRepo.getByCommission(commission);
    }

    @Override
    public List<Contrat> searchContratByIdSignataire(Long idSignataire) {
        return contratRepo.searchContratByIdSignataire(idSignataire);
    }

    @Override
    public int nbrContratByProfession(String profession) {


        return contratRepo.nbrContratByProfessionSignataire(profession);
    }

    @Override
    public Double commissionTotale() {
        return contratRepo.commissionTotale();
    }

    @Override
    public Double commissionTotaleByTypeContrat(TypeContrat typeContrat) {
        return contratRepo.commissionTotaleByTypeContrat(typeContrat.toString());
    }

    @Override
    public List<Tranche> addTranchesEtAffecterAContratLocation() {


        return null;
    }

    @Override
    public Tranche updateTranche(Long idContrat) {
        Contrat contrat = contratRepo.findById(idContrat).get();

        Long id = contrat.getIdContrat();
        Tranche tranche1 = trancheRepo.getByContrat(id).get(1);
        tranche1.setDateEcheance(contrat.getDateDebut());
        trancheRepo.save(tranche1);
        return tranche1;
    }

    public long calculDiff(Date date1, Date date2) {
        long diffInMillies = date1.getTime() - date2.getTime();
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
}









