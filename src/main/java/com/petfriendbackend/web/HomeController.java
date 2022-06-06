package com.petfriendbackend.web;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.petfriendbackend.model.User;
import com.petfriendbackend.model.Login;
import com.petfriendbackend.service.UserService;

@Controller
public class HomeController {
    @Autowired
    public UserService userService;

    @GetMapping("/")
    public String home(Map<String, Object> map) {
        return "home";
    }

    @GetMapping("/showLoginPage")
    public String showLoginPage(ModelMap model) {
        model.addAttribute(new Login());

        return "login";
    }

    @GetMapping("/showRegistrationPage")
    public String showRegistrationPage(ModelMap model) {
        model.addAttribute(new User());

        return "registration";
    }

}