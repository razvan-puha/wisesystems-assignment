package co.wisesystems.demo.service2.dto;

import lombok.Value;

@Value(staticConstructor = "of")
public class PersonDto {
    int id;
    String name;
    String personalCode;
    String email;
}