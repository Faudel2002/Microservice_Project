package Microservices.Ville_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan("Microservices.Ville_service")
@EnableTransactionManagement
@EnableNeo4jRepositories(basePackages = "Microservices.Ville_service")
public class VilleServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VilleServiceApplication.class, args);
    }

    
    
}