package Microservices.Poi_service;

import java.util.List;

public class PointInteretWithActiviteNamesDTO {
    private PointInteret pointInteret;
    private List<String> nomsActivites;

    public PointInteretWithActiviteNamesDTO() {}

    public PointInteretWithActiviteNamesDTO(PointInteret pointInteret, List<String> nomsActivites) {
        this.pointInteret = pointInteret;
        this.nomsActivites = nomsActivites;
    }

    public PointInteret getPointInteret() {
        return pointInteret;
    }

    public void setPointInteret(PointInteret pointInteret) {
        this.pointInteret = pointInteret;
    }

    public List<String> getNomsActivites() {
        return nomsActivites;
    }

    public void setNomsActivites(List<String> nomsActivites) {
        this.nomsActivites = nomsActivites;
    }
}
