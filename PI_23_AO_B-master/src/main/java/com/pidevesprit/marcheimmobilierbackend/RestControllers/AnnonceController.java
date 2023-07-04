package com.pidevesprit.marcheimmobilierbackend.RestControllers;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Annonce;
import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.IAnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AnnonceController {
    @Autowired
    private IAnnonceService annonceService;

    /* @PostMapping("Ajouter_Annonce")
     Annonce ajouterAnnonce(@RequestBody Annonce anc){
         return annonceService.addAnnonce(anc);

     }
     @PutMapping("Modifier_Annonce")
     Annonce modifierAnnonce(@RequestBody Annonce anc){
         return annonceService.updateAnnonce(anc);
     }

     @DeleteMapping("Supprimer_Annonce_ById")
     void supprimerAnnonceyId(@RequestParam Long id){

         annonceService.deleteAnnonce(id);
     }
     @DeleteMapping("Supprimer_Annonce")
     void supprimerAnnonceByObject(@RequestBody Annonce anc) {

         annonceService.deleteAnnonce(anc);
     }*/
    @GetMapping("/getAllAnnonces")
    List<Annonce> afficherAllAnnonce() {

        return annonceService.findAllAnnonce();
    }

    @GetMapping("/getAnnonceById/{idAnnonce}")
    Annonce afficherAnnonceyId(@PathVariable Long idAnnonce) {
        return annonceService.findAnnonceyId(idAnnonce);


    }

}
