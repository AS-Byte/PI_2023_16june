package com.pidevesprit.marcheimmobilierbackend.Services.Interfaces;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.User;
import com.pidevesprit.marcheimmobilierbackend.DTO.UserResponse;

import java.util.List;

public interface IUserService {


    List<User> findAllUsers();

    public UserResponse findCurrentUser(String email);


}
