db = db.getSiblingDB('voyage_db');

// Creation de la collection pointInteret

db.createCollection("pointsInteret", { 
  validator: { 
    $jsonSchema: { 
      bsonType: "object", 
      required: ["_id", "nomPOI", "type", "ville", "latitude", "longitude"], 
      properties: { 
        _id: { bsonType: "int" }, 
        nomPOI: { bsonType: "string" }, 
        type: { 
          enum: ["MUSEE", "MONUMENT", "PARC", "PLAGE", "RESTAURANT", "COMMERCE", "EVENEMENT"] 
        }, 
        ville: { 
          bsonType: "object", 
          required: ["_id", "nomVille"], 
          properties: { 
            _id: { bsonType: "int" }, 
            nomVille: { bsonType: "string" } 
          } 
        }, 
        description: { bsonType: "object" }, 
        latitude: { bsonType: "double" }, 
        longitude: { bsonType: "double" }, 
        horaires: { bsonType: "object" }, 
        tarifsMoyens: { bsonType: "object" }, 
        activitesIds: { 
          bsonType: "array", 
          items: { bsonType: "int" } 
        } 
      } 
    } 
  } 
}); 

// Creation de la collection d'activités

// Collection Activités 

db.createCollection("activites", { 

  validator: { 

    $jsonSchema: { 

      bsonType: "object", 

      required: ["_id", "nomActivite", "duree", "description", "prix", "'moisDisponibles", "pointInteretId"], 

      properties: { 

        _id: { bsonType: "int" }, 

        nomActivite: { bsonType: "string" }, 

        duree: { bsonType: "int" }, 

        description: { bsonType: "object" }, 

        prix: { bsonType: "double" }, 

       moisDisponibles: {bsonType: 'array', items: {bsonType: 'string'}}, 

 

        pointInteretId: { bsonType: "int" } 

      } 

    } 

  } 
});

// Creation de la collection d'avis

db.createCollection("avis", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["_id", "note", "dateAvis"],
      properties: {
        _id: { bsonType: "int" },
        note: { bsonType: "int" },
        commentaire: { bsonType: "string" },
        dateAvis: { bsonType: "date" },
        auteur: { bsonType: "string" },
        pointInteretId: { bsonType: "int" },
        hebergementId: { bsonType: "int" }
      }
    }
  }
});

// Insertion des données dans pointsInteret
 
db.pointsInteret.insertMany([ 
  { 
    _id: 1, 
    nomPOI: "Tour Eiffel", 
    type: "MONUMENT", 
    ville: { _id: 1, nomVille: "Paris" }, 
    description: { 
      general: "Monument emblématique de Paris", 
      histoire: "Construite par Gustave Eiffel pour l'Exposition universelle de 1889", 
      architecture: "Structure en fer puddlé de 324 mètres de hauteur" 
    }, 
    latitude: 48.8584, 
    longitude: 2.2945, 
    horaires: { 
      ete: "9h00-23h45", 
      hiver: "9h30-23h00", 
      fermeture: "Jamais" 
    }, 
    tarifsMoyens: { 
      adulte: 26.80, 
      enfant: 13.40, 
      groupe: 20.50 
    }, 
    activitesIds: [1, 2] 
  }, 
  { 
    _id: 2, 
    nomPOI: "Musée du Louvre", 
    type: "MUSEE", 
    ville: { _id: 1, nomVille: "Paris" }, 
    description: { 
      general: "Plus grand musée d'art et d'antiquités au monde", 
      histoire: "Ancien palais royal devenu musée en 1793", 
      collections: "Plus de 35,000 œuvres exposées sur 60,600 m²" 
    }, 
    latitude: 48.8606, 
    longitude: 2.3376, 
    horaires: { 
      lundi: "9h00-18h00", 
      mercredi: "9h00-22h00", 
      jeudi: "9h00-18h00", 
      vendredi: "9h00-22h00", 
      weekend: "9h00-18h00", 
      fermeture: "Mardi" 
    }, 
    tarifsMoyens: { 
      adulte: 17.00, 
      enfant: 0.00, 
      groupe: 15.00 
    }, 
    activitesIds: [3] 
  }, 
  { 
    _id: 3, 
    nomPOI: "Vieux-Port", 
    type: "MONUMENT", 
    ville: { _id: 3, nomVille: "Marseille" }, 
    description: { 
      general: "Port historique de Marseille", 
      histoire: "Fondé par les Grecs vers 600 av. J.-C.", 
      activites: "Marché aux poissons, restaurants, promenades" 
    }, 
    latitude: 43.2951, 
    longitude: 5.3740, 
    horaires: { 
      acces: "24h/24", 
      marchePoisson: "8h00-13h00" 
    }, 
    tarifsMoyens: { 
      adulte: 0.00, 
      enfant: 0.00, 
      groupe: 0.00 
    }, 
    activitesIds: [4, 5] 
  }, 
  { 
    _id: 4, 
    nomPOI: "Parc de la Tête d'Or", 
    type: "PARC", 
    ville: { _id: 2, nomVille: "Lyon" }, 
    description: { 
      general: "Plus grand parc urbain de France", 
      superficie: "117 hectares dont 16 hectares de lac", 
      attractions: "Zoo gratuit, jardin botanique, roseraie" 
    }, 
    latitude: 45.7766, 
    longitude: 4.8541, 
    horaires: { 
      ete: "6h30-22h30", 
      hiver: "6h30-20h30" 
    }, 
    tarifsMoyens: { 
      adulte: 0.00, 
      enfant: 0.00, 
      groupe: 0.00 
    }, 
    activitesIds: [6, 7] 
  } 
]); 
 
// Insertion des données dans activités

db.activites.insertMany([ 

 { 

  "_id": 1, 

  "nomActivite": "Visite du sommet", 

  "duree": 120, 

  "description": { 

    "detail": "Accès au sommet de la Tour Eiffel avec vue panoramique", 

    "accessibilite": "Ascenseurs disponibles" 

  }, 

  "prix": 26.8, 

  "pointInteretId": 1, 

  "moisDisponibles": [ 

    "AOUT", 

    "AVRIL", 

    "DECEMBRE", 

    "FEVRIER", 

    "JANVIER", 

    "JUILLET", 

    "JUIN", 

    "MAI", 

    "MARS", 

    "NOVEMBRE", 

    "OCTOBRE", 

    "SEPTEMBRE" 

  ] 

}, 

{ 

  "_id": 2, 

  "nomActivite": "Dîner au restaurant Jules Verne", 

  "duree": 180, 

  "description": { 

    "detail": "Restaurant gastronomique au deuxième étage", 

    "cuisine": "Française moderne" 

  }, 

  "prix": 190.1, 

  "pointInteretId": 1, 

  "moisDisponibles": [ 

    "AOUT", 

    "AVRIL", 

    "DECEMBRE", 

    "FEVRIER", 

    "JANVIER", 

    "JUILLET", 

    "JUIN", 

    "MAI", 

    "MARS", 

    "NOVEMBRE", 

    "OCTOBRE", 

    "SEPTEMBRE" 

  ] 

}, 

{ 

  "_id": 3, 

  "nomActivite": "Visite guidée des chefs-d'œuvre", 

  "duree": 90, 

  "description": { 

    "detail": "Tour guidé incluant La Joconde, la Vénus de Milo et autres œuvres emblématiques", 

    "langues": [ 

      "Français", 

      "Anglais", 

      "Espagnol", 

      "Japonais" 

    ] 

  }, 

  "prix": 35.5, 

  "pointInteretId": 2, 

  "moisDisponibles": [ 

    "AOUT", 

    "AVRIL", 

    "DECEMBRE", 

    "FEVRIER", 

    "JANVIER", 

    "JUILLET", 

    "JUIN", 

    "MAI", 

    "MARS", 

    "NOVEMBRE", 

    "OCTOBRE", 

    "SEPTEMBRE" 

  ] 

}, 

{ 

  "_id": 4, 

  "nomActivite": "Promenade sur le quai", 

  "duree": 60, 

  "description": { 

    "detail": "Balade le long du port avec vue sur les bateaux et les restaurants", 

    "conseils": "Idéal au coucher du soleil" 

  }, 

  "prix": 0.5, 

  "pointInteretId": 3, 

  "moisDisponibles": [ 

    "AOUT", 

    "AVRIL", 

    "JUILLET", 

    "JUIN", 

    "MAI", 

    "MARS", 

    "NOVEMBRE", 

    "OCTOBRE", 

    "SEPTEMBRE" 

  ] 

}, 

{ 

  "_id": 5, 

  "nomActivite": "Excursion en bateau vers les Calanques", 

  "duree": 240, 

  "description": { 

    "detail": "Visite en bateau des célèbres calanques de Marseille", 

    "depart": "Embarcadère du Vieux-Port" 

  }, 

  "prix": 35.8, 

  "pointInteretId": 3, 

  "moisDisponibles": [ 

    "AOUT", 

    "AVRIL", 

    "JUILLET", 

    "JUIN", 

    "MAI", 

    "MARS" 

  ] 

}, 

{ 

  "_id": 6, 

  "nomActivite": "Balade en barque sur le lac", 

  "duree": 60, 

  "description": { 

    "detail": "Location de barques pour naviguer sur le lac", 

    "conditions": "Selon météo" 

  }, 

  "prix": 8.6, 

  "pointInteretId": 4, 

  "moisDisponibles": [ 

    "AOUT", 

    "AVRIL", 

    "JUILLET", 

    "JUIN", 

    "MAI", 

    "MARS" 

  ] 

}, 

{ 

  "_id": 7, 

  "nomActivite": "Visite du jardin botanique", 

  "duree": 90, 

  "description": { 

    "detail": "Découverte des serres et collections botaniques", 

    "interet": "Plus de 15 000 espèces de plantes" 

  }, 

  "prix": 0.5, 

  "pointInteretId": 4, 

  "moisDisponibles": [ 

    "AOUT", 

    "AVRIL", 

    "JUILLET", 

    "JUIN", 

    "MAI", 

    "MARS", 

    "NOVEMBRE", 

    "OCTOBRE", 

    "SEPTEMBRE" 

  ] 

} 

]);

// Insertion des données dans avis

db.avis.insertMany([ 
  { 
    _id: 1, 
    note: 5, 
    commentaire: "Vue incroyable depuis le sommet !", 
    dateAvis: new Date("2025-01-15"), 
    auteur: "Jean Dupont", 
    pointInteretId: 1 
  }, 
  { 
    _id: 2, 
    note: 4, 
    commentaire: "Magnifique, mais trop de monde en été", 
    dateAvis: new Date("2025-02-03"), 
    auteur: "Marie Lambert", 
    pointInteretId: 1 
  }, 
  { 
    _id: 3, 
    note: 5, 
    commentaire: "Collections exceptionnelles, prévoyez du temps", 
    dateAvis: new Date("2025-01-20"), 
    auteur: "Paul Martin", 
    pointInteretId: 2 
  }, 
  { 
    _id: 4, 
    note: 4, 
    commentaire: "Ambiance unique au coucher du soleil", 
    dateAvis: new Date("2025-03-05"), 
    auteur: "Sophie Moreau", 
    pointInteretId: 3 
  } 
]); 
 

// Mise à jour dans pointsInteret

db.pointsInteret.updateOne(
  { _id: 1 },
  { $set: { "description.general": "Symbole emblématique de Paris, offrant une vue panoramique unique sur la ville." } }
);

db.pointsInteret.updateOne(
  { _id: 2 },
  { $set: { "tarifsMoyens.adulte": 20.00 } }
);

db.pointsInteret.updateOne(
  { _id: 3 },
  { $set: { "horaires.fermeture": "Jamais" } }
);

// Mise à jour dans activites

db.activites.updateOne(
  { _id: 1 },
  { $set: { duree: 150 } }
);

db.activites.updateOne(
  { _id: 4 },
  { $addToSet: { saisonnalite: "HIVER" } }
);

db.activites.updateOne(
  { _id: 2 },
  { $set: { prix: 200.00 } }
);

// Mise à jour dans avis

db.avis.updateOne(
  { _id: 1 },
  { $set: { note: 4 } }
);

db.avis.updateOne(
  { _id: 2 },
  { $set: { commentaire: "Très belle visite mais beaucoup d’attente en été." } }
);

db.avis.updateOne(
  { _id: 3 },
  { $set: { dateAvis: new Date("2025-03-01") } }
);

// Suppression dans pointsInteret

db.pointsInteret.deleteOne({ _id: 1 });

db.pointsInteret.deleteOne({ _id: 2 });

// Suppression dans activites

db.activites.deleteOne({ _id: 3 });

db.activites.deleteOne({ _id: 4 });

// Suppression dans avis

db.avis.deleteOne({ _id: 1 });

db.avis.deleteOne({ _id: 2 });

db.avis.deleteMany({ pointInteretId: 3 });

