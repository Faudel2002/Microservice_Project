package Microservices.Ville_service;

public class DistanceAndTimeDTO {
    private Double distance;
    private Integer tempsTrajet;

    public DistanceAndTimeDTO(Double distance, Integer tempsTrajet) {
        this.distance = distance;
        this.tempsTrajet = tempsTrajet;
    }

    public Double getDistance() { return distance; }
    public Integer getTempsTrajet() { return tempsTrajet; }
}

