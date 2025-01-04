package controller;

import model.Commande;	
import service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

	 @Autowired
	    public CommandeService commandeService;

	    @GetMapping
	    public List<Commande> getAllCommandes() {
	        return commandeService.getAllCommandes();
	    }

	    @PostMapping
	    public Commande createCommande(@RequestBody Commande commande) {
	        return commandeService.createCommande(commande);
	    }

	    @GetMapping("/derniers/{jours}")
	    public List<Commande> getCommandesDerniersJours(@PathVariable int jours) {
	        return commandeService.getCommandesDerniersJours(jours);
	    }
	}