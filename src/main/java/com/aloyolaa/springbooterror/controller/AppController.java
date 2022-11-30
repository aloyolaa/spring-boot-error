package com.aloyolaa.springbooterror.controller;

import com.aloyolaa.springbooterror.exception.UserNotFoundException;
import com.aloyolaa.springbooterror.model.User;
import com.aloyolaa.springbooterror.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class AppController {

    private UserService userService;

    @GetMapping("/index")
    public String index() {
        //Integer value = 100 / 0;
        Integer value = Integer.parseInt("10x");
        return "index";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        User user = userService.findById(id).orElseThrow(() -> new UserNotFoundException(id.toString()));
        model.addAttribute("user", user);
        model.addAttribute("title", "User Detail: " + user.getFirstName() + " " + user.getLastName());
        return "detail";
    }

}
