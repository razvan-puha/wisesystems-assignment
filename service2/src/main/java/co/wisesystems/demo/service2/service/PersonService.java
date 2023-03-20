package co.wisesystems.demo.service2.service;

import co.wisesystems.demo.service2.dto.PersonDto;
import co.wisesystems.demo.service2.entity.Person;
import co.wisesystems.demo.service2.repository.PersonRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonService {

    PersonRepository personRepository;

    public List<PersonDto> getPersonsBy(String name, String personalCode, String email) {
        List<Person> persons = fetchPersons(name, personalCode, email);

        return persons.stream()
            .map(person -> PersonDto.of(person.getId(),
                person.getName(),
                person.getPersonalCode(),
                person.getEmail()))
            .toList();
    }

    private List<Person> fetchPersons(String name, String personalCode, String email) {
        if (StringUtils.hasLength(name) &&
            StringUtils.hasLength(personalCode) &&
            StringUtils.hasLength(email)) {
            return personRepository.findAllByNameAndEmailAndPersonalCode(name, email, personalCode);
        }

        if (StringUtils.hasLength(name) &&
            StringUtils.hasLength(personalCode)) {
            return personRepository.findAllByNameAndPersonalCode(name, personalCode);
        }

        if (StringUtils.hasLength(name) &&
            StringUtils.hasLength(email)) {
            return personRepository.findAllByNameAndEmail(name, email);
        }

        if (StringUtils.hasLength(personalCode) &&
            StringUtils.hasLength(email)) {
            return personRepository.findAllByEmailAndPersonalCode(email, personalCode);
        }

        if (StringUtils.hasLength(name)) {
            return personRepository.findAllByName(name);
        }

        if (StringUtils.hasLength(personalCode)) {
            return personRepository.findAllByPersonalCode(personalCode);
        }

        if (StringUtils.hasLength(email)) {
            return personRepository.findAllByEmail(email);
        }

        return personRepository.findAll();
    }

    public PersonDto getPersonById(int id) {
        return personRepository.findById(id)
            .map(person -> PersonDto.of(person.getId(),
                person.getName(),
                person.getPersonalCode(),
                person.getEmail()))
            .orElseThrow();
    }
}