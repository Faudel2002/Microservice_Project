package Microservices.Voyage_service.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Etape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int jourNumero;
    private int villeId;
    private LocalDate dateArrivee;
    private LocalDate dateDepart;

    @ManyToOne
    @JoinColumn(name = "voyage_id", nullable = false)
    private Voyage voyage;

    @ManyToOne
    @JoinColumn(name = "hebergement_id")
    private Hebergement hebergement;

    public Etape() {}

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getJourNumero() { return jourNumero; }
    public void setJourNumero(int jourNumero) { this.jourNumero = jourNumero; }

    public int getVilleId() { return villeId; }
    public void setVilleId(int villeId) { this.villeId = villeId; }

    public LocalDate getDateArrivee() { return dateArrivee; }
    public void setDateArrivee(LocalDate dateArrivee) { this.dateArrivee = dateArrivee; }

    public LocalDate getDateDepart() { return dateDepart; }
    public void setDateDepart(LocalDate dateDepart) { this.dateDepart = dateDepart; }

    public Voyage getVoyage() { return voyage; }
    public void setVoyage(Voyage voyage) { this.voyage = voyage; }

    public Hebergement getHebergement() { return hebergement; }
    public void setHebergement(Hebergement hebergement) { this.hebergement = hebergement; }
}
