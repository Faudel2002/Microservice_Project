package Microservices.Poi_service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActiviteService {

    private final ActiviteRepository activiteRepository;
    
    private static final List<String> MOIS_ORDER = Arrays.asList(
    	    "JANVIER", "FEVRIER", "MARS", "AVRIL", "MAI", "JUIN",
    	    "JUILLET", "AOUT", "SEPTEMBRE", "OCTOBRE", "NOVEMBRE", "DECEMBRE"
    	);


    @Autowired
    public ActiviteService(ActiviteRepository activiteRepository) {
        this.activiteRepository = activiteRepository;
    }

    public List<Activite> findActivitesDisponiblesParMois(List<String> mois) {
        return activiteRepository.findByMoisDisponiblesIn(mois);
    }
    
    public List<String> getPlageMois(String debut, String fin) {
        int indexDebut = MOIS_ORDER.indexOf(debut.toUpperCase());
        int indexFin = MOIS_ORDER.indexOf(fin.toUpperCase());

        // Gérer le cas où l'utilisateur inverse les mois
        if (indexDebut > indexFin) {
            throw new IllegalArgumentException("Le mois de début doit précéder le mois de fin.");
        }

        return MOIS_ORDER.subList(indexDebut, indexFin + 1);
    }

}

