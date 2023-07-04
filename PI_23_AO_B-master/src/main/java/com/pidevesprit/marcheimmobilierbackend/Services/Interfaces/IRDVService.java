package com.pidevesprit.marcheimmobilierbackend.Services.Interfaces;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.RDV;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.TypeFeedback;

import java.util.Date;
import java.util.List;

public interface IRDVService {


    RDV addRDVEtAffecterVisiteur(String email, RDV rdv);

    RDV updateRDV(RDV rdv);

    void deleteRDV(RDV rdv);

    void deleteRDV(Long id);

    List<RDV> findAllRDV();

    RDV findRDVById(Long id);

    List<RDV> searchByDateRDV(Date date);

    List<RDV> searchByTypeFeedback(TypeFeedback typefeedback);

    List<RDV> searchByNoteVisite(int note);

    List<RDV> searchByDateRDVBetween(Date date1, Date date2);

    List<RDV> searchRDVByIdVisiteur(Long idVisiteur);

    List<RDV> searchRDVByEmailVisiteur(String emailVisiteur);

}
