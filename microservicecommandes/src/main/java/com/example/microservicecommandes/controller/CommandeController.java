package com.example.microservicecommandes.controller;

import com.example.microservicecommandes.model.Commande;
import com.example.microservicecommandes.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    // Endpoint pour récupérer toutes les commandes
    @GetMapping
    public List<Commande> getAllCommandes() {
        List<Commande> commandes = commandeService.getAllCommandes();
        System.out.println("Commandes récupérées : " + commandes); 
        return commandes;
    }

    // Endpoint pour récupérer les commandes récentes des 20 derniers jours
    @GetMapping("/recentes")
    public List<Commande> getCommandesRecentes() {
        List<Commande> commandes = commandeService.getCommandesRecentes();
        System.out.println("Commandes récentes : " + commandes);
        return commandes;
    }

    // Endpoint pour créer une commande
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Renvoie HTTP 201 pour la création d'une ressource
    public Commande createCommande(@RequestBody Commande commande) {
        if (commande == null || commande.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Description de la commande est obligatoire.");
        }
        return commandeService.createCommande(commande);
    }
}
