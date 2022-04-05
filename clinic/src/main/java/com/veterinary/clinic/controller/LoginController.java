package com.veterinary.clinic.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage(){
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString().equals("anonymousUser")){
            return "login/login";
        }
        return "home/home";
    }
}
