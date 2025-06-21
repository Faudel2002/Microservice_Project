package Microservices.Ville_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VilleService {

    @Autowired
    private VilleRepository villeRepository;
    

    public VilleService(VilleRepository villeRepository) {
        this.villeRepository = villeRepository;
    }

    public Ville getVilleByNom(String nom) {
        return villeRepository.findByNom(nom);
    }
    
    public List<Ville> getAllVilles() {
        return villeRepository.findAll();
    }

    
    public Ville getVilleById(Integer id) {
        return villeRepository.findById(id).orElse(null);
    }
    
    
    @Transactional
    public Ville createVille(Ville ville) {
        return villeRepository.save(ville);
    }

    @Transactional
    public Ville ajouterRelation(Integer idVille1, Integer idVille2, double kilometres, int tempsDeTrajet, String typeTransport) {
        Ville ville1 = villeRepository.findById(idVille1).orElse(null);
        Ville ville2 = villeRepository.findById(idVille2).orElse(null);

        if (ville1 != null && ville2 != null) {
            Distance relation = new Distance(kilometres, tempsDeTrajet, typeTransport, ville2);
            ville1.getVillesConnectees().add(relation);
            villeRepository.save(ville1);
            return ville1;
        }
        return null;
    }

    @Transactional
    public void deleteVille(Integer id) {
        villeRepository.deleteById(id);
    }

    
    @Transactional(readOnly = true)
    public List<Ville> getConnectedCities(int id) {
        List<Ville> villes = villeRepository.findConnectedCities(id);
        
        // 🔎 Debug pour vérifier
        villes.forEach(v -> {
            System.out.println("Ville : " + v.getNom());
            v.getVillesConnectees().forEach(d -> {
                System.out.println("  ↳ Transport: " + d.getTypeTransport());
                System.out.println("  ↳ Distance: " + d.getKilometres());
                System.out.println("  ↳ Temps: " + d.getTempsDeTrajet());
            });
        });

        return villes;
    }
    
    
    @Transactional(readOnly = true)
    public List<Ville> getShortestPath(String from, String to) {
        System.out.println("🔄 Recherche du plus court chemin entre " + from + " et " + to);
        return villeRepository.findShortestPath(from, to);
    }
    
    @Transactional(readOnly = true)
    public Ville getClosestCity(String from) {
        System.out.println("🔄 Recherche de la ville la plus proche de " + from);
        return villeRepository.findClosestCity(from);
    }
    
    @Transactional(readOnly = true)
    public double getDistanceBetweenCities(String from, String to) {
        System.out.println("🔄 Recherche du chemin le plus court entre " + from + " et " + to);

        // Récupération de la distance totale entre les deux villes
        Double totalDistance = villeRepository.calculateDistance(from, to);
        if (totalDistance == null) {
            System.out.println("⚠️ Aucun chemin trouvé entre " + from + " et " + to);
            return 0;
        }

        System.out.println("🛣️ Distance trouvée : " + totalDistance + " km");
        return totalDistance;
    }
    
}