package Microservices.Voyage_service.controller;

import Microservices.Voyage_service.model.Hebergement;
import Microservices.Voyage_service.model.HebergementParVilleDTO;
import Microservices.Voyage_service.repository.HebergementRepository;
import Microservices.Voyage_service.service.HebergementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/hebergements")
public class HebergementController {

    @Autowired
    private HebergementService hebergementService;
    private final HebergementRepository hebergementRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public HebergementController(HebergementRepository hebergementRepository, RestTemplate restTemplate) {
        this.hebergementRepository = hebergementRepository;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/ville/{nom}")
    public ResponseEntity<HebergementParVilleDTO> getHebergementsParVille(@PathVariable String nom) {
        // Appel à Ville_service pour récupérer l'ID
        Integer villeId = restTemplate.getForObject(
            "http://localhost:8002/api/villes/nom/" + nom, Integer.class);

        if (villeId == null) {
            return ResponseEntity.notFound().build();
        }

        // Récupérer les hébergements liés à cet ID
        List<Hebergement> hebergements = hebergementRepository.findByVilleId(villeId);
        HebergementParVilleDTO dto = new HebergementParVilleDTO(nom, hebergements);

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public List<Hebergement> getAllHebergements() {
        return hebergementService.getAllHebergements();
    }

    @GetMapping("/{id}")
    public Hebergement getHebergementById(@PathVariable Long id) {
        return hebergementService.getHebergementById(id).orElse(null);
    }

    @PostMapping
    public Hebergement createHebergement(@RequestBody Hebergement hebergement) {
        return hebergementService.createHebergement(hebergement);
    }

    @PutMapping("/{id}")
    public Hebergement updateHebergement(@PathVariable Long id, @RequestBody Hebergement updatedHebergement) {
        return hebergementService.updateHebergement(id, updatedHebergement);
    }

    @DeleteMapping("/{id}")
    public void deleteHebergement(@PathVariable Long id) {
        hebergementService.deleteHebergement(id);
    }
}
