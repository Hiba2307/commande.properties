package com.example.microservicecommandes.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;

@ControllerAdvice // Indique qu'il s'agit d'une gestion des erreurs globales
public class GlobalExceptionHandler {

    // Gestion d'exception générale (toutes les exceptions non gérées)
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // HTTP 500
    public String handleException(Exception e, Model model) {
        model.addAttribute("errorMessage", e.getMessage()); // Ajouter le message d'erreur
        return "error"; // Vue d'erreur (error.html) à afficher
    }

    // Gestion d'une exception spécifique (par exemple, une ressource non trouvée)
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // HTTP 404
    public String handleResourceNotFoundException(ResourceNotFoundException e, Model model) {
        model.addAttribute("errorMessage", "Ressource non trouvée: " + e.getMessage());
        return "error"; // Vue d'erreur
    }

    // Gestion des erreurs spécifiques liées à la validation des données
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // HTTP 400
    public String handleIllegalArgumentException(IllegalArgumentException e, Model model) {
        model.addAttribute("errorMessage", "Erreur de validation: " + e.getMessage());
        return "error"; // Vue d'erreur
    }
}
