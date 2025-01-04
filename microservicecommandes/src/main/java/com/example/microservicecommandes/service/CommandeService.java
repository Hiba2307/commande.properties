package com.example.microservicecommandes.service;

import com.example.microservicecommandes.model.Commande;					
import com.example.microservicecommandes.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public List<Commande> getAllCommandes() {
        List<Commande> commandes = commandeRepository.findAll();
        System.out.println("Commandes: " + commandes); // Ajoutez cette ligne pour déboguer
        return commandes;
    }

    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }
}