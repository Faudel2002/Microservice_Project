package Microservices.Poi_service;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "avis")
public class Avis {
    @Id
    private String id;
    private int note; 
    private String commentaire;
    private Date dateAvis;
    private String auteur;
    private String pointInteretId; 

    // Constructeurs
    public Avis() {
    }

    public Avis(String id, int note, String commentaire, Date date, String auteur, String pointInteretId) {
    	if(note >=1 && note<=5) {
    		this.id = id;
            this.note = note;
            this.commentaire = commentaire;
            this.dateAvis = date;
            this.auteur = auteur;
            this.pointInteretId = pointInteretId;
    	}
        
    }

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
    	if(note >=1 && note<=5) {
    		this.note = note;
    	}
        
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Date getDate() {
        return dateAvis;
    }

    public void setDate(Date date) {
        this.dateAvis = date;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getPointInteretId() {
        return pointInteretId;
    }

    public void setPointInteretId(String pointInteretId) {
        this.pointInteretId = pointInteretId;
    }

    @Override
    public String toString() {
        return "Avis{" +
                "id='" + id + '\'' +
                ", note=" + note +
                ", commentaire='" + commentaire + '\'' +
                ", date=" + dateAvis +
                ", auteur='" + auteur + '\'' +
                ", pointInteretId='" + pointInteretId + '\'' +
                '}';
    }
}

