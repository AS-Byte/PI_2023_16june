package com.pidevesprit.marcheimmobilierbackend.Services;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Commande;
import com.pidevesprit.marcheimmobilierbackend.DAO.Repositories.CommandeRepository;
import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.ICommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService implements ICommandeService {


    @Autowired
    private CommandeRepository commandeRepo;

    @Override
    public List<Commande> findAllCommandes() {
        return (List<Commande>) commandeRepo.findAll();
    }

    @Override
    public Commande findCommandeById(Long id) {
        return commandeRepo.findById(id).get();
    }

    @Override
    public Commande addCommande(Commande commande) {
        return commandeRepo.save(commande);
    }

    @Override
    public Commande updateCommande(Commande commande) {
        return commandeRepo.save(commande);
    }

    @Override
    public void deleteCommande(Commande commande) {
        commandeRepo.delete(commande);
    }

    @Override
    public void deleteCommandeByid(Long id) {
        commandeRepo.deleteById(id);
    }
}
