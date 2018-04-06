package at.refugeescode.mp12socialnetworkfakebookpersonandfriends.persistence;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
public class PersonEndpoint {

    private PersonRepository personRepository;

    public PersonEndpoint(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons")
    List<Person> gatAllPersons() {
        return personRepository.findAll();
    }

    @PostMapping
    Person addPerson(@RequestBody Person person) {
        personRepository.save(person);
        return person;
    }

    @PutMapping("/persons/{id1}/friend/{id2}")
    void addFriend(@PathVariable Long id1, @PathVariable Long id2) {
        Optional<Person> person = personRepository.findById(id1);
        Optional<Person> friend = personRepository.findById(id2);
        if (person.isPresent() && friend.isPresent()) {
            person.get().getFriends().add(friend.get());
            personRepository.save(person.get());
        }
    }


    @PutMapping("/persons/{id1}/unfriend/{id2}")
    void removeFriend(@PathVariable Long id1, @PathVariable Long id2) {
        Optional<Person> person = personRepository.findById(id1);
        Optional<Person> friend = personRepository.findById(id2);
        if (person.isPresent() && friend.isPresent()) {
            person.get().getFriends().remove(friend.get());
            personRepository.save(person.get());
        }
    }

}
