package service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Configuration
@RefreshScope
public class CommandeConfig {

    @Value("${mes-config-ms.commandes-last}")
    private int commandesLast;

    // Getter
    public int getCommandesLast() {
        return commandesLast;
    }

    // You can add additional methods or properties as needed.
}
