package Microservices.Poi_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PointInteretService {

    @Autowired
    private PointInteretRepository pointInteretRepository;
    
    @Autowired
    private ActiviteRepository activiteRepository;

    @Autowired
    private AvisRepository avisRepository;
    
    private final RestTemplate restTemplate = new RestTemplate();
    
    // Récupérer toutes les activités d'un point d'intérêt
    public List<Activite> getActivitesByPointInteret(int pointInteretId) {
        return activiteRepository.findByPointInteretId(pointInteretId);
    }

    // Récupérer tous les avis d'un point d'intérêt
    public List<Avis> getAvisByPointInteret(int pointInteretId) {
        return avisRepository.findByPointInteretId(pointInteretId);
    }

    // Récupérer tous les points d'intérêt
    public List<PointInteret> getAllPointsInteret() {
        return pointInteretRepository.findAll();
    }

    // Récupérer un point d'intérêt par ID
    public PointInteret getPointInteretById(int id) {
        return pointInteretRepository.findById(id).orElse(null);
    }
    

    // Ajouter un nouveau point d'intérêt
    public PointInteret addPointInteret(PointInteret pointInteret) {
        return pointInteretRepository.save(pointInteret);
    }

    // Mettre à jour un point d'intérêt
    public PointInteret updatePointInteret(int id, PointInteret updatedPointInteret) {
        PointInteret pointInteret = getPointInteretById(id);
        if (pointInteret != null) {
            updatedPointInteret.setId(id);
            return pointInteretRepository.save(updatedPointInteret);
        }
        return null;
    }

    // Supprimer un point d'intérêt
    public void deletePointInteret(int id) {
        pointInteretRepository.deleteById(id);
    }

    // Récupérer les points d'intérêt par type
    public List<PointInteret> getPointsInteretByType(String type) {
        return pointInteretRepository.findByType(type);
    }

    // Rechercher les points d'intérêt proches (rayon défini par les coordonnées)
    public List<PointInteret> getNearbyPoints(double latitude, double longitude, double range) {
        double rangeInDegrees = range / 111.0; // 1 degré ≈ 111 km
        return pointInteretRepository.findByLatitudeBetweenAndLongitudeBetween(
                latitude - rangeInDegrees, latitude + rangeInDegrees,
                longitude - rangeInDegrees, longitude + rangeInDegrees
        );
    }
    
    public List<PointInteret> getNearbyFromPOIName(String nomPOI, double rayonKm) {
        PointInteret pointRef = pointInteretRepository.findByNomPOI(nomPOI)
            .orElseThrow(() -> new RuntimeException("POI non trouvé"));

        return getNearbyPoints(pointRef.getLatitude(), pointRef.getLongitude(), rayonKm);
    }
    
    public VilleDTO getVilleByNom(String nomVille) {
        //String url = "http://localhost:8002/api/villes/nom/" + nomVille;
        VilleDTO ville = restTemplate.getForObject("http://localhost:8002/api/villes/nom?nom=" + nomVille, VilleDTO.class);

        return ville;
    }
    
    public List<PointInteretWithActiviteNamesDTO> getPoisEtNomActivitesParVille(String nomVille, double rayonKm) {
        VilleDTO ville = getVilleByNom(nomVille);
        List<PointInteret> pois = getNearbyPoints(ville.getLatitude(), ville.getLongitude(), rayonKm);

        return pois.stream().map(poi -> {
            List<String> nomsActivites = getActivitesByPointInteret(poi.getId()).stream()
                .map(Activite::getNomActivite)
                .collect(Collectors.toList());

            return new PointInteretWithActiviteNamesDTO(poi, nomsActivites);
        }).toList();
    }
    

    
    

}
