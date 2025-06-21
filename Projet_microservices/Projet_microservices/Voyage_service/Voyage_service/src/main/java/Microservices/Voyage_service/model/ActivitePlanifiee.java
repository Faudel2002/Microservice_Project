
package Microservices.Voyage_service.model;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
public class ActivitePlanifiee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int pointInteretId;
    private int activiteId;

    private LocalTime heureDebut;
    private LocalTime heureFin;

    @Enumerated(EnumType.STRING)
    private StatutActivite statut;

    private String notePersonnelle;

    @ManyToOne
    @JoinColumn(name = "etape_id", nullable = false)
    private Etape etape;

    public ActivitePlanifiee() {}

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getPointInteretId() { return pointInteretId; }
    public void setPointInteretId(int pointInteretId) { this.pointInteretId = pointInteretId; }

    public int getActiviteId() { return activiteId; }
    public void setActiviteId(int activiteId) { this.activiteId = activiteId; }

    public LocalTime getHeureDebut() { return heureDebut; }
    public void setHeureDebut(LocalTime heureDebut) { this.heureDebut = heureDebut; }

    public LocalTime getHeureFin() { return heureFin; }
    public void setHeureFin(LocalTime heureFin) { this.heureFin = heureFin; }

    public StatutActivite getStatut() { return statut; }
    public void setStatut(StatutActivite statut) { this.statut = statut; }

    public String getNotePersonnelle() { return notePersonnelle; }
    public void setNotePersonnelle(String notePersonnelle) { this.notePersonnelle = notePersonnelle; }

    public Etape getEtape() { return etape; }
    public void setEtape(Etape etape) { this.etape = etape; }
}
