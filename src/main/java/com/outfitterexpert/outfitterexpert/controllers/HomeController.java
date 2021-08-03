package com.outfitterexpert.outfitterexpert.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String getLandingPage(){
        return "/index";
    }
}
