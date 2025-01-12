package com.example.microservicecommandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.microservicecommandes.repository.CommandeRepository;

@Controller
public class HomeController {

    @Autowired
    private CommandeRepository commandeRepository;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("commandes", commandeRepository.findAll());
        return "home"; // Le nom de ton fichier HTML sans extension
    }
}
