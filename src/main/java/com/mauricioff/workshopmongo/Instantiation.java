package com.mauricioff.workshopmongo.config;

import com.mauricioff.workshopmongo.domain.User;
import com.mauricioff.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Limpa a coleção no banco antes de inserir para não duplicar
        userRepository.deleteAll();

        // Cria os usuários do zero
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        // Salva no MongoDB
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        System.out.println("🎸 >>> DADOS INSERIDOS COM SUCESSO PELO JAVA! <<< 🎸");
    }
}