package com.example.microservicecommandes.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandeConfig {

    @Value("${mes-config-ms.commandes-last}")
    private int commandesLast;

    public int getCommandesLast() {
        return commandesLast;
    }
}