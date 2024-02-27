package com.example.gameshop.web.controllers;

import com.example.gameshop.models.Publisher;
import com.example.gameshop.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/publisher")
@AllArgsConstructor
public class PublisherController {

    private final PublisherRepository publisherRepository;

    @GetMapping("/list")
    public String getPublisherList(Model model){
        model.addAttribute("publishers", publisherRepository.findAll());
        model.addAttribute("bodyContent", "publishers");
        return "landingpage";
    }

    @GetMapping("/add")
    public String getAddPublisherPage(Model model){
        model.addAttribute("bodyContent", "add_pages/publisher_add");
        return "landingpage";
    }

    @PostMapping("/add")
    public String addPublisher(@RequestParam String name,
                               @RequestParam String country){
        Publisher p = new Publisher(name, country);
        publisherRepository.save(p);
        return "redirect:/publisher/list";
    }
}
