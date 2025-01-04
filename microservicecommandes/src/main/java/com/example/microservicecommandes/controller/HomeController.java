package com.example.microservicecommandes.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.microservicecommandes.model.Commande;
import com.example.microservicecommandes.repository.CommandeRepository;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CommandeRepository commandeRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<Commande> commandes = commandeRepository.findAll();
        model.addAttribute("commandes", commandes);
        return "home"; // Nom de la vue à créer
    }
}