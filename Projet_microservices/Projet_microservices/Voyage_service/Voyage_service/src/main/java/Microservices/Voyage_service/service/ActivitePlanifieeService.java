package Microservices.Voyage_service.service;

import Microservices.Voyage_service.model.ActivitePlanifiee;
import Microservices.Voyage_service.model.ActivitePlanifieeDTO;
import Microservices.Voyage_service.repository.ActivitePlanifieeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivitePlanifieeService {

    @Autowired
    private ActivitePlanifieeRepository activitePlanifieeRepository;
    

    public List<ActivitePlanifiee> getAllActivitesPlanifiees() {
        return activitePlanifieeRepository.findAll();
    }

    public Optional<ActivitePlanifiee> getActivitePlanifieeById(Long id) {
        return activitePlanifieeRepository.findById(id);
    }

    public ActivitePlanifiee createActivitePlanifiee(ActivitePlanifiee activite) {
        return activitePlanifieeRepository.save(activite);
    }

    public void deleteActivitePlanifiee(Long id) {
        activitePlanifieeRepository.deleteById(id);
    }
    
    public List<ActivitePlanifiee> getActivitesByVoyageId(Long voyageId) {
        return activitePlanifieeRepository.findByVoyageId(voyageId);
    }
    
    public List<ActivitePlanifieeDTO> getActivitesDTOByVoyageId(Long voyageId) {
        List<ActivitePlanifiee> activites = activitePlanifieeRepository.findByVoyageId(voyageId);
        return activites.stream().map(a -> new ActivitePlanifieeDTO(
            a.getId(),
            a.getPointInteretId(),
            a.getActiviteId(),
            a.getHeureDebut(),
            a.getHeureFin(),
            a.getStatut(),
            a.getNotePersonnelle(),
            a.getEtape() != null ? a.getEtape().getId() : null
        )).toList();
    }
    


}
