package com.example.microservicecommandes.service;

import org.springframework.beans.factory.annotation.Value;	
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@RefreshScope
@Configuration
public class CommandeConfig {

    @Value("${mes-config-ms.commandes-last}")
    private int commandesLast;

    @PostConstruct
    public void logConfig() {
        System.out.println("Chargement de la propriété mes-config-ms.commandes-last : " + commandesLast);
    }

    public int getCommandesLast() {
        return commandesLast;
    }
}
