package Microservices.Voyage_service.dto;

import java.util.List;

public class PlanificationRequestDTO {
    private VoyageDTO voyage;
    private List<EtapeDTO> etapes;

    public VoyageDTO getVoyage() {
        return voyage;
    }

    public void setVoyage(VoyageDTO voyage) {
        this.voyage = voyage;
    }

    public List<EtapeDTO> getEtapes() {
        return etapes;
    }

    public void setEtapes(List<EtapeDTO> etapes) {
        this.etapes = etapes;
    }
}
