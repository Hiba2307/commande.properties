package com.example.microservicecommandes.service;

import com.example.microservicecommandes.model.Commande;
import com.example.microservicecommandes.repository.CommandeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@RefreshScope
@Service
public class CommandeService {

    @Autowired
    private CommandeConfig commandeConfig; // Injection de CommandeConfig

    @Autowired
    private CommandeRepository commandeRepository;

    @PostConstruct
    public void init() {
        System.out.println("CommandesLast property: " + commandeConfig.getCommandesLast());

        // Ajout de données de test si la base est vide
        if (commandeRepository.count() == 0) {
            commandeRepository.save(new Commande("Commande A", 10, LocalDate.now().minusDays(5), 500.0));
            commandeRepository.save(new Commande("Commande B", 5, LocalDate.now().minusDays(3), 250.0));
            commandeRepository.save(new Commande("Commande C", 20, LocalDate.now().minusDays(1), 1000.0));
            System.out.println("Données de test ajoutées.");
        }
    }

    public List<Commande> getAllCommandes() {
        List<Commande> commandes = commandeRepository.findAll();
        System.out.println("Commandes récupérées : " + commandes);
        return commandes;
    }

    public List<Commande> getCommandesDansLesDerniersJours(int jours) {
        if (jours <= 0) {
            throw new IllegalArgumentException("Le nombre de jours doit être supérieur à 0.");
        }
        LocalDate dateLimite = LocalDate.now().minusDays(jours);
        List<Commande> commandes = commandeRepository.findByDateAfter(dateLimite);
        System.out.println("Commandes des " + jours + " derniers jours : " + commandes);
        return commandes;
    }

    public List<Commande> getCommandesRecentes() {
        LocalDate dateLimite = LocalDate.now().minusDays(commandeConfig.getCommandesLast());
        List<Commande> commandes = commandeRepository.findByDateAfter(dateLimite);
        System.out.println("Commandes récentes récupérées : " + commandes);
        return commandes;
    }

    public Commande createCommande(Commande commande) {
        if (commande == null || commande.getDescription() == null || commande.getDescription().isEmpty()) {
            throw new IllegalArgumentException("La description de la commande est obligatoire.");
        }
        Commande savedCommande = commandeRepository.save(commande);
        System.out.println("Commande créée : " + savedCommande);
        return savedCommande;
    }
}
