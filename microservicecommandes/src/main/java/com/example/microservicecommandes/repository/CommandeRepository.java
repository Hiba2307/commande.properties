package com.example.microservicecommandes.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.microservicecommandes.model.Commande;
import com.example.microservicecommandes.projections.CommandeDto;

@RepositoryRestResource(path = "commandes", excerptProjection = CommandeDto.class)
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    List<Commande> findByDateAfter(@Param("date") LocalDate date);
}
