package com.pidevesprit.marcheimmobilierbackend.RestControllers;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.RDV;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.TypeFeedback;
import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.IRDVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class RDVController {
    @Autowired
    private IRDVService RDVrest;

    @PostMapping("/addRDVEtAffecterVisiteur/{email}")
    RDV ajouterRDV(@PathVariable String email, @RequestBody RDV rdv) {
        return RDVrest.addRDVEtAffecterVisiteur(email, rdv);

    }

    @PutMapping("/updateRDV/")
    RDV modifierRDV(@RequestBody RDV rdv) {
        return RDVrest.updateRDV(rdv);
    }

    @DeleteMapping("/deleteRDVById/{id}")
    void supprimerRDVById(@PathVariable Long id) {

        RDVrest.deleteRDV(id);
    }

    @DeleteMapping("/deleteRDV")
    void supprimerRDVByObject(@RequestBody RDV rdv) {

        RDVrest.deleteRDV(rdv);
    }

    @GetMapping("/getAllRDV")
    List<RDV> afficherAllRDV() {

        return RDVrest.findAllRDV();
    }

    @GetMapping("/getRDVById/{id}")
    RDV afficherRDVById(@PathVariable Long id) {
        return RDVrest.findRDVById(id);


    }

    @GetMapping("GetRDVsByTypeFeedback")
    List<RDV> afficherRDVByTypefeedback(@RequestParam TypeFeedback typefeedback) {


        return RDVrest.searchByTypeFeedback(typefeedback);
    }

    @GetMapping("GetRDVsByNoteVisite")
    List<RDV> afficherRDVByNotevisite(@RequestParam int note) {
        return RDVrest.searchByNoteVisite(note);
    }

    @GetMapping("GetRDVsByDateRDVBetween")
    List<RDV> afficherRDVByDateBetween(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date1, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date2) {

        return RDVrest.searchByDateRDVBetween(date1, date2);
    }

    @GetMapping("GetRDVsByIdVisiteur")
    List<RDV> afficherRDVByIdVisiteur(@RequestParam Long idVisiteur) {

        return RDVrest.searchRDVByIdVisiteur(idVisiteur);
    }

    @GetMapping("/getRdvsByEmailVisiteur/{email}")
    List<RDV> afficherRDVsByEmailVisiteur(@PathVariable String email) {

        return RDVrest.searchRDVByEmailVisiteur(email);
    }


}
