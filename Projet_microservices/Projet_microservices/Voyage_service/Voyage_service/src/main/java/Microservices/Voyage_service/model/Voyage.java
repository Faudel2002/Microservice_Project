package Microservices.Voyage_service.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private BigDecimal budget;
    private String createur;
    private Integer nbPersonnes;
    private String description;

    public Voyage() {}

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public LocalDate getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }

    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }

    public BigDecimal getBudget() { return budget; }
    public void setBudget(BigDecimal budget) { this.budget = budget; }

    public String getCreateur() { return createur; }
    public void setCreateur(String createur) { this.createur = createur; }

    public Integer getNbPersonnes() { return nbPersonnes; }
    public void setNbPersonnes(Integer nbPersonnes) { this.nbPersonnes = nbPersonnes; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
