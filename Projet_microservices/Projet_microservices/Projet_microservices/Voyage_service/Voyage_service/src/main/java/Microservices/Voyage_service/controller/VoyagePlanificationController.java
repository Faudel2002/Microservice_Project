package Microservices.Voyage_service.controller;

import Microservices.Voyage_service.dto.VoyagePlanificationRequestDTO;
import Microservices.Voyage_service.model.Voyage;
import Microservices.Voyage_service.service.VoyagePlanificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/planification")
public class VoyagePlanificationController {

    @Autowired
    private VoyagePlanificationService planificationService;

    @PostMapping("/voyages")
    public Voyage planifierVoyage(@RequestBody VoyagePlanificationRequestDTO requestDTO) {
        return planificationService.planifierVoyage(requestDTO);
    }
    
    @PutMapping("/voyages/{id}")
    public Voyage updateVoyage(@PathVariable Long id, @RequestBody VoyagePlanificationRequestDTO requestDTO) {
        return planificationService.updateVoyage(id, requestDTO);
    }
    
    @DeleteMapping("/voyages/{id}")
    public void deleteVoyage(@PathVariable Long id) {
        planificationService.deleteVoyage(id);
    }
    
    @GetMapping("/voyages/{id}")
    public Voyage getVoyageById(@PathVariable Long id) {
        return planificationService.getVoyageById(id);
    }

}
