package co.wisesystems.demo.service2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PersonRequestBody {

    @NotBlank(message = "Person's name is required")
    String name;

    @NotBlank(message = "Person's personal code is required")
    @Pattern(regexp = "^\\d{13}$", message = "Person's personal code is has only 13 digits")
    String personalCode;

    @NotBlank(message = "Person's email is required")
    @Pattern(regexp = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$")
    String email;
}