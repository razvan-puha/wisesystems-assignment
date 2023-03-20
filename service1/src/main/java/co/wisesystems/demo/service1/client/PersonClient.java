package co.wisesystems.demo.service1.client;

import co.wisesystems.demo.service1.dto.PersonDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "person-client", url = "${feign.client.person.url}")
public interface PersonClient {

    @GetMapping("/v1/persons")
    List<PersonDto> getPersonsBy(
        @RequestParam(name = "name", required = false)
        String name,
        @RequestParam(name = "code", required = false)
        String personalCode,
        @RequestParam(name = "email", required = false)
        String email
    );

    @GetMapping("/{id}")
    PersonDto getPersonById(@PathVariable int id);
}