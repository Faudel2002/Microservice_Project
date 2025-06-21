#!/bin/bash
until curl -s http://localhost:7474 | grep -q "Neo4j Browser"; do
  echo "⌛ Neo4j n’est pas encore prêt..."
  sleep 3
done
echo "✅ Neo4j est prêt."
