package Microservices.Voyage_service.dto;

import java.time.LocalTime;

public class ActivitePlanifieeInputDTO {
    private int pointInteretId;
    private int activiteId;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private String statut;  // (string pour simplifier l'entrée JSON)
    private String notePersonnelle;
	public int getPointInteretId() {
		return pointInteretId;
	}
	public void setPointInteretId(int pointInteretId) {
		this.pointInteretId = pointInteretId;
	}
	public int getActiviteId() {
		return activiteId;
	}
	public void setActiviteId(int activiteId) {
		this.activiteId = activiteId;
	}
	public LocalTime getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(LocalTime heureDebut) {
		this.heureDebut = heureDebut;
	}
	public LocalTime getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(LocalTime heureFin) {
		this.heureFin = heureFin;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getNotePersonnelle() {
		return notePersonnelle;
	}
	public void setNotePersonnelle(String notePersonnelle) {
		this.notePersonnelle = notePersonnelle;
	}

    // Getters & setters
}
