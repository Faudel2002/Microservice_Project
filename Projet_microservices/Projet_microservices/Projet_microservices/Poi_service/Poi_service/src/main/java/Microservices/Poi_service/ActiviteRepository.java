package Microservices.Poi_service;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActiviteRepository extends MongoRepository<Activite, String> {

    // Rechercher toutes les activités d'un point d'intérêt
    List<Activite> findByPointInteretId(int pointInteretId);
    
    List<Activite> findByMoisDisponiblesIn(List<String> mois);
}