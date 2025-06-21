package Microservices.Ville_service;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VilleRepository extends Neo4jRepository<Ville, Integer> {

	@Query("MATCH (v:Ville) RETURN v")
	List<Ville> findAllVilles();

	@Query("MATCH (v:Ville)-[r:SE_SITUE_A]-(c:Ville) WHERE v.id = $id RETURN c")
	List<Ville> findConnectedCities(int id);

	@Query("MATCH (start:Ville {nomVille: $from}), (end:Ville {nomVille: $to}), "
			+ "p = shortestPath((start)-[:SE_SITUE_A*]-(end)) " + "RETURN nodes(p) AS villes")
	List<Ville> findShortestPath(String from, String to);

	@Query("MATCH (v:Ville {nomVille: $from})-[r:SE_SITUE_A]->(c:Ville) " + "RETURN c ORDER BY r.distance ASC LIMIT 1")
	Ville findClosestCity(String from);

	@Query("MATCH (start:Ville {nomVille: $from}), (end:Ville {nomVille: $to}), "
			+ "p = shortestPath((start)-[:SE_SITUE_A*]-(end)) "
			+ "RETURN reduce(totalDistance = 0, rel in relationships(p) | totalDistance + rel.distance) AS totalDistance")
	Double calculateDistance(String from, String to);

	Ville findByNom(String nomVille);

	@Query("MATCH (v:Ville {nomVille: $nom})-[r:SE_SITUE_A]->(autre:Ville) " + "WHERE r.distance <= $rayon "
			+ "RETURN autre")
	List<Ville> findNearbyCities(String nom, double rayon);

	@Query("MATCH (v1:Ville {nomVille: $ville1})-[r:SE_SITUE_A]-(v2:Ville {nomVille: $ville2}) "
			+ "RETURN r.distance AS distance, r.tempsTrajet AS tempsTrajet")
	DistanceAndTimeDTO getDistanceAndTime(@Param("ville1") String ville1, @Param("ville2") String ville2);

}