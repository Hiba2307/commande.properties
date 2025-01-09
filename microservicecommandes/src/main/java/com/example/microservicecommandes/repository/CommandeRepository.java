// File: CommandeRepository.java
package com.example.microservicecommandes.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservicecommandes.model.Commande;



public interface CommandeRepository extends JpaRepository<Commande, Long> {
    List<Commande> findByDateAfter(LocalDate date);
}