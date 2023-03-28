package co.wisesystems.demo.service1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Disabled("Disabled until the keycloak integration works!")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Service1ApplicationTests {

    @Test
    void contextLoads() {
    }

}
