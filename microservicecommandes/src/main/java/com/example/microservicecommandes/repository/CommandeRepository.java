package com.example.microservicecommandes.repository;



import com.example.microservicecommandes.model.Commande;	
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}