package Microservices.Voyage_service.dto;

import java.time.LocalDate;
import java.util.List;

public class EtapeDTO {
    private int jourNumero;
    private int villeId;
    private LocalDate dateArrivee;
    private LocalDate dateDepart;
    private Long hebergementId;
    private List<ActivitePlanifieeInputDTO> activites;

    public int getJourNumero() { return jourNumero; }
    public void setJourNumero(int jourNumero) { this.jourNumero = jourNumero; }
    public int getVilleId() { return villeId; }
    public void setVilleId(int villeId) { this.villeId = villeId; }
    public LocalDate getDateArrivee() { return dateArrivee; }
    public void setDateArrivee(LocalDate dateArrivee) { this.dateArrivee = dateArrivee; }
    public LocalDate getDateDepart() { return dateDepart; }
    public void setDateDepart(LocalDate dateDepart) { this.dateDepart = dateDepart; }
    public Long getHebergementId() { return hebergementId; }
    public void setHebergementId(Long hebergementId) { this.hebergementId = hebergementId; }
    public List<ActivitePlanifieeInputDTO> getActivites() { return activites; }
    public void setActivites(List<ActivitePlanifieeInputDTO> activites) { this.activites = activites; }
}
