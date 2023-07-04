package com.pidevesprit.marcheimmobilierbackend.DAO.Repositories;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.AnnonceurDisponibility;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AnnonceurDisponibilityRepository extends CrudRepository<AnnonceurDisponibility, Long> {

    //select * from AnnonceurDisponibility where DateDisponibile=(valeur passée en paramétre)
    List<AnnonceurDisponibility> getByDateDisponible(Date date);

    //select * from AnnonceurDisponibility where Heure debut=(valeur passée en paramétre)
    List<AnnonceurDisponibility> getByHeureDebutAndHeureFin(int hd, int hf);

    //select * from AnnonceurDisponibility where Annonce=(valeur passée en paramétre)

    // List<AnnonceurDisponibility> getByAnnonce(Long id);


    //select * from contrat By AnnonceurID=(valeur passée en paramétre)


    @Query(value = "select * from annonceur_disponibility alias1 join annonce alias2 on alias1.annonce_id_annonce =alias2.id_annonce " +
            "join User alias3 on alias2.annonceur_id_user =alias3.id_user where alias3.id_user=?1", nativeQuery = true)
    List<AnnonceurDisponibility> getAnnonceurDisponibilitiesByAnnonceurId(Long id);


}
