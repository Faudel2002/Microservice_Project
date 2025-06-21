package Microservices.Voyage_service.controller;

import Microservices.Voyage_service.model.Etape;
import Microservices.Voyage_service.model.PointInteretDTO;
import Microservices.Voyage_service.service.EtapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etapes")
public class EtapeController {

    @Autowired
    private EtapeService etapeService;

    @GetMapping
    public List<Etape> getAllEtapes() {
        return etapeService.getAllEtapes();
    }

    @GetMapping("/{id}")
    public Etape getEtapeById(@PathVariable Long id) {
        return etapeService.getEtapeById(id);
    }

    @GetMapping("/voyage/{voyageId}")
    public List<Etape> getEtapesByVoyage(@PathVariable Long voyageId) {
        return etapeService.getEtapesByVoyageId(voyageId);
    }

    @PostMapping
    public Etape createEtape(@RequestBody Etape etape) {
        return etapeService.createEtape(etape);
    }

    @DeleteMapping("/{id}")
    public void deleteEtape(@PathVariable Long id) {
        etapeService.deleteEtape(id);
    }
    
    @GetMapping("/{id}/pois")
    public List<PointInteretDTO> getPOIsForEtape(@PathVariable Long id) {
        return etapeService.getPOIsByEtapeId(id);
    }

}
