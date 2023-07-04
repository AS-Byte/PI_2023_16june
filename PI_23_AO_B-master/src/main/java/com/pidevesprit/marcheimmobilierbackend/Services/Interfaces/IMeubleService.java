package com.pidevesprit.marcheimmobilierbackend.Services.Interfaces;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Meuble;

import java.util.List;

public interface IMeubleService {

    List<Meuble> findAllMeubles();

    Meuble findMeubleById(Long id);

    Meuble addMeuble(Meuble meuble);

    Meuble updateMeuble(Meuble meuble);

    void deleteMeuble(Meuble meuble);

    void deleteMeubleByid(Long id);
}
