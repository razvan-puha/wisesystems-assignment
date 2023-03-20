package co.wisesystems.demo.service2.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity(name = "person")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "person_name", nullable = false)
    String name;

    @Column(name = "personal_code", nullable = false)
    String personalCode;

    @Column(name = "contact_email", nullable = false)
    String email;
}