package Microservices.Poi_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/points-interet")
public class PointInteretController {

    @Autowired
    private PointInteretService pointInteretService;

    // Ajouter un nouveau point d'intérêt
    @PostMapping
    public PointInteret addPointInteret(@RequestBody PointInteret pointInteret) {
        return pointInteretService.addPointInteret(pointInteret);
    }

    // Mettre à jour un point d'intérêt
    @PutMapping("/{id}")
    public PointInteret updatePointInteret(@PathVariable int id, @RequestBody PointInteret pointInteret) {
        return pointInteretService.updatePointInteret(id, pointInteret);
    }

 // Supprimer un point d'intérêt
    @DeleteMapping("/{id}")
    public void deletePointInteret(@PathVariable int id) {
        pointInteretService.deletePointInteret(id);
    }

    
 // Récupérer tous les points d'intérêt
    @GetMapping
    public List<PointInteret> getAllPointsInteret() {
        return pointInteretService.getAllPointsInteret();
    }
    
 // Récupérer un point d'intérêt par ID
    @GetMapping("/{id}")
    public PointInteret getPointInteretById(@PathVariable int id) {
        return pointInteretService.getPointInteretById(id);
    }
    
    // Rechercher les points d'intérêt par type (ex: MUSEE, MONUMENT, PARC)
    @GetMapping("/type")
    public List<PointInteret> getPointsInteretByType(@RequestParam String type) {
        return pointInteretService.getPointsInteretByType(type);
    }
    
    @GetMapping("/{id}/activites")
    public List<Activite> getActivitesByPointInteret(@PathVariable int id) {
        return pointInteretService.getActivitesByPointInteret(id);
    }

    // Récupérer tous les avis d'un point d'intérêt
    @GetMapping("/{id}/avis")
    public List<Avis> getAvisByPointInteret(@PathVariable int id) {
        return pointInteretService.getAvisByPointInteret(id);
    }
    
    @GetMapping("/nearby/from-poi")
    public List<PointInteret> getNearbyFromPOIName(@RequestParam String nomPOI, @RequestParam double rayonKm) {
        return pointInteretService.getNearbyFromPOIName(nomPOI, rayonKm);
    }
    
    @GetMapping("/ville/noms-activites")
    public List<PointInteretWithActiviteNamesDTO> getPoisEtNomActivites(
            @RequestParam String nomVille,
            @RequestParam(defaultValue = "10") double rayonKm) {
        return pointInteretService.getPoisEtNomActivitesParVille(nomVille, rayonKm);
    }
    
    
}
