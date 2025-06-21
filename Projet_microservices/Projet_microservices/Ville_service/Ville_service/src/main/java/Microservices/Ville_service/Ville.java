package Microservices.Ville_service;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Node("Ville")
public class Ville {

    @Id
    private Integer id;
    
    @Property("nomVille")
    private String nom;
    private double latitude;
    private double longitude;
    
    
    

    @Relationship(type = "SE_SITUE_A", direction = Relationship.Direction.OUTGOING)
    @JsonIgnore
    private List<Distance> villesConnectees;

    public Ville() {
        this.villesConnectees = new ArrayList<>();
    }

    public Ville(int id, String nom, double latitude, double longitude) {
        this.id = id;
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
        this.villesConnectees = new ArrayList<>();
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public List<Distance> getVillesConnectees() {
        return villesConnectees;
    }

    public void setVillesConnectees(List<Distance> villesConnectees) {
        this.villesConnectees = villesConnectees;
    }

	
}