CREATE CONSTRAINT ville_id IF NOT EXISTS FOR (v:Ville) REQUIRE v.id IS UNIQUE;
CREATE CONSTRAINT ville_nom IF NOT EXISTS FOR (v:Ville) REQUIRE v.nomVille IS UNIQUE;


CREATE (:Ville {id: 1, nomVille: "Paris", latitude: 48.8566, longitude: 2.3522});
CREATE (:Ville {id: 2, nomVille: "Lyon", latitude: 45.7578, longitude: 4.8320});
CREATE (:Ville {id: 3, nomVille: "Marseille", latitude: 43.2965, longitude: 5.3698});
CREATE (:Ville {id: 4, nomVille: "Bordeaux", latitude: 44.8378, longitude: -0.5792});
CREATE (:Ville {id: 5, nomVille: "Strasbourg", latitude: 48.5734, longitude: 7.7521});
CREATE (:Ville {id: 6, nomVille: "Nice", latitude: 43.7102, longitude: 7.2620});
CREATE (:Ville {id: 7, nomVille: "Nantes", latitude: 47.2184, longitude: -1.5536});
CREATE (:Ville {id: 8, nomVille: "Montpellier", latitude: 43.6108, longitude: 3.8767});



MATCH (paris:Ville {nomVille: "Paris"}), (lyon:Ville {nomVille: "Lyon"})
CREATE (paris)-[:SE_SITUE_A {distance: 465, tempsTrajet: 240, transport: "TRAIN"}]->(lyon);

MATCH (paris:Ville {nomVille: "Paris"}), (marseille:Ville {nomVille: "Marseille"})
CREATE (paris)-[:SE_SITUE_A {distance: 773, tempsTrajet: 420, transport: "TRAIN"}]->(marseille);

MATCH (paris:Ville {nomVille: "Paris"}), (bordeaux:Ville {nomVille: "Bordeaux"})
CREATE (paris)-[:SE_SITUE_A {distance: 583, tempsTrajet: 330, transport: "TRAIN"}]->(bordeaux);

MATCH (paris:Ville {nomVille: "Paris"}), (strasbourg:Ville {nomVille: "Strasbourg"})
CREATE (paris)-[:SE_SITUE_A {distance: 488, tempsTrajet: 270, transport: "TRAIN"}]->(strasbourg);

MATCH (paris:Ville {nomVille: "Paris"}), (nice:Ville {nomVille: "Nice"})
CREATE (paris)-[:SE_SITUE_A {distance: 932, tempsTrajet: 510, transport: "TRAIN"}]->(nice);

MATCH (paris:Ville {nomVille: "Paris"}), (nantes:Ville {nomVille: "Nantes"})
CREATE (paris)-[:SE_SITUE_A {distance: 384, tempsTrajet: 210, transport: "TRAIN"}]->(nantes);


MATCH (lyon:Ville {nomVille: "Lyon"}), (marseille:Ville {nomVille: "Marseille"})
CREATE (lyon)-[:SE_SITUE_A {distance: 315, tempsTrajet: 180, transport: "TRAIN"}]->(marseille);

MATCH (lyon:Ville {nomVille: "Lyon"}), (bordeaux:Ville {nomVille: "Bordeaux"})
CREATE (lyon)-[:SE_SITUE_A {distance: 550, tempsTrajet: 330, transport: "TRAIN"}]->(bordeaux);

MATCH (lyon:Ville {nomVille: "Lyon"}), (strasbourg:Ville {nomVille: "Strasbourg"})
CREATE (lyon)-[:SE_SITUE_A {distance: 492, tempsTrajet: 300, transport: "TRAIN"}]->(strasbourg);

MATCH (lyon:Ville {nomVille: "Lyon"}), (nice:Ville {nomVille: "Nice"})
CREATE (lyon)-[:SE_SITUE_A {distance: 472, tempsTrajet: 270, transport: "TRAIN"}]->(nice);

MATCH (lyon:Ville {nomVille: "Lyon"}), (nantes:Ville {nomVille: "Nantes"})
CREATE (lyon)-[:SE_SITUE_A {distance: 612, tempsTrajet: 360, transport: "TRAIN"}]->(nantes);

MATCH (lyon:Ville {nomVille: "Lyon"}), (montpellier:Ville {nomVille: "Montpellier"})
CREATE (lyon)-[:SE_SITUE_A {distance: 302, tempsTrajet: 180, transport: "TRAIN"}]->(montpellier);


MATCH (marseille:Ville {nomVille: "Marseille"}), (nice:Ville {nomVille: "Nice"})
CREATE (marseille)-[:SE_SITUE_A {distance: 195, tempsTrajet: 130, transport: "TRAIN"}]->(nice);

MATCH (marseille:Ville {nomVille: "Marseille"}), (montpellier:Ville {nomVille: "Montpellier"})
CREATE (marseille)-[:SE_SITUE_A {distance: 167, tempsTrajet: 105, transport: "TRAIN"}]->(montpellier);


MATCH (bordeaux:Ville {nomVille: "Bordeaux"}), (nantes:Ville {nomVille: "Nantes"})
CREATE (bordeaux)-[:SE_SITUE_A {distance: 353, tempsTrajet: 210, transport: "TRAIN"}]->(nantes);

MATCH (bordeaux:Ville {nomVille: "Bordeaux"}), (montpellier:Ville {nomVille: "Montpellier"})
CREATE (bordeaux)-[:SE_SITUE_A {distance: 483, tempsTrajet: 300, transport: "TRAIN"}]->(montpellier);
