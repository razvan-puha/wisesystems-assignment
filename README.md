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

# Installation

- ```docker compose run -p 8080:8080 keycloak start-dev```
- In your browser, go to [localhost](http://localhost:8080)
- Go to '**Administration Console**'
<br /><br />
![image](https://user-images.githubusercontent.com/11256106/226291564-48573aca-2d21-41e0-bdd2-2f1518763fb4.png)

- Login using the user & password specified in ```docker-compose.yml```

- Create a new realm, '**Services**'<br /><br />
![image](https://user-images.githubusercontent.com/11256106/226292209-95272df9-653c-4b1f-b97b-8eae7e55d7e7.png)
![image](https://user-images.githubusercontent.com/11256106/226292340-b6abe3f1-2a2a-40b8-b7e6-41bf71f796d7.png)

- Select the new created realm and create a new client, 'bank-api', with the valid redirect URI as ```http://localhost:9000```<br /><br />
![image](https://user-images.githubusercontent.com/11256106/226293087-e4f80267-6826-4194-b959-f3fa1286ba92.png)
![image](https://user-images.githubusercontent.com/11256106/226293183-89974d79-4913-4fdd-ab24-6fa94ca2f74b.png)
![image](https://user-images.githubusercontent.com/11256106/226293347-6180da77-0374-44f8-b1c8-c483358a4363.png)

- Create the second client, named 'people-api', with the valid redirect URI as ```http://localhost:9090```<br /><br />
![image](https://user-images.githubusercontent.com/11256106/226293894-0413bff0-52af-4b6c-b80e-579a5fa24cb7.png)
![image](https://user-images.githubusercontent.com/11256106/226293183-89974d79-4913-4fdd-ab24-6fa94ca2f74b.png)
![image](https://user-images.githubusercontent.com/11256106/226294125-de94b1fb-ba74-43ab-ab3e-8dd42fd3ae10.png)

- Under **Realm roles**, create a new role named '**service**'<br /><br />
![image](https://user-images.githubusercontent.com/11256106/226295008-9b9c5c33-eee3-4885-a504-dbc2f948647f.png)
![image](https://user-images.githubusercontent.com/11256106/226295105-8874e92b-7de4-4761-8eb6-e5401696e7a5.png)

- Create a new user & assign the new created role & a password (set Temporary password option to Off, so that you won't be forced to change it at the first login)<br /><br />
![image](https://user-images.githubusercontent.com/11256106/226295952-7bbb348a-f1fe-489b-b75e-7db01362ca20.png)
![image](https://user-images.githubusercontent.com/11256106/226296664-6a20e3ae-e0c1-4134-8d42-58ce3f021788.png)
![image](https://user-images.githubusercontent.com/11256106/226296880-24faed6a-3e68-42b6-8546-45bcb5a9412d.png)
![image](https://user-images.githubusercontent.com/11256106/226986797-c37ea628-03b5-425e-a302-972e9e548b13.png)
![image](https://user-images.githubusercontent.com/11256106/226986998-af13a8a8-eb72-4d56-ab34-237027745001.png)
![image](https://user-images.githubusercontent.com/11256106/226987185-9fd928f9-63e7-4d23-b59c-db5fb334f138.png)

- Close the keycloack container & run ```docker compose up``` to start all 3 services
