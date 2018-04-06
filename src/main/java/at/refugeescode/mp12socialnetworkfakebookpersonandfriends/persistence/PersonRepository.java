package at.refugeescode.mp12socialnetworkfakebookpersonandfriends.persistence;

import at.refugeescode.mp12socialnetworkfakebookpersonandfriends.persistence.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {

}
