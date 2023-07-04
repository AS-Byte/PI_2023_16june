package com.pidevesprit.marcheimmobilierbackend.Services;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.CategorieMeubles;
import com.pidevesprit.marcheimmobilierbackend.DAO.Repositories.CategorieMeubleRepository;
import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.ICategorieMeubleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieMeubleService implements ICategorieMeubleService {

    @Autowired
    private CategorieMeubleRepository categorieMeubleRepo;

    @Override
    public List<CategorieMeubles> findAllCategoriesMeubles() {
        return (List<CategorieMeubles>) categorieMeubleRepo.findAll();
    }

    @Override
    public CategorieMeubles findCategorieMeubleById(Long id) {
        return categorieMeubleRepo.findById(id).get();
    }

    @Override
    public CategorieMeubles addCategorieMeuble(CategorieMeubles categorieMeuble) {
        return categorieMeubleRepo.save(categorieMeuble);
    }

    @Override
    public CategorieMeubles updateCategorieMeuble(CategorieMeubles categoriemeuble) {
        return categorieMeubleRepo.save(categoriemeuble);
    }

    @Override
    public void deleteCategorieMeuble(CategorieMeubles categoriemeuble) {
        categorieMeubleRepo.delete(categoriemeuble);
    }

    @Override
    public void deleteCategorieMeubleByid(Long id) {
        categorieMeubleRepo.deleteById(id);
    }
}
