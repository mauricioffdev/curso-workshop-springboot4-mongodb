package com.mauricioff.workshopmongo.config;

import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Bean
    public MongoTemplate mongoTemplate() {
        // Aqui nós cravamos o nome do banco no código!
        return new MongoTemplate(MongoClients.create("mongodb://127.0.0.1:27017"), "workshop_mongo");
    }
}