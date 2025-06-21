package Microservices.Voyage_service.model;

import java.time.LocalTime;

public class ActivitePlanifieeDTO {
	private Long id;
    private int pointInteretId;
    private int activiteId;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private StatutActivite statut;
    private String notePersonnelle;
    private Long etapeId;

    public ActivitePlanifieeDTO() {}

    public ActivitePlanifieeDTO(Long id, int pointInteretId, int activiteId, LocalTime heureDebut, LocalTime heureFin,
                                StatutActivite statut, String notePersonnelle, Long etapeId) {
        this.id = id;
        this.pointInteretId = pointInteretId;
        this.activiteId = activiteId;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.statut = statut;
        this.notePersonnelle = notePersonnelle;
        this.etapeId = etapeId;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public StatutActivite getStatut() {
		return statut;
	}

	public void setStatut(StatutActivite statut) {
		this.statut = statut;
	}

	public String getNotePersonnelle() {
		return notePersonnelle;
	}

	public void setNotePersonnelle(String notePersonnelle) {
		this.notePersonnelle = notePersonnelle;
	}

	public Long getEtapeId() {
		return etapeId;
	}

	public void setEtapeId(Long etapeId) {
		this.etapeId = etapeId;
	}

}
