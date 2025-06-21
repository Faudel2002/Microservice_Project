package Microservices.Voyage_service.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/test-db")
    public String testDbConnection() {
        return "Connexion PostgreSQL réussie ✅";
    }
}
