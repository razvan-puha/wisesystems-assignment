package co.wisesystems.demo.service1.dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value(staticConstructor = "of")
public class BankAccountDto {
    int id;
    LocalDateTime createdOn;
    String personName;
    String personPersonalCode;
    String personEmail;
}