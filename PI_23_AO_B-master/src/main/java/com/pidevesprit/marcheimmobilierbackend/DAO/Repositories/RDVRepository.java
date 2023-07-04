package com.pidevesprit.marcheimmobilierbackend.DAO.Repositories;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.RDV;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.TypeFeedback;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RDVRepository extends CrudRepository<RDV, Long> {


    List<RDV> getByDateRDV(Date date);

    List<RDV> getByTypeFeedback(TypeFeedback typefeedback);

    List<RDV> getByNoteVisite(int note);

    List<RDV> getByDateRDVBetween(Date date1, Date date2);


    //Afficher les RDVs d'unVisiteur dont l'id est passé en paramétre

    @Query(value = "select * from rdv alias1 join user alias2 on alias1.visiteur_id_user = alias2.id_user where alias2.id_user =?1", nativeQuery = true)
    List<RDV> searchRDVByIdVisiteur(Long idVisiteur);

    @Query(value = "select * from rdv alias1 join user alias2 on alias1.visiteur_id_user = alias2.id_user where alias2.email =?1", nativeQuery = true)
    List<RDV> searchRDVByEmailVisiteur(String emailVisiteur);


}
