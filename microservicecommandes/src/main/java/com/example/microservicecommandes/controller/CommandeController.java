package com.example.microservicecommandes.controller;

import com.example.microservicecommandes.model.Commande;
import com.example.microservicecommandes.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @GetMapping
    public List<Commande> getAllCommandes() {
        List<Commande> commandes = commandeService.getAllCommandes();
        System.out.println("Commandes: " + commandes); // Ajoutez cette ligne pour déboguer
        return commandes;
    }

    @PostMapping
    public Commande createCommande(@RequestBody Commande commande) {
        return commandeService.createCommande(commande);
    }
}