package co.wisesystems.demo.service2.repository;

import co.wisesystems.demo.service2.entity.Person;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends ListCrudRepository<Person, Integer> {

    List<Person> findAllByName(String name);
    List<Person> findAllByPersonalCode(String personalCode);
    List<Person> findAllByEmail(String email);
    List<Person> findAllByNameAndEmail(String name, String email);
    List<Person> findAllByNameAndPersonalCode(String name, String personalCode);
    List<Person> findAllByEmailAndPersonalCode(String name, String personalCode);
    List<Person> findAllByNameAndEmailAndPersonalCode(String name, String email, String personalCode);
}