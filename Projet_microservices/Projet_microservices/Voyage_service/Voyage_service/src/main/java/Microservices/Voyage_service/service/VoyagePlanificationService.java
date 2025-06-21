package Microservices.Voyage_service.service;

import Microservices.Voyage_service.dto.*;
import Microservices.Voyage_service.model.*;
import Microservices.Voyage_service.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoyagePlanificationService {

    @Autowired
    private VoyageRepository voyageRepository;

    @Autowired
    private EtapeRepository etapeRepository;

    @Autowired
    private HebergementRepository hebergementRepository;

    @Autowired
    private ActivitePlanifieeRepository activitePlanifieeRepository;

    public Voyage planifierVoyage(VoyagePlanificationRequestDTO dto) {

        // 1️⃣ Créer le voyage
        Voyage voyage = new Voyage();
        voyage.setTitre(dto.getTitre());
        voyage.setDateDebut(dto.getDateDebut());
        voyage.setDateFin(dto.getDateFin());
        voyage.setBudget(dto.getBudget());
        voyage.setCreateur(dto.getCreateur());
        voyage.setNbPersonnes(dto.getNbPersonnes());
        voyage.setDescription(dto.getDescription());

        Voyage voyageSaved = voyageRepository.save(voyage);

        // 2️⃣ Pour chaque étape
        for (EtapeDTO etapeDTO : dto.getEtapes()) {
            Etape etape = new Etape();
            etape.setVoyage(voyageSaved);
            etape.setJourNumero(etapeDTO.getJourNumero());
            etape.setVilleId(etapeDTO.getVilleId());
            etape.setDateArrivee(etapeDTO.getDateArrivee());
            etape.setDateDepart(etapeDTO.getDateDepart());

            if (etapeDTO.getHebergementId() != null) {
                Hebergement hebergement = hebergementRepository.findById(etapeDTO.getHebergementId())
                        .orElse(null);
                etape.setHebergement(hebergement);
            }

            Etape etapeSaved = etapeRepository.save(etape);

            // 3️⃣ Pour chaque activité planifiée de l'étape
            for (ActivitePlanifieeInputDTO activiteDTO : etapeDTO.getActivites()) {
                ActivitePlanifiee activite = new ActivitePlanifiee();
                activite.setEtape(etapeSaved);
                activite.setPointInteretId(activiteDTO.getPointInteretId());
                activite.setActiviteId(activiteDTO.getActiviteId());
                activite.setHeureDebut(activiteDTO.getHeureDebut());
                activite.setHeureFin(activiteDTO.getHeureFin());
                activite.setNotePersonnelle(activiteDTO.getNotePersonnelle());
                activite.setStatut(StatutActivite.valueOf(activiteDTO.getStatut()));

                activitePlanifieeRepository.save(activite);
            }
        }

        return voyageSaved;
    }
    
    public Voyage getVoyageById(Long id) {
        return voyageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Voyage non trouvé avec l'id : " + id));
    }
    
    public Voyage updateVoyage(Long id, VoyagePlanificationRequestDTO dto) {
        Voyage voyage = voyageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Voyage non trouvé avec l'id : " + id));

        // 🧹 Supprimer les anciennes étapes (et donc les anciennes activités planifiées)
        List<Etape> anciennesEtapes = etapeRepository.findByVoyageId(id);
        for (Etape ancienneEtape : anciennesEtapes) {
            activitePlanifieeRepository.deleteByEtapeId(ancienneEtape.getId());
        }
        etapeRepository.deleteAll(anciennesEtapes);

        // 📝 Mettre à jour les infos du voyage
        voyage.setTitre(dto.getTitre());
        voyage.setDateDebut(dto.getDateDebut());
        voyage.setDateFin(dto.getDateFin());
        voyage.setBudget(dto.getBudget());
        voyage.setCreateur(dto.getCreateur());
        voyage.setNbPersonnes(dto.getNbPersonnes());
        voyage.setDescription(dto.getDescription());

        Voyage voyageUpdated = voyageRepository.save(voyage);

        // 🔁 Recréer les nouvelles étapes et activités
        for (EtapeDTO etapeDTO : dto.getEtapes()) {
            Etape etape = new Etape();
            etape.setVoyage(voyageUpdated);
            etape.setJourNumero(etapeDTO.getJourNumero());
            etape.setVilleId(etapeDTO.getVilleId());
            etape.setDateArrivee(etapeDTO.getDateArrivee());
            etape.setDateDepart(etapeDTO.getDateDepart());

            if (etapeDTO.getHebergementId() != null) {
                Hebergement hebergement = hebergementRepository.findById(etapeDTO.getHebergementId()).orElse(null);
                etape.setHebergement(hebergement);
            }

            Etape etapeSaved = etapeRepository.save(etape);

            for (ActivitePlanifieeInputDTO activiteDTO : etapeDTO.getActivites()) {
                ActivitePlanifiee activite = new ActivitePlanifiee();
                activite.setEtape(etapeSaved);
                activite.setPointInteretId(activiteDTO.getPointInteretId());
                activite.setActiviteId(activiteDTO.getActiviteId());
                activite.setHeureDebut(activiteDTO.getHeureDebut());
                activite.setHeureFin(activiteDTO.getHeureFin());
                activite.setNotePersonnelle(activiteDTO.getNotePersonnelle());
                activite.setStatut(StatutActivite.valueOf(activiteDTO.getStatut()));

                activitePlanifieeRepository.save(activite);
            }
        }

        return voyageUpdated;
    }
    
    public void deleteVoyage(Long id) {
        if (!voyageRepository.existsById(id)) {
            throw new RuntimeException("Voyage non trouvé avec l'id : " + id);
        }

        List<Etape> etapes = etapeRepository.findByVoyageId(id);
        for (Etape etape : etapes) {
            activitePlanifieeRepository.deleteByEtapeId(etape.getId());
        }
        etapeRepository.deleteAll(etapes);

        voyageRepository.deleteById(id);
    }

}
