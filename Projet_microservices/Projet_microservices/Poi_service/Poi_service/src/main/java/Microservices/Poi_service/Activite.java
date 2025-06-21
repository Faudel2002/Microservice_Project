package Microservices.Poi_service;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "activites")
public class Activite {

    @Id
    private Integer id;
    private String nomActivite;
    private Map<String, Object> description;
    private int duree;
    private double prix;
    private List<String> moisDisponibles;
    private Integer pointInteretId;

    
    public Activite() {}

    public Activite(Integer id, String nomActivite, Map<String, Object> description, int duree, double prix, List<String> moisDisponibles, Integer pointInteretId) {
        this.id = id;
        this.nomActivite = nomActivite;
        this.description = description;
        this.duree = duree;
        this.prix = prix;
        this.moisDisponibles = moisDisponibles;
        this.pointInteretId = pointInteretId;
    }

    // Getters et Setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNomActivite() { return nomActivite; }
    public void setNomActivite(String nomActivite) { this.nomActivite = nomActivite; }

    public Map<String, Object> getDescription() { return description; }
    public void setDescription(Map<String, Object> description) { this.description = description; }

    public int getDuree() { return duree; }
    public void setDuree(int duree) { if (duree > 0) this.duree = duree; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { if (prix >= 0.0) this.prix = prix; }

    public List<String> getMoisDisponibles() { return moisDisponibles; }
    public void setMoisDisponibles(List<String> moisDisponibles) { this.moisDisponibles = moisDisponibles; }

    public Integer getPointInteretId() { return pointInteretId; }
    public void setPointInteretId(Integer pointInteretId) { this.pointInteretId = pointInteretId; }

    @Override
    public String toString() {
        return "Activite{" +
                "id=" + id +
                ", nomActivite='" + nomActivite + '\'' +
                ", description=" + description +
                ", duree=" + duree +
                ", prix=" + prix +
                ", moisDisponibles=" + moisDisponibles +
                ", pointInteretId=" + pointInteretId +
                '}';
    }
}
