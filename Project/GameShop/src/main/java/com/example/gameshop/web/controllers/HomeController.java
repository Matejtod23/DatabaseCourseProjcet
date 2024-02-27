package com.example.gameshop.web.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public String getHomePage(Model model){
//        model.addAttribute("bodyContent", null);
        return "landingpage";
    }
}
