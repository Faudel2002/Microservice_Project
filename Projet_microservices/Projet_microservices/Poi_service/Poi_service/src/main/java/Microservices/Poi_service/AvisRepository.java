package Microservices.Poi_service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvisRepository extends MongoRepository<Avis, String> {

    // Rechercher tous les avis d'un point d'intérêt
    List<Avis> findByPointInteretId(int pointInteretId);
}
