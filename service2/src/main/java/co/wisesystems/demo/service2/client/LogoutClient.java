package co.wisesystems.demo.service2.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "logout-client", url = "${spring.security.oauth2.resourceserver.jwt.issuer-uri}/protocol/openid-connect/logout")
public interface LogoutClient {

    @GetMapping
    ResponseEntity<String> performLogout(@RequestParam("id_token_hint") String idTokenHint);
}