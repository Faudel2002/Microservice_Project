package Microservices.Voyage_service.controller;

import Microservices.Voyage_service.model.Voyage;
import Microservices.Voyage_service.service.VoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/voyages")
@CrossOrigin
public class VoyageController {

    @Autowired
    private VoyageService voyageService;

    @GetMapping
    public List<Voyage> getAllVoyages() {
        return voyageService.getAllVoyages();
    }

    @GetMapping("/{id}")
    public Optional<Voyage> getVoyageById(@PathVariable Long id) {
        return voyageService.getVoyageById(id);
    }

    @PostMapping
    public Voyage createVoyage(@RequestBody Voyage voyage) {
        return voyageService.createVoyage(voyage);
    }

    @PutMapping("/{id}")
    public Voyage updateVoyage(@PathVariable Long id, @RequestBody Voyage updated) {
        return voyageService.updateVoyage(id, updated);
    }

    @DeleteMapping("/{id}")
    public void deleteVoyage(@PathVariable Long id) {
        voyageService.deleteVoyage(id);
    }
}
