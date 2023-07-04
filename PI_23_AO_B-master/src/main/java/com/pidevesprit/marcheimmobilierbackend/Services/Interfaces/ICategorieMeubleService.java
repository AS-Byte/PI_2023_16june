package com.pidevesprit.marcheimmobilierbackend.Services.Interfaces;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.CategorieMeubles;

import java.util.List;

public interface ICategorieMeubleService {

    List<CategorieMeubles> findAllCategoriesMeubles();

    CategorieMeubles findCategorieMeubleById(Long id);

    CategorieMeubles addCategorieMeuble(CategorieMeubles categorieMeuble);

    CategorieMeubles updateCategorieMeuble(CategorieMeubles categoriemeuble);

    void deleteCategorieMeuble(CategorieMeubles categoriemeuble);

    void deleteCategorieMeubleByid(Long id);
}
