package com.pidevesprit.marcheimmobilierbackend.DAO.Repositories;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Contrat;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.EtatContrat;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.TypeContrat;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.TypePayement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ContratRepository extends CrudRepository<Contrat, Long> {


    //select * from contrat where archive=(valeur passée en paramétre)
    List<Contrat> getByArchive(boolean archive);

    //select * from contrat where dateDebutContrat>(param) and datedebutContrat<(parametre)
    List<Contrat> getContratByDateDebutBetween(Date date1, Date date2);

    //select * from contrat where etat_contrat=(valeur passée en paramétre)


    List<Contrat> getByEtatContrat(EtatContrat etat);

    //select * from contrat where modalite_payement=(valeur passée en paramétre)
    List<Contrat> getByModalitePayement(TypePayement modalite);


    //select * from contrat where type_contrat=(valeur passée en paramétre)
    List<Contrat> getByTypeContrat(TypeContrat type);

    //select * from contrat where montant=(valeur passée en paramétre)
    List<Contrat> getByMontant(double montant);

    //select * from contrat where commission =(valeur passée en paramétre)
    List<Contrat> getByCommission(double commission);


    //Afficher liste des contrats d'un User (demandeur) dont l'Id est passé en paramétre avec SQL


    @Query(value = "select * from contrat alias1 join user alias2 on alias1.signataire_id_user =alias2.id_user where alias2.id_user =?1", nativeQuery = true)
    List<Contrat> searchContratByIdSignataire(Long idSignataire);


//Afficher liste des contrats d'un User (demandeur) dont la profession est passée en paramétre avec SQL

    @Query(value = "select count(*)  from contrat alias1 join user alias2 on alias1.signataire_id_user =alias2.id_user where alias2.profession =?1", nativeQuery = true)
    int nbrContratByProfessionSignataire(String profession);


    //Calculer le montant total de commission
    @Query(value = "select sum(commission) from contrat alias", nativeQuery = true)
    Double commissionTotale();

    @Query(value = "select sum(commission) from contrat alias where alias.type_contrat=?1", nativeQuery = true)
    Double commissionTotaleByTypeContrat(String typeContrat);


}
