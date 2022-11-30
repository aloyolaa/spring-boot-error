package com.aloyolaa.springbooterror.service;

import com.aloyolaa.springbooterror.model.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final List<User> users;

    public UserServiceImpl() {
        this.users = Arrays.asList(
                new User(1, "Alan", "Loyola"),
                new User(2, "Gabriel", "Loyola"),
                new User(3, "Mario", "Azabache"),
                new User(4, "Juan", "Martinez"),
                new User(5, "Mateo", "Sanchez"),
                new User(6, "Alex", "Lopez"),
                new User(7, "Carlos", "Carranza")
        );
    }

    @Override
    public List<User> findAll() {
        return this.users;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return this.users.stream()
                .filter(u -> id.equals(u.getId()))
                .findFirst();
    }

}
