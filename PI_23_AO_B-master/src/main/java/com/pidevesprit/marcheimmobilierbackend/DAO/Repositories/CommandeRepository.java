package com.pidevesprit.marcheimmobilierbackend.DAO.Repositories;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Commande;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends CrudRepository<Commande, Long> {
}
