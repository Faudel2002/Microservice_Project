package Microservices.Voyage_service.repository;

import Microservices.Voyage_service.model.Hebergement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HebergementRepository extends JpaRepository<Hebergement, Long> {
	List<Hebergement> findByVilleId(Integer villeId);

}
