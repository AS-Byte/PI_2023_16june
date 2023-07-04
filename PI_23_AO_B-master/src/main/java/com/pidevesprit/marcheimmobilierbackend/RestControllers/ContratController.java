package com.pidevesprit.marcheimmobilierbackend.RestControllers;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Contrat;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.EtatContrat;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.TypeContrat;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.TypePayement;
import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.IContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")


public class ContratController {
    @Autowired
    private IContratService contratRest;


    @PostMapping("/addContratEtAffecterSignataire/{email}")
    Contrat ajouterContratEtAffecterSignataire(@PathVariable String email, @RequestBody Contrat contrat) {

        return contratRest.addContratEtAffecterSignataire(email, contrat);


    }

    @PutMapping("/updateContrat/")
    Contrat modifierContrat(@RequestBody Contrat contrat) {
        return contratRest.updateContrat(contrat);

    }

    @DeleteMapping("/deleteContratByObjet")
    void supprimerContratByObjet(@RequestBody Contrat contrat) {

        contratRest.deleteContrat(contrat);

    }

    @DeleteMapping("/deleteContratById/{id}")
    void supprimerContratById(@PathVariable Long id) {
        contratRest.deleteContratById(id);


    }

    @GetMapping("/getContratById/{id}")
    Contrat afficherContratById(@PathVariable Long id) {

        return contratRest.getContratById(id);
    }

    @GetMapping("getAllContrats")
    List<Contrat> afficherAllContrats() {

        return contratRest.findAllContrats();
    }

    @GetMapping("/getContratByArchive/{archive}")
    List<Contrat> afficherContratsByArchive(@PathVariable boolean archive) {
        return contratRest.searchContratByArchive(archive);
    }

    @GetMapping("/getContratByDateDebutbetweenTwoDates")
    List<Contrat> afficherContratsByDateDebutBetween(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date1, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date2) {
        return contratRest.searchContratBetweenTwoDates(date1, date2);
    }

    @GetMapping("/getContratByModalite")
    List<Contrat> afficherContratsByModalitePayement(@RequestParam TypePayement modalite) {
        return contratRest.searchContratByModalitePayement(modalite);
    }

    @GetMapping("/getContratByEtatContrat")
    List<Contrat> afficherContratsByEtat(@RequestParam EtatContrat etat) {
        return contratRest.searchContratByEtatContrat(etat);
    }

    @GetMapping("/getContratByTypeContrat")
    List<Contrat> afficherContratsByType(@RequestParam TypeContrat type) {

        return contratRest.searchContratByTypeContrat(type);
    }

    @GetMapping("/getContartsByMontant")
    List<Contrat> afficherContratsByMontant(@RequestParam double montant) {

        return contratRest.searchContratByMontant(montant);
    }

    @GetMapping("/getContartsByCommission")
    List<Contrat> afficherContratsByCommission(@RequestParam double commission) {

        return contratRest.searchContratByCommission(commission);
    }


    @GetMapping("/getContratsByIdSignataire")
    List<Contrat> afficherContratsByIdSignataire(@RequestParam Long idSignataire) {

        return contratRest.searchContratByIdSignataire(idSignataire);
    }

    @GetMapping("/getNbrContratsByProfession")
    int afficherNbrContratsByProfession(@RequestParam String profession) {
        return contratRest.nbrContratByProfession(profession);
    }

    @GetMapping("/TotalCommissionDesContrats")
    Double commissionTotaldesContrats() {
        return contratRest.commissionTotale();
    }

    @GetMapping("/TotalCommissionByTypeContrat")
    Double commissionTotalByTypeContrat(@RequestParam TypeContrat typeContrat) {

        return contratRest.commissionTotaleByTypeContrat(typeContrat);

    }


}
