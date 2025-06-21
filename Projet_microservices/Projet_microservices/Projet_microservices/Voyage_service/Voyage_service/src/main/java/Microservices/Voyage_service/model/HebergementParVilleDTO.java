package Microservices.Voyage_service.model;

import java.util.List;

public class HebergementParVilleDTO {
    private String nomVille;
    private List<Hebergement> hebergements;

    public HebergementParVilleDTO(String nomVille, List<Hebergement> hebergements) {
        this.nomVille = nomVille;
        this.hebergements = hebergements;
    }

    public String getNomVille() { return nomVille; }
    public List<Hebergement> getHebergements() { return hebergements; }
}
