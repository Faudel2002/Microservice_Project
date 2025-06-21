package Microservices.Voyage_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Microservices.Voyage_service.model.ActivitePlanifiee;

import java.util.List;

@Repository
public interface ActivitePlanifieeRepository extends JpaRepository<ActivitePlanifiee, Long> {
    List<ActivitePlanifiee> findByEtapeId(Long etapeId);
    
    void deleteByEtapeId(Long etapeId);
    
    @Query("SELECT a FROM ActivitePlanifiee a WHERE a.etape.voyage.id = :voyageId")
    List<ActivitePlanifiee> findByVoyageId(@Param("voyageId") Long voyageId);
    
    
}