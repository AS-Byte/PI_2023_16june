package com.pidevesprit.marcheimmobilierbackend.RestControllers;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.AnnonceurDisponibility;
import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.IAnnonceurDisponibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AnnonceurDisponibilityController {


    @Autowired
    private IAnnonceurDisponibilityService AnnonceurDispoRest;

    @GetMapping("/getAllDisponibilities")
    List<AnnonceurDisponibility> getAllAnnonceurDisponibilities() {

        return AnnonceurDispoRest.getAllAnnonceurDisponibility();
    }


    @GetMapping("/getDisponibilityById/{id}")
    AnnonceurDisponibility getannonceurDisponibilitiesById(@PathVariable Long id) {

        return AnnonceurDispoRest.getAnnonceurDisponibilityById(id);
    }

    @PutMapping("/updateDisponibility/")
    AnnonceurDisponibility updateAnnonceurDisponibility(@RequestBody AnnonceurDisponibility disponibility) {


        return AnnonceurDispoRest.updateAnnonceurDisponibility(disponibility);
    }

    @PostMapping("/addDisponibility/{id}")
    AnnonceurDisponibility addAnnonceurDisponibility(@PathVariable Long id, @RequestBody AnnonceurDisponibility disponibility) {
        return AnnonceurDispoRest.addDisponibilityEtAffecterAnnonce(id, disponibility);

    }

    @DeleteMapping("/deleteDisponibility")
    void supprimerAnnonceurDisponibilityByObjet(@RequestBody AnnonceurDisponibility disponibility) {

        AnnonceurDispoRest.deleteAnnonceurDisponibility(disponibility);
    }

    @DeleteMapping("/deleteDisponibilityById/{id}")
    void supprimerAnnonceurDisponibilityById(@PathVariable Long id) {
        AnnonceurDispoRest.deleteAnnonceurDisponibilityById(id);
    }


    @GetMapping("/getDisponibilityByDateDisponible")
    List<AnnonceurDisponibility> AfficherAnnonceurDisponibilityByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {

        return AnnonceurDispoRest.searchDisponibilityByDateDisponible(date);
    }

    @GetMapping("/getDisponibilityByHeureDebutAndFin")
    List<AnnonceurDisponibility> AfficherAnnonceurDisponibilityByHeureDebutAndFin(@RequestParam int heuredebut, @RequestParam int heurefin) {
        return AnnonceurDispoRest.searchDisponibilityByHeureDebutAndFin(heuredebut, heurefin);
    }

    @GetMapping("/getDisponibilityByAnnonceurId")
    List<AnnonceurDisponibility> AfficherAnnonceurDisponibilityByIdAnnonceur(@RequestParam long id) {

        return AnnonceurDispoRest.searchDisponibilityByIdAnnonceur(id);
    }


}
