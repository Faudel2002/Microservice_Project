-- Définition des types ENUM

CREATE TYPE type_hebergement AS ENUM ('HOTEL', 'APPARTEMENT', 'MAISON_HOTE', 'CAMPING', 'AUBERGE');
CREATE TYPE statut_activite AS ENUM ('PLANIFIEE', 'EN_COURS', 'TERMINEE', 'ANNULEE');
CREATE TYPE saison AS ENUM ('PRINTEMPS', 'ETE', 'AUTOMNE', 'HIVER');

-- Création des tables

-- Table Hébergement
CREATE TABLE hebergement (
    id SERIAL PRIMARY KEY,
    nom_hebergement VARCHAR(100) NOT NULL,
    type_hebergement type_hebergement NOT NULL,
    nb_etoiles INTEGER CHECK (nb_etoiles BETWEEN 1 AND 5),
    prix_nuit DECIMAL(10, 2) NOT NULL,
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    ville_id INTEGER NOT NULL,
    adresse TEXT,
    description TEXT,
    services JSONB
);

-- Table Voyage
CREATE TABLE voyage (
    id SERIAL PRIMARY KEY,
    titre VARCHAR(100) NOT NULL,
    date_debut DATE NOT NULL,
    date_fin DATE NOT NULL,
    budget DECIMAL(12, 2),
    createur VARCHAR(100) NOT NULL,
    nb_personnes INTEGER DEFAULT 1,
    description TEXT,
    CONSTRAINT check_dates CHECK (date_fin >= date_debut)
);

-- Table Etape
CREATE TABLE etape (
    id SERIAL PRIMARY KEY,
    voyage_id INTEGER NOT NULL REFERENCES voyage(id) ON DELETE CASCADE,
    jour_numero INTEGER NOT NULL,
    ville_id INTEGER NOT NULL,
    hebergement_id INTEGER REFERENCES hebergement(id),
    date_arrivee DATE NOT NULL,
    date_depart DATE NOT NULL,
    CONSTRAINT check_etape_dates CHECK (date_depart >= date_arrivee),
    UNIQUE (voyage_id, jour_numero)
);

-- Table Activité Planifiée
CREATE TABLE activite_planifiee (
    id SERIAL PRIMARY KEY,
    etape_id INTEGER NOT NULL REFERENCES etape(id) ON DELETE CASCADE,
    point_interet_id INTEGER NOT NULL,
    activite_id INTEGER NOT NULL,
    heure_debut TIME NOT NULL,
    heure_fin TIME NOT NULL,
    statut statut_activite DEFAULT 'PLANIFIEE',
    note_personnelle TEXT,
    CONSTRAINT check_heures CHECK (heure_fin > heure_debut)
);
-- Indexation pour optimiser les requêtes

CREATE INDEX idx_hebergement_ville ON hebergement(ville_id);
CREATE INDEX idx_etape_voyage ON etape(voyage_id);
CREATE INDEX idx_etape_ville ON etape(ville_id);
CREATE INDEX idx_activite_planifiee_etape ON activite_planifiee(etape_id);
CREATE INDEX idx_activite_planifiee_poi ON activite_planifiee(point_interet_id);

-- Insertion de données

-- Hébergement
INSERT INTO hebergement (nom_hebergement, type_hebergement, nb_etoiles, prix_nuit, latitude, longitude, ville_id, adresse, services) VALUES
('Hôtel de Paris', 'HOTEL', 4, 210.00, 48.8704, 2.3292, 1, '15 Avenue des Champs-Élysées, 75008 Paris', '{"wifi": true, "petit_dejeuner": true, "piscine": false, "parking": true, "animaux": false}'),
('Appartement Vue Mer', 'APPARTEMENT', NULL, 95.00, 43.2961, 5.3698, 3, '22 Quai du Port, 13002 Marseille', '{"wifi": true, "petit_dejeuner": false, "parking": false, "lave_linge": true, "climatisation": true}');

-- Voyage
INSERT INTO voyage (titre, date_debut, date_fin, budget, createur, nb_personnes, description) VALUES
('Tour de France', '2025-06-15', '2025-06-25', 2500.00, 'Sophie Martin', 2, 'Découverte des principales villes françaises'),
('Weekend à Paris', '2025-05-01', '2025-05-04', 800.00, 'Lucas Dubois', 2, 'Court séjour culturel à Paris');

-- Etape
INSERT INTO etape (voyage_id, jour_numero, ville_id, hebergement_id, date_arrivee, date_depart) VALUES
(1, 1, 1, 1, '2025-06-15', '2025-06-17'),
(1, 3, 2, NULL, '2025-06-17', '2025-06-20');

-- Activité Planifiée
INSERT INTO activite_planifiee (etape_id, point_interet_id, activite_id, heure_debut, heure_fin, statut, note_personnelle) VALUES
(1, 1, 1, '10:00', '12:00', 'PLANIFIEE', 'Réserver à l avance pour éviter la file'),
(1, 2, 3, '14:30', '16:00', 'PLANIFIEE', 'Voir absolument La Joconde');

-- Nouvelles données Hébergement
INSERT INTO hebergement (nom_hebergement, type_hebergement, nb_etoiles, prix_nuit, latitude, longitude, ville_id, adresse, services) VALUES
-- Paris
('Hôtel de la Paix', 'HOTEL', 5, 320.00, 48.8566, 2.3522, 1, '12 Rue de Rivoli, 75001 Paris', '{"wifi": true, "petit_dejeuner": true, "piscine": true, "parking": true, "animaux": true}'),
('Appartement Eiffel View', 'APPARTEMENT', NULL, 120.00, 48.8584, 2.2945, 1, '15 Avenue Gustave Eiffel, 75007 Paris', '{"wifi": true, "petit_dejeuner": false, "climatisation": true, "lave_linge": true}'),
-- Lyon
('Hôtel Bellecour', 'HOTEL', 4, 180.00, 45.7578, 4.8320, 2, '20 Place Bellecour, 69002 Lyon', '{"wifi": true, "petit_dejeuner": true, "parking": true, "animaux": false}'),
('Résidence Lumière', 'APPARTEMENT', NULL, 75.00, 45.7640, 4.8357, 2, '5 Rue Lumière, 69008 Lyon', '{"wifi": true, "petit_dejeuner": false, "climatisation": true}'),
-- Marseille
('Hôtel du Vieux-Port', 'HOTEL', 3, 90.00, 43.2965, 5.3698, 3, '1 Quai du Port, 13002 Marseille', '{"wifi": true, "petit_dejeuner": true, "vue_mer": true, "animaux": true}'),
('Maison d’Hôtes des Calanques', 'MAISON_HOTE', 4, 110.00, 43.2853, 5.3760, 3, '22 Boulevard Michelet, 13008 Marseille', '{"wifi": true, "petit_dejeuner": true, "parking": false, "jardin": true}'),
-- Bordeaux
('Grand Hôtel de Bordeaux', 'HOTEL', 5, 270.00, 44.8378, -0.5792, 4, '2 Place de la Comédie, 33000 Bordeaux', '{"wifi": true, "petit_dejeuner": true, "spa": true, "restaurant": true, "conciergerie": true}'),
('Villa Saint-Emilion', 'MAISON_HOTE', 3, 85.00, 44.8333, -0.5667, 4, '18 Rue Saint-Émilion, 33000 Bordeaux', '{"wifi": true, "petit_dejeuner": false, "jardin": true, "parking": true}');

-- Nouvelles données Voyage
INSERT INTO voyage (titre, date_debut, date_fin, budget, createur, nb_personnes, description) VALUES
('Découverte de la Côte dAzur', '2025-08-01', '2025-08-15', 3500.00, 'Alice Martin', 2, 'Road trip de Nice à Marseille en passant par Cannes et Monaco'),
('Escapade Bordelaise', '2025-09-10', '2025-09-15', 800.00, 'Mathieu Dupont', 1, 'Visite des vignobles bordelais et dégustation de vins'),
('Lyon City Break', '2025-10-01', '2025-10-03', 300.00, 'Caroline Petit', 2, 'Week-end découverte de Lyon et ses spécialités culinaires'),
('Weekend à Marseille', '2025-06-20', '2025-06-22', 500.00, 'Emma Lemoine', 2, 'Visite du Vieux-Port et des Calanques');

-- Etapes supplémentaires
INSERT INTO etape (voyage_id, jour_numero, ville_id, hebergement_id, date_arrivee, date_depart) VALUES
(1, 2, 6, NULL, '2025-08-01', '2025-08-05'),  -- Nice
(1, 4, 3, 6, '2025-08-05', '2025-08-10'),     -- Marseille
(2, 1, 4, 8, '2025-09-10', '2025-09-15'),     -- Bordeaux
(3, 1, 2, 4, '2025-10-01', '2025-10-03'),     -- Lyon
(4, 1, 3, 5, '2025-06-20', '2025-06-22');     -- Marseille

-- Activités planifiées supplémentaires
INSERT INTO activite_planifiee (etape_id, point_interet_id, activite_id, heure_debut, heure_fin, statut, note_personnelle) VALUES
(1, 6, 1, '10:00', '12:00', 'PLANIFIEE', 'Visite de la Promenade des Anglais'),
(2, 3, 5, '09:00', '12:00', 'PLANIFIEE', 'Excursion en bateau vers les Calanques'),
(2, 3, 4, '14:00', '15:00', 'PLANIFIEE', 'Promenade sur le quai'),
(6, 2, 3, '10:00', '12:00', 'PLANIFIEE', 'Visite guidée au Musée du Louvre'),
(7, 4, 7, '11:00', '12:30', 'PLANIFIEE', 'Découverte du jardin botanique'),
(7, 1, 1, '10:00', '12:00', 'PLANIFIEE', 'Visite du sommet de la Tour Eiffel');

-- Modification des donnees

UPDATE hebergement
SET prix_nuit = 250.00
WHERE id = 1;

UPDATE hebergement
SET description = 'Hôtel rénové récemment avec vue sur la Tour Eiffel'
WHERE id = 1;

