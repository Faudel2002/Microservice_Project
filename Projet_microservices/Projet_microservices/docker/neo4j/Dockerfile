FROM neo4j:5

RUN apt-get update && apt-get install -y netcat

COPY init.sh /init/init.sh
COPY Neo4j.cql /init/Neo4j.cql

RUN chmod +x /init/init.sh

ENTRYPOINT ["/sbin/tini", "-g", "--"]
CMD ["/init/init.sh"]
