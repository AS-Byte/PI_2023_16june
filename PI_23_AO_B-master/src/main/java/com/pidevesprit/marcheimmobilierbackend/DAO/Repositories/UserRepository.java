package com.pidevesprit.marcheimmobilierbackend.DAO.Repositories;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
