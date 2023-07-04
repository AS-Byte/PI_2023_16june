package com.pidevesprit.marcheimmobilierbackend.DAO.Repositories;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.React;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactRepository extends CrudRepository<React, Long> {
}
