package com.pidevesprit.marcheimmobilierbackend.RestControllers;

import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.ICommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class CommandeController {

    @Autowired
    private ICommandeService commandeService;


    /*@PostMapping("addCommande")
    Commande addCommande(@RequestBody Commande commande){

        return commandeService.addCommande(commande);
    }

    @PutMapping("updateCommande")
    Commande updateCommande(@RequestBody Commande commande){

        return commandeService.updateCommande(commande);
    }

    @DeleteMapping("deleteCommande")
    void  deleteCommande(@RequestBody Commande commande) {
        commandeService.deleteCommande(commande);
    }

    @DeleteMapping("deleteCommandeById")
    void deleteCommandeByid(@RequestParam Long id){
        commandeService.deleteCommandeByid(id);
    }

    @GetMapping("findAllCommandes")
    List<Commande> findAllCommandes(){
        return commandeService.findAllCommandes();
    }

    @GetMapping("findCommandeBId")
    Commande findCommandeBId(@RequestParam Long id){
        return commandeService.findCommandeById(id);

    }*/

}
