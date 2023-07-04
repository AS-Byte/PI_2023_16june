package com.pidevesprit.marcheimmobilierbackend.Services;

import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.Banque;
import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Contrat;
import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Tranche;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.TypePayement;
import com.pidevesprit.marcheimmobilierbackend.DAO.Repositories.ContratRepository;
import com.pidevesprit.marcheimmobilierbackend.DAO.Repositories.TrancheRepository;
import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.ITrancheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrancheService implements ITrancheService {


    @Autowired
    private TrancheRepository trancheRepo;
    @Autowired
    private ContratRepository contratRepo;

    @Override
    public Tranche addTrancheEtAffecterAContrat(Long idContrat, Tranche tranche) {
        trancheRepo.save(tranche);
        Contrat contrataffecte = contratRepo.findById(idContrat).get();
        tranche.setContrat(contrataffecte);
        trancheRepo.save(tranche);
        contrataffecte.getTrancheList().add(tranche);
        trancheRepo.save(tranche);
        contratRepo.save(contrataffecte);
        return trancheRepo.save(tranche);
    }

    @Override
    public Tranche updateTranche(Tranche tranche) {


        return trancheRepo.save(tranche);
    }

    @Override
    public void deleteTranche(Tranche tranche) {
        trancheRepo.delete(tranche);
    }

    @Override
    public void deleteTrancheById(Long id) {
        trancheRepo.deleteById(id);
    }

    @Override
    public List<Tranche> getAllTranches() {
        return (List<Tranche>) trancheRepo.findAll();
    }

    @Override
    public Tranche getTrancheById(Long id) {
        return trancheRepo.findById(id).get();
    }


    @Override
    public Tranche updateTrancheAfterPayement(Long refpayement, Long idEcheance, Banque bank, TypePayement modePayement) {


        Tranche trancheaffectee = trancheRepo.findById(idEcheance).get();

        trancheaffectee.setEtatPayement(true);
        trancheaffectee.setReferencePayement(refpayement);
        //trancheaffectee.setBank(bank);
        trancheaffectee.setModePayement(modePayement);
        trancheRepo.save(trancheaffectee);
        return trancheaffectee;
    }


}
