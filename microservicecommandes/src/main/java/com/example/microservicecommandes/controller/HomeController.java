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
        try {
            List<Commande> commandes = commandeRepository.findAll();
            System.out.println("Commandes récupérées : " + commandes);
            model.addAttribute("commandes", commandes);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Erreur lors de la récupération des commandes : " + e.getMessage());
            return "error"; // Si une erreur survient, rediriger vers la page d'erreur
        }
        return "home"; // Nom de la vue à afficher
    }
}
