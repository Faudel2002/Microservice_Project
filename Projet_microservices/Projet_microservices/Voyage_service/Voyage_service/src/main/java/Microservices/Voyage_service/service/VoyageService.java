package Microservices.Voyage_service.service;

import Microservices.Voyage_service.model.Voyage;
import Microservices.Voyage_service.repository.VoyageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoyageService {

    @Autowired
    private VoyageRepository voyageRepository;

    public List<Voyage> getAllVoyages() {
        return voyageRepository.findAll();
    }

    public Optional<Voyage> getVoyageById(Long id) {
        return voyageRepository.findById(id);
    }

    public Voyage createVoyage(Voyage voyage) {
        return voyageRepository.save(voyage);
    }

    public Voyage updateVoyage(Long id, Voyage updated) {
        return voyageRepository.findById(id).map(v -> {
            v.setTitre(updated.getTitre());
            v.setDateDebut(updated.getDateDebut());
            v.setDateFin(updated.getDateFin());
            v.setBudget(updated.getBudget());
            v.setCreateur(updated.getCreateur());
            v.setNbPersonnes(updated.getNbPersonnes());
            v.setDescription(updated.getDescription());
            return voyageRepository.save(v);
        }).orElse(null);
    }

    public void deleteVoyage(Long id) {
        voyageRepository.deleteById(id);
    }
}
