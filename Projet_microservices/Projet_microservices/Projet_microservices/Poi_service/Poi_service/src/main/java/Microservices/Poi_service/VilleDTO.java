package Microservices.Poi_service;


public class VilleDTO {
	private int id;
    private String nom;
    private double latitude;
    private double longitude;

    public VilleDTO() {}

    public VilleDTO(int id,String nom, double latitude, double longitude) {
    	this.setId(id);
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

