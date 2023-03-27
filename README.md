# wisesystems-assignment
Technical assessment for Wisesystems

Authentication server-server in Java cu OpenFeign, Spring Security si Keycloak folosind resource server si JWT

Cerinte:
- Java
- Keycloak: Set up Keycloak to provide user authentication and authorization.
- JWT: Use JSON Web Tokens (JWT) for secure information transmission and implement authentication and authorization.
- Docker Compose: Use Docker Compose to containerize and deploy Keycloak and the 2 services.
- Server-Server Authentication: Implement server-server authentication between the service 1 and service 2 with Keycloak.
- Documentation: Write a README file and other relevant documentation.
- The code will be shared through github.com.
- Testing: Write automated tests to validate the functionality.

## Installation

[Keycloak Container configuration](https://github.com/razvan-puha/wisesystems-assignment/blob/main/keycloak/Configuration.md)


## Running the project
- Run ```docker compose up``` to start all 3 services

## How to obtain an authorization token for calling the services
**Must be done this way, otherwise the jwt validation will fail**
- Open a new terminal inside one of the service's containers
- Run the following command inside the terminal:<br />
```
curl --location 'http://keycloak:8080/realms/master/protocol/openid-connect/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'client_id=<app_client_id>' \
--data-urlencode 'username=<created_user_name>' \
--data-urlencode 'password=<created_user_pass>' \
--data-urlencode 'grant_type=password'
```
