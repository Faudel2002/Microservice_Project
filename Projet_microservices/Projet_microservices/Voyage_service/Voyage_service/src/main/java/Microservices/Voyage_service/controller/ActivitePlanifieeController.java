package Microservices.Voyage_service.controller;

import Microservices.Voyage_service.model.ActivitePlanifiee;
import Microservices.Voyage_service.model.ActivitePlanifieeDTO;
import Microservices.Voyage_service.service.ActivitePlanifieeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/activites-planifiees")
@CrossOrigin
public class ActivitePlanifieeController {

    @Autowired
    private ActivitePlanifieeService activitePlanifieeService;

    @GetMapping
    public List<ActivitePlanifiee> getAllActivitesPlanifiees() {
        return activitePlanifieeService.getAllActivitesPlanifiees();
    }

    @GetMapping("/{id}")
    public Optional<ActivitePlanifiee> getActivitePlanifieeById(@PathVariable Long id) {
        return activitePlanifieeService.getActivitePlanifieeById(id);
    }

    @PostMapping
    public ActivitePlanifiee createActivitePlanifiee(@RequestBody ActivitePlanifiee activite) {
        return activitePlanifieeService.createActivitePlanifiee(activite);
    }

    @DeleteMapping("/{id}")
    public void deleteActivitePlanifiee(@PathVariable Long id) {
        activitePlanifieeService.deleteActivitePlanifiee(id);
    }
    
    @GetMapping("/voyages/{id}/activites")
    public ResponseEntity<List<ActivitePlanifieeDTO>> getActivitesByVoyageId(@PathVariable("id") Long id) {
        List<ActivitePlanifieeDTO> activites = activitePlanifieeService.getActivitesDTOByVoyageId(id);
        return ResponseEntity.ok(activites);
    }

}
