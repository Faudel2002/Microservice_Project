package Microservices.Poi_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activites")
public class ActiviteController {

    private final ActiviteService activiteService;

    @Autowired
    public ActiviteController(ActiviteService activiteService) {
        this.activiteService = activiteService;
    }

//    @GetMapping("/disponibles")
//    public ResponseEntity<List<Activite>> getActivitesDisponibles(
//        @RequestParam List<String> mois) {
//
//        List<Activite> activites = activiteService.findActivitesDisponiblesParMois(mois);
//        return ResponseEntity.ok(activites);
//    }
    
    @GetMapping("/disponibles/plage")
    public ResponseEntity<List<Activite>> getActivitesParPlage(
            @RequestParam String debut,
            @RequestParam String fin) {

        List<String> plageMois = activiteService.getPlageMois(debut, fin);
        List<Activite> activites = activiteService.findActivitesDisponiblesParMois(plageMois);
        return ResponseEntity.ok(activites);
    }

}

