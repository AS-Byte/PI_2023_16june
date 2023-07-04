package com.pidevesprit.marcheimmobilierbackend.RestControllers;

import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.Banque;
import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Tranche;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.TypePayement;
import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.ITrancheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TrancheController {

    @Autowired
    private ITrancheService trancheRest;

    @GetMapping("/getAllTranches/")
    List<Tranche> getAllTranches() {
        return trancheRest.getAllTranches();
    }

    @GetMapping("/getTrancheById/{id}")
    Tranche getTrancheById(@PathVariable Long id) {
        return trancheRest.getTrancheById(id);
    }

    @PostMapping("/addTrancheAffecterToContrat/{idContrat}")
    Tranche addTranche(@PathVariable Long idContrat, @RequestBody Tranche tranche) {

        return trancheRest.addTrancheEtAffecterAContrat(idContrat, tranche);
    }

    @PutMapping("/updateTranche/")
    Tranche updateTranche(@RequestBody Tranche tranche) {
        return trancheRest.updateTranche(tranche);
    }

    @DeleteMapping("SupprimerTrancheByObject")
    void deleteTranche(@RequestBody Tranche tranche) {
        trancheRest.deleteTranche(tranche);
    }

    @DeleteMapping("/deleteTrancheById/{id}")
    void deleteTrancheById(@PathVariable Long id) {
        trancheRest.deleteTrancheById(id);
    }

    @PutMapping("updateTranchePayee")
    Tranche updatingTranchePayee(@RequestParam Long refpayement, @RequestParam Long idEcheance, @RequestParam Banque bank, @RequestParam TypePayement modePayement) {

        return trancheRest.updateTrancheAfterPayement(refpayement, idEcheance, bank, modePayement);
    }


}
