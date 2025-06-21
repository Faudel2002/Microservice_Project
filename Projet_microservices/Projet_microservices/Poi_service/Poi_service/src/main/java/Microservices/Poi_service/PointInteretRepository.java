package Microservices.Poi_service;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PointInteretRepository extends MongoRepository<PointInteret, Integer> {
    
    // Rechercher les points d'intérêt par type (ex: MUSEE, MONUMENT, PARC)
    List<PointInteret> findByType(String type);
    
    Optional<PointInteret> findByNomPOI(String nomPOI);

    // Rechercher les points d'intérêt par nom (recherche partielle, non sensible à la casse)
    List<PointInteret> findByNomContainingIgnoreCase(String nom);

    // Rechercher les points d'intérêt proches (en utilisant la latitude et la longitude)
    List<PointInteret> findByLatitudeBetweenAndLongitudeBetween(double minLat, double maxLat, double minLon, double maxLon);
    
    
}

