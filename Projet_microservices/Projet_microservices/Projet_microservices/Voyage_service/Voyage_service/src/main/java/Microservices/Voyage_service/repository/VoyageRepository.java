package Microservices.Voyage_service.repository;

import Microservices.Voyage_service.model.Voyage;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoyageRepository extends JpaRepository<Voyage, Long> {
	Optional<Voyage> findById(Long id);
	boolean existsById(Long id);

}
