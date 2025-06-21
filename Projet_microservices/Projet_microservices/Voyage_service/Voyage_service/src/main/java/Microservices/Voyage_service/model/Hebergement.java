package Microservices.Voyage_service.model;

import jakarta.persistence.*;

@Entity
public class Hebergement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom_hebergement")
    private String nomHebergement;

    @Column(name = "type_hebergement")
    private String typeHebergement;

    @Column(name = "nb_etoiles")
    private Integer nbEtoiles;

    @Column(name = "prix_nuit")
    private Double prixNuit;

    private Double latitude;
    private Double longitude;

    @Column(name = "ville_id")
    private Integer villeId;

    private String adresse;
    private String description;

    @Column(columnDefinition = "jsonb")
    private String services;

    public Hebergement() {}

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNomHebergement() { return nomHebergement; }
    public void setNomHebergement(String nomHebergement) { this.nomHebergement = nomHebergement; }

    public String getTypeHebergement() { return typeHebergement; }
    public void setTypeHebergement(String typeHebergement) { this.typeHebergement = typeHebergement; }

    public Integer getNbEtoiles() { return nbEtoiles; }
    public void setNbEtoiles(Integer nbEtoiles) { this.nbEtoiles = nbEtoiles; }

    public Double getPrixNuit() { return prixNuit; }
    public void setPrixNuit(Double prixNuit) { this.prixNuit = prixNuit; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public Integer getVilleId() { return villeId; }
    public void setVilleId(Integer villeId) { this.villeId = villeId; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getServices() { return services; }
    public void setServices(String services) { this.services = services; }
}
