package com.mauricioff.workshopmongo.config;

import com.mauricioff.workshopmongo.domain.Post;
import com.mauricioff.workshopmongo.domain.User;
import com.mauricioff.workshopmongo.dto.AuthorDTO;
import com.mauricioff.workshopmongo.repository.PostRepository;
import com.mauricioff.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    //Injeção dos repository
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT'"));

        // Limpa a coleção no banco antes de inserir para não duplicar
        userRepository.deleteAll();
        postRepository.deleteAll();

        // Cria os usuários do zero
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        // Salva os usuarios no MongoDB antes
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        //Cria os posts associando com o author.
        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para SP.", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Bora curtir um som", new AuthorDTO(maria) );

        //Faz o "salvamento em lote" no banco de dados. O Arrays.asList() cria o pacote para ser enviado.
        postRepository.saveAll(Arrays.asList(post1, post2));

        System.out.println("🎸 >>> DADOS INSERIDOS COM SUCESSO PELO JAVA! <<< 🎸");
    }
}