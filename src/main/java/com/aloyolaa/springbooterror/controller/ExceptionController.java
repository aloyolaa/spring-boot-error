package com.aloyolaa.springbooterror.controller;

import com.aloyolaa.springbooterror.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public String arithmeticException(Exception e, Model model) {
        model.addAttribute("error", "Arithmetic Error");
        model.addAttribute("message", e.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", LocalDateTime.now());
        return "error/arithmetic";
    }

    @ExceptionHandler(NumberFormatException.class)
    public String numberFormatException(Exception e, Model model) {
        model.addAttribute("error", "Number Format Error");
        model.addAttribute("message", e.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", LocalDateTime.now());
        return "error/number-format";
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFoundException(UserNotFoundException e, Model model) {
        model.addAttribute("error", "User Not Found");
        model.addAttribute("message", e.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", LocalDateTime.now());
        return "error/user-not-found";
    }

}
