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
    private CommandeConfig commandeConfig;  // Injection de CommandeConfig au lieu de @Value

    @Autowired
    private CommandeRepository commandeRepository;

    @PostConstruct
    public void init() {
        System.out.println("CommandesLast property: " + commandeConfig.getCommandesLast());
    }

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    public List<Commande> getCommandesRecentes() {
        LocalDate dateLimite = LocalDate.now().minusDays(commandeConfig.getCommandesLast());
        return commandeRepository.findByDateAfter(dateLimite);
    }

    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }
}