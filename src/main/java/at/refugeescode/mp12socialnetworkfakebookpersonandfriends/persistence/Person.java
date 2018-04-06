package at.refugeescode.mp12socialnetworkfakebookpersonandfriends.persistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Person> friends = new ArrayList<>();


    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, List<Person> friends) {
        this.name = name;
        this.friends = friends;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", friends=" + friends +
                '}';
    }
}
