package com.pidevesprit.marcheimmobilierbackend.Services.Interfaces;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.React;

import java.util.List;

public interface IReactService {
    List<React> getAllReact();

    React getReact(Long reactId);

    React addReact(React rc);

    void deleteReact(Long reactId);

    React updateReact(React rc);
}
