package Microservices.Ville_service;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class Distance {

    @Id
    @GeneratedValue
    private String id;
    
    @Property("distance")
    private double kilometres;
    
    @Property("tempsTrajet")
    private int tempsDeTrajet;
    
    @Property("transport")
    private String typeTransport;

    @TargetNode
    private Ville ville;

    public Distance() {}

    public Distance(double kilometres, int tempsDeTrajet, String typeTransport, Ville ville) {
        this.kilometres = kilometres;
        this.tempsDeTrajet = tempsDeTrajet;
        this.typeTransport = typeTransport;
        this.ville = ville;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getKilometres() {
        return kilometres;
    }

    public void setKilometres(double kilometres) {
        this.kilometres = kilometres;
    }

    public int getTempsDeTrajet() {
        return tempsDeTrajet;
    }

    public void setTempsDeTrajet(int tempsDeTrajet) {
        this.tempsDeTrajet = tempsDeTrajet;
    }

    public String getTypeTransport() {
        return typeTransport;
    }

    public void setTypeTransport(String typeTransport) {
        this.typeTransport = typeTransport;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }
}