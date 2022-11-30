package com.aloyolaa.springbooterror.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String id) {
        super("User with ID " + id + " does not exist in the system");
    }
}
