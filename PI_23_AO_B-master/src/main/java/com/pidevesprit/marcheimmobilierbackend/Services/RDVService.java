package com.pidevesprit.marcheimmobilierbackend.Services;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.RDV;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.TypeFeedback;
import com.pidevesprit.marcheimmobilierbackend.DAO.Repositories.RDVRepository;
import com.pidevesprit.marcheimmobilierbackend.DAO.Repositories.UserRepository;
import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.IRDVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RDVService implements IRDVService {

    @Autowired
    private RDVRepository rdvRepo;
    @Autowired
    private UserRepository userRepo;


    @Override
    public RDV addRDVEtAffecterVisiteur(String email, RDV rdv) {

        // User useraffecte=userRepo.findByEmail(email);

        // rdv.setVisiteur(useraffecte);
        // rdvRepo.save(rdv);
        //useraffecte.getLstRDVs().add(rdv);

        return rdv;
    }

    @Override
    public RDV updateRDV(RDV rdv) {

        Long idRdv = rdv.getIdRDV();
        RDV rdvaffecte = rdvRepo.findById(idRdv).get();
        // rdvaffecte.setVisiteur(rdv.getVisiteur());
        rdvaffecte.setIdRDV(idRdv);
        rdvaffecte.setDateRDV(rdv.getDateRDV());
        rdvaffecte.setDureeRDV(rdv.getDureeRDV());
        rdvaffecte.setNoteVisite(rdv.getNoteVisite());
        rdvaffecte.setContenuFeedback(rdv.getContenuFeedback());
        rdvaffecte.setTypeFeedback(rdv.getTypeFeedback());

        return rdvRepo.save(rdvaffecte);
    }

    @Override
    public void deleteRDV(RDV rdv) {
        rdvRepo.delete(rdv);
    }

    @Override
    public void deleteRDV(Long id) {
        rdvRepo.deleteById(id);

    }

    @Override
    public List<RDV> findAllRDV() {
        return (List<RDV>) rdvRepo.findAll();
    }

    @Override
    public RDV findRDVById(Long id) {
        return rdvRepo.findById(id).get();
    }

    @Override
    public List<RDV> searchByDateRDV(Date date) {
        return rdvRepo.getByDateRDV(date);
    }

    @Override
    public List<RDV> searchByTypeFeedback(TypeFeedback typefeedback) {
        return rdvRepo.getByTypeFeedback(typefeedback);
    }

    @Override
    public List<RDV> searchByNoteVisite(int note) {
        return rdvRepo.getByNoteVisite(note);
    }

    @Override
    public List<RDV> searchByDateRDVBetween(Date date1, Date date2) {
        return rdvRepo.getByDateRDVBetween(date1, date2);
    }

    @Override
    public List<RDV> searchRDVByIdVisiteur(Long idVisiteur) {
        return rdvRepo.searchRDVByIdVisiteur(idVisiteur);
    }

    @Override
    public List<RDV> searchRDVByEmailVisiteur(String emailVisiteur) {
        return rdvRepo.searchRDVByEmailVisiteur(emailVisiteur);
    }
}
