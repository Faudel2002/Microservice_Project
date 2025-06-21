package Microservices.Ville_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/villes")
public class VilleController {

	@Autowired
	private VilleService villeService;

	@Autowired
	private VilleRepository villeRepository;

	@GetMapping
	public List<Ville> getAllVilles() {
		return villeService.getAllVilles();
	}

	@GetMapping("/{id}")
	public Ville getVille(@PathVariable int id) {
		System.out.println("🔎 Requête GET sur /api/villes");
		return villeService.getVilleById(id);
	}

	@PostMapping
	public Ville createVille(@RequestBody Ville ville) {
		return villeService.createVille(ville);
	}

	@PostMapping("/relier")
	public Ville ajouterRelation(@RequestParam int ville1, @RequestParam int ville2, @RequestParam double kilometres,
			@RequestParam int tempsDeTrajet, @RequestParam String typeTransport) {
		return villeService.ajouterRelation(ville1, ville2, kilometres, tempsDeTrajet, typeTransport);
	}

//	@GetMapping("/{id}/connections")
//	public List<Ville> getConnectedCities(@PathVariable int id) {
//		return villeService.getConnectedCities(id);
//	}

	@DeleteMapping("/{id}")
	public void deleteVille(@PathVariable int id) {
		villeService.deleteVille(id);
	}

	@GetMapping("/shortest-path")
	public List<Ville> getShortestPath(@RequestParam String from, @RequestParam String to) {
		System.out.println("🔎 Recherche du plus court chemin entre " + from + " et " + to);
		return villeService.getShortestPath(from, to);
	}

	@GetMapping("/test")
	public String testEndpoint() {
		System.out.println("✅ Endpoint /api/villes/test appelé");
		return "Le service est bien démarré.";
	}

	@GetMapping("/closest")
	public Ville getClosestCity(@RequestParam String from) {
		System.out.println("🔎 Recherche de la ville la plus proche de : " + from);
		return villeService.getClosestCity(from);
	}

	@GetMapping("/distance")
	public double getDistanceBetweenCities(@RequestParam String from, @RequestParam String to) {
		System.out.println("🔎 Calcul de la distance entre " + from + " et " + to);
		return villeService.getDistanceBetweenCities(from, to);
	}

	@GetMapping("/Id/{nom}")
	public ResponseEntity<Integer> getVilleIdParNom(@PathVariable String nom) {
		Ville ville = villeService.getVilleByNom(nom);
		if (ville != null) {
			return ResponseEntity.ok(ville.getId());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/{nom}/nearby")
	public List<Ville> getNearbyCities(@PathVariable String nom, @RequestParam double rayon) {
		return villeRepository.findNearbyCities(nom, rayon);
	}

	@GetMapping("/DistanceAndTime")
	public DistanceAndTimeDTO getDistance(@RequestParam String ville1, @RequestParam String ville2) {
		return villeRepository.getDistanceAndTime(ville1, ville2);
	}
	
	@GetMapping("/nom")
	public Ville getVilleByNom(@RequestParam String nom) {
	    return villeRepository.findByNom(nom);
	}
	
	@GetMapping("/ville/avec-connexions")
	public Map<String, Object> getVilleAvecConnexions(@RequestParam String nom) {
	    Ville ville = villeRepository.findByNom(nom);
	    List<Ville> connectees = villeRepository.findConnectedCities(ville.getId());

	    Map<String, Object> response = new HashMap<>();
	    response.put("ville", ville);
	    response.put("villesConnectees", connectees);

	    return response;
	}




}