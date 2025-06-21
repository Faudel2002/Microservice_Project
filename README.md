# Microservice_Project

## Organisation des microservices
Le projet est divisé en plusieurs microservices, chacun disposant de son propre dossier, Dockerfile, et application.properties. Voici la structure :

Voyage_service/ : gestion des voyages, étapes, hébergements, activités planifiées

Poi_service/ : gestion des points d’intérêt et des activités

Ville_service/ : gestion des villes et de leurs relations (géographiques)

Chaque microservice utilise Spring Boot, Spring Data et expose une API REST dédiée.

## Structure des bases de données
PostgreSQL (voyage-service) Tables : voyage, etape, hebergement, activite_planifiee

MongoDB (poi-service) Collections : pointinteret, activite

Neo4j (ville-service) Nœuds : Ville

Relations : SE_SITUE_A

## Exécution du projet

Dans un un terminal à la racine du projet :

docker-compose build 
docker-compose up

Lancer les swager dans un navigateur : 

Poi_service : http://localhost:8001/swagger-ui/index.html# 
Ville_service : http://localhost:8002/swagger-ui/index.html# 
Voyage_service : http://localhost:8003/swagger-ui/index.html#

Lancement des bases de données :

**Pour Neo4j** 

http://localhost:7474

**Pour MongoDB** 

mongodb://localhost:27017

**Pour PostgreSQL**

Télécharger DBeaver. 
Créer une nouvelle connexion PostgreSQL avec :

Host : localhost 
Port : 5432 
Database : voyage_db 
Username : postgres 
Password : root
