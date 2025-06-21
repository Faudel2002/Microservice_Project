package Microservices.Poi_service;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "pointsInteret")
public class PointInteret {
    @Id
    private int id;
    private String nomPOI;
    private String type;  // ex: MUSEE, MONUMENT, PARC
    private String description;
    private double latitude;
    private double longitude;
    private List<String> activitesIds;  // Liste des IDs d'activités associées
    private List<String> avisIds;      // Liste des IDs d'avis associés

    // Constructeurs
    public PointInteret() {
    }

    public PointInteret(int id, String nom, String type, String description, double latitude, double longitude, List<String> activiteIds, List<String> avisIds) {
        this.id = id;
        this.nomPOI = nom;
        this.type = type;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.activitesIds = activiteIds;
        this.avisIds = avisIds;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nomPOI;
    }

    public void setNom(String nom) {
        this.nomPOI = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<String> getActiviteIds() {
        return activitesIds;
    }

    public void setActiviteIds(List<String> activiteIds) {
        this.activitesIds = activiteIds;
    }

    public List<String> getAvisIds() {
        return avisIds;
    }

    public void setAvisIds(List<String> avisIds) {
        this.avisIds = avisIds;
    }

    @Override
    public String toString() {
        return "PointInteret{" +
                "id='" + id + '\'' +
                ", nom='" + nomPOI + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", activiteIds=" + activitesIds +
                ", avisIds=" + avisIds +
                '}';
    }
}

