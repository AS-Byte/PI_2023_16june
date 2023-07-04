package com.pidevesprit.marcheimmobilierbackend.RestControllers;

import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.ICategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class CategorieController {
    @Autowired
    private ICategorieService annonceService;
   /* @PostMapping("Ajouter_Categorie")
    Categorie ajouterAnnonce(@RequestBody Categorie cat){
        return annonceService.addCategorie(cat);

    }
    @PutMapping("Modifier_Categorie")
    Categorie modifierCategorie(@RequestBody Categorie cat){
        return annonceService.updateCategorie(cat);
    }

    @DeleteMapping("Supprimer_Categorie_ById")
    void supprimerCategorieById(@RequestParam Long id){

        annonceService.deleteCategorie(id);
    }
    @DeleteMapping("Supprimer_Categorie")
    void supprimerCategorieByObject(@RequestBody Categorie cat) {

        annonceService.deleteCategorie(cat);
    }
    @GetMapping("Afficher_All_Categorie")
    List<Categorie> afficherAllCategorie(){

        return annonceService.findAllCategorie();
    }
    @GetMapping("Afficher_Categorie_ById")
    Categorie afficherCategorieById(@RequestParam Long id){
        return annonceService.findCategorieId(id);


    }*/

}
