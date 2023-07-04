package com.pidevesprit.marcheimmobilierbackend.Services;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.React;
import com.pidevesprit.marcheimmobilierbackend.DAO.Repositories.ReactRepository;
import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.IReactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReactService implements IReactService {

    @Autowired
    private ReactRepository ReactRepo;

    @Override
    public List<React> getAllReact() {

        return (List<React>) ReactRepo.findAll();
    }

    @Override
    public React getReact(Long reactId) {

        return ReactRepo.findById(reactId).orElse(null);
    }

    @Override
    public React addReact(React rc) {

        return ReactRepo.save(rc);
    }

    @Override
    public void deleteReact(Long reactId) {
        ReactRepo.deleteById(reactId);

    }

    @Override
    public React updateReact(React rc) {

        return ReactRepo.save(rc);
    }
}
