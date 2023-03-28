package co.wisesystems.demo.service1.config;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@Configuration
@ConfigurationProperties(prefix = "jwt.auth.converter")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JwtAuthConverterProperties {
    String resourceId;
    String principalAttribute;
}