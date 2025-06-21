package Microservices.Voyage_service.service;

import Microservices.Voyage_service.model.Hebergement;
import Microservices.Voyage_service.repository.HebergementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HebergementService {

    @Autowired
    private HebergementRepository hebergementRepository;

    public List<Hebergement> getAllHebergements() {
        return hebergementRepository.findAll();
    }

    public Optional<Hebergement> getHebergementById(Long id) {
        return hebergementRepository.findById(id);
    }

    public Hebergement createHebergement(Hebergement hebergement) {
        return hebergementRepository.save(hebergement);
    }

    public Hebergement updateHebergement(Long id, Hebergement updatedHebergement) {
        return hebergementRepository.findById(id).map(hebergement -> {
            hebergement.setNomHebergement(updatedHebergement.getNomHebergement());
            hebergement.setTypeHebergement(updatedHebergement.getTypeHebergement());
            hebergement.setNbEtoiles(updatedHebergement.getNbEtoiles());
            hebergement.setPrixNuit(updatedHebergement.getPrixNuit());
            hebergement.setLatitude(updatedHebergement.getLatitude());
            hebergement.setLongitude(updatedHebergement.getLongitude());
            hebergement.setVilleId(updatedHebergement.getVilleId());
            hebergement.setAdresse(updatedHebergement.getAdresse());
            hebergement.setDescription(updatedHebergement.getDescription());
            hebergement.setServices(updatedHebergement.getServices());
            return hebergementRepository.save(hebergement);
        }).orElse(null);
    }

    public void deleteHebergement(Long id) {
        hebergementRepository.deleteById(id);
    }
}
