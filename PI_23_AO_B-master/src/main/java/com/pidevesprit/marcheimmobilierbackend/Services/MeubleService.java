package com.pidevesprit.marcheimmobilierbackend.Services;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Meuble;
import com.pidevesprit.marcheimmobilierbackend.DAO.Repositories.MeubleRepository;
import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.IMeubleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeubleService implements IMeubleService {

    @Autowired
    private MeubleRepository meubleRepo;

    @Override
    public List<Meuble> findAllMeubles() {
        return (List<Meuble>) meubleRepo.findAll();
    }

    @Override
    public Meuble findMeubleById(Long id) {
        return meubleRepo.findById(id).get();
    }

    public Meuble addMeuble(Meuble meuble) {
        return meubleRepo.save(meuble);
    }

    @Override
    public Meuble updateMeuble(Meuble meuble) {
        return meubleRepo.save(meuble);
    }

    @Override
    public void deleteMeuble(Meuble meuble) {
        meubleRepo.delete(meuble);
    }

    @Override
    public void deleteMeubleByid(Long id) {

        meubleRepo.deleteById(id);

    }

}
