package com.example.microservicecommandes.health;

import com.example.microservicecommandes.repository.CommandeRepository;	
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("commande") // Indicateur de santé personnalisé
public class CommandeHealthIndicator implements HealthIndicator {

    private final CommandeRepository commandeRepository;

    public CommandeHealthIndicator(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public Health health() {
        long count = commandeRepository.count(); // Vérifie si des commandes existent
        if (count > 0) {
            return Health.up().build(); // Statut UP
        } else {
            return Health.down().build(); // Statut DOWN
        }
    }
}
