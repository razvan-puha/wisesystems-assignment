package co.wisesystems.demo.service1.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PersonRequestBody {
    String name;

    @Pattern(regexp = "^\\d{13}$", message = "Person's personal code is has only 13 digits")
    String personalCode;

    @Pattern(regexp = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$")
    String email;
}