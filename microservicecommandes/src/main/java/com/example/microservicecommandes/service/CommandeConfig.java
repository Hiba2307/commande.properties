package com.example.microservicecommandes.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
public class CommandeConfig {
    @Value("${mes-config-ms.commandes-last}")
    private int commandesLast;

    public int getCommandesLast() {
        return commandesLast;
    }
}