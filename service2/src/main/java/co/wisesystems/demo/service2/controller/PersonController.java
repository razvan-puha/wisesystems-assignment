package co.wisesystems.demo.service2.controller;

import co.wisesystems.demo.service2.dto.PersonDto;
import co.wisesystems.demo.service2.service.PersonService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonController {

    PersonService personService;

    @GetMapping
    public List<PersonDto> getPersonsBy(
        @RequestParam(name = "name", required = false)
        String name,
        @RequestParam(name = "code", required = false)
        String personalCode,
        @RequestParam(name = "email", required = false)
        String email
    ) {
        return  personService.getPersonsBy(name, personalCode, email);
    }

    @GetMapping("/{id}")
    public PersonDto getPersonById(@PathVariable int id) {
        return personService.getPersonById(id);
    }
}