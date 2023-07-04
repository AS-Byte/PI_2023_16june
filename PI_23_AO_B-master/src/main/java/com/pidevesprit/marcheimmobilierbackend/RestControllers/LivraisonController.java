package com.pidevesprit.marcheimmobilierbackend.RestControllers;

import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.ILivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class LivraisonController {

    @Autowired
    private ILivraisonService livraisonService;

    /*@PostMapping("addLivraison")
    Livraison addLivraison(@RequestBody Livraison livraison){

        return livraisonService.addLivraison(livraison);
    }

    @PutMapping("updateLivraison")
    Livraison updateLivraison(@RequestBody Livraison livraison){

        return livraisonService.updateLivraison(livraison);
    }

    @DeleteMapping("deleteLivraison")
    void  deleteLivraison(@RequestBody Livraison livraison) {
        livraisonService.deleteLivraison(livraison);
    }

    @DeleteMapping("deleteLivraisonById")
    void deleteLivraisonByid(@RequestParam Long id){
        livraisonService.deleteLivraisonByid(id);
    }

    @GetMapping("findAllLivraisons")
    List<Livraison> findAllLivraisons(){
        return livraisonService.findAllLivraisons();
    }

    @GetMapping("findLivraisonBId")
    Livraison findLivraisonBId(@RequestParam Long id){
        return livraisonService.findMLivraisonById(id);

    }*/

}
