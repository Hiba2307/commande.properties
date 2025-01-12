package com.example.microservicecommandes.controller;

import com.example.microservicecommandes.model.Commande;
import com.example.microservicecommandes.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    // Charger dynamiquement la valeur de la propriété personnalisée
    @Value("${mes-config-ms.commandes-last}")
    private int commandesLast;

    // Endpoint pour récupérer toutes les commandes
    @GetMapping
    public List<Commande> getAllCommandes() {
        List<Commande> commandes = commandeService.getAllCommandes();
        System.out.println("Commandes récupérées : " + commandes); 
        return commandes;
    }

    // Endpoint pour récupérer les commandes récentes
    @GetMapping("/recentes")
    public List<Commande> getCommandesRecentes() {
        List<Commande> commandes = commandeService.getCommandesDansLesDerniersJours(commandesLast);
        System.out.println("Commandes des " + commandesLast + " derniers jours : " + commandes);
        return commandes;
    }
    @GetMapping("/recentes/{jours}")
    public List<Commande> getCommandesDansLesDerniersJours(@PathVariable int jours) {
        if (jours <= 0) {
            throw new IllegalArgumentException("Le nombre de jours doit être supérieur à 0.");
        }
        return commandeService.getCommandesDansLesDerniersJours(jours);
    }



    // Endpoint pour créer une commande
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Commande createCommande(@RequestBody Commande commande) {
        if (commande == null || commande.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Description de la commande est obligatoire.");
        }
        return commandeService.createCommande(commande);
    }
}
