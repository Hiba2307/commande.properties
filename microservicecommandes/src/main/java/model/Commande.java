package model;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity 
@Table(name = "commande") 
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private int quantite;
   private LocalDate date;
    private double montant;
    
    public LocalDate getDate() {
        return date; // Return the LocalDate value
    }
    

}
