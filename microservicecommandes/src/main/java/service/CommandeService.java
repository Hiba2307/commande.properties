package service;

import model.Commande;					
import repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import lombok.Value;

import java.util.List;
import java.time.LocalDate;

@RefreshScope
@Service
public class CommandeService {

    @Autowired
    public CommandeRepository commandeRepository;
    private CommandeConfig commandeConfig;

    // Obtenir toutes les commandes
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    // Créer une commande
    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    // Obtenir les commandes des derniers 'n' jours
    public List<Commande> getCommandesDerniersJours(int jours) {
        LocalDate dateLimite = LocalDate.now().minusDays(jours);
        return commandeRepository.findAll()
                .stream()
                .filter(commande -> commande.getDate().isAfter(dateLimite))
                .toList();
    }
}