package com.aloyolaa.springbooterror.service;

import com.aloyolaa.springbooterror.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Integer id);

}
