package com.example.microservicecommandes.controller;

import com.example.microservicecommandes.model.Commande;
import com.example.microservicecommandes.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RefreshScope
public class RecentCommandesController {

    @Autowired
    private CommandeRepository commandeRepository;

    // Injecter la propriété personnalisée
    @Value("${mes-config-ms.commandes-last}")
    private int commandesLastDays;

    @GetMapping("/recentes")
    public String recentCommandes(Model model) {
        try {
            // Utiliser la propriété pour définir le nombre de jours
            LocalDate dateLimite = LocalDate.now().minusDays(commandesLastDays);
            List<Commande> commandesRecentes = commandeRepository.findByDateAfter(dateLimite);

            System.out.println("Commandes récentes récupérées : " + commandesRecentes); // Debug
            model.addAttribute("commandes", commandesRecentes);
            return "recentes"; // Nom de la vue
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            e.printStackTrace();
            return "error"; // Redirection en cas d'erreur
        }
    }
}
