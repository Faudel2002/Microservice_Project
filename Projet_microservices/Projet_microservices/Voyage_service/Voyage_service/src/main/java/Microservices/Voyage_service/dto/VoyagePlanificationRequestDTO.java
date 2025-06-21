package Microservices.Voyage_service.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class VoyagePlanificationRequestDTO {
    private String titre;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private BigDecimal budget;
    private String createur;
    private int nbPersonnes;
    private String description;
    private List<EtapeDTO> etapes;

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
    public int getNbPersonnes() { return nbPersonnes; }
    public void setNbPersonnes(int nbPersonnes) { this.nbPersonnes = nbPersonnes; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<EtapeDTO> getEtapes() { return etapes; }
    public void setEtapes(List<EtapeDTO> etapes) { this.etapes = etapes; }
}
