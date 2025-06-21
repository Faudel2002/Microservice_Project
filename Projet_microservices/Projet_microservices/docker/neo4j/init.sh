#!/bin/bash

# Lancer Neo4j en arrière-plan (commandé proprement via le script officiel)
/docker-entrypoint.sh neo4j &

# Attente active que le serveur Bolt soit opérationnel
echo "⏳ Attente de Neo4j via cypher-shell..."

until echo "RETURN 1;" | cypher-shell -a bolt://localhost:7687 -u neo4j -p faudel2002 -d neo4j >/dev/null 2>&1; do
  echo "🕒 En attente de Neo4j (Bolt)... nouvelle tentative dans 3s"
  sleep 3
done

echo "✅ Connexion établie. Injection du script..."
cypher-shell -a bolt://localhost:7687 -u neo4j -p faudel2002 -d neo4j < /init/Neo4j_clean.cql

echo "✅ Données injectées. Le conteneur reste actif."
tail -f /dev/null
