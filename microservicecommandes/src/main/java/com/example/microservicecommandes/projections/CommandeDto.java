package com.example.microservicecommandes.projections;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import com.example.microservicecommandes.model.Commande;

@Projection(name = "commandeDTO", types = Commande.class)
public interface CommandeDto {

    Long getId();

    @Value("#{target.description}")
    String getDesc();

    int getQuantite();

    @Value("#{target.montant}")
    double getMontant();

    // Convertir LocalDate en String avec un format ISO
    @Value("#{target.date != null ? target.date.format(T(java.time.format.DateTimeFormatter).ISO_LOCAL_DATE) : null}")
    String getDate();
}
