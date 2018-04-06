package at.refugeescode.mp12socialnetworkfakebookpersonandfriends.persistence;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class Starter {


    @Bean
    ApplicationRunner applicationRunner(PersonRepository personRepository){
        return args -> {
            List<Person> persons = createPersons();
            personRepository.saveAll(persons);
            System.out.println("--------------------");
            personRepository.findAll().forEach(System.out::println);
            System.out.println("--------------------");
        };
    }

    public List<Person> createPersons(){
        return Stream.of(new Person("Mohammad" ,
                          Arrays.asList(new Person("Diaa"),new Person("Dahman"),new Person("Whael"))),
                        new Person("Aycha" ,Arrays.asList(new Person("Fuona"),new Person("Liza"))))
                .collect(Collectors.toList());
    }
}
