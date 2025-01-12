package com.example.microservicecommandes.model;

import jakarta.persistence.*;	
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "commande")
public class Commande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private int quantite;
    private LocalDate date;
    private double montant;

    // Constructeur sans arguments
    public Commande() {
    }

    // Constructeur avec arguments
    public Commande(String description, int quantite, LocalDate date, double montant) {
        this.description = description;
        this.quantite = quantite;
        this.date = date;
        this.montant = montant;
    }

    // Getter et setter pour id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter et setter pour description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter et setter pour quantite
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    // Getter et setter pour date
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Getter et setter pour montant
    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
