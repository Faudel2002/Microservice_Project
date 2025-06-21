package Microservices.Voyage_service.service;

import Microservices.Voyage_service.model.ActivitePlanifiee;
import Microservices.Voyage_service.model.Etape;
import Microservices.Voyage_service.model.PointInteretDTO;
import Microservices.Voyage_service.repository.ActivitePlanifieeRepository;
import Microservices.Voyage_service.repository.EtapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class EtapeService {

    @Autowired
    private EtapeRepository etapeRepository;
    
    @Autowired
    private ActivitePlanifieeRepository activitePlanifieeRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<PointInteretDTO> getPOIsByEtapeId(Long etapeId) {
        List<ActivitePlanifiee> activites = activitePlanifieeRepository.findByEtapeId(etapeId);
        List<PointInteretDTO> pois = new ArrayList<>();

        for (ActivitePlanifiee activite : activites) {
            int poiId = activite.getPointInteretId();
            PointInteretDTO poi = restTemplate.getForObject(
                "http://localhost:8001/api/points-interet/" + poiId, PointInteretDTO.class);
            pois.add(poi);
        }

        return pois;
    }

    public List<Etape> getAllEtapes() {
        return etapeRepository.findAll();
    }

    public Etape getEtapeById(Long id) {
        return etapeRepository.findById(id).orElse(null);
    }

    public Etape createEtape(Etape etape) {
        return etapeRepository.save(etape);
    }

    public void deleteEtape(Long id) {
        etapeRepository.deleteById(id);
    }

    public List<Etape> getEtapesByVoyageId(Long voyageId) {
        return etapeRepository.findByVoyageId(voyageId);
    }
}
