## Keycloack configuration

- Run the following command in your terminal: ```docker compose run -p 8080:8080 keycloak start-dev```
- In your browser, go to [localhost](http://localhost:8080)
- Go to '**Administration Console**'
<br /><br />
![image](https://user-images.githubusercontent.com/11256106/226291564-48573aca-2d21-41e0-bdd2-2f1518763fb4.png)

- Login using the user & password specified in ```docker-compose.yml```

### Creating the clients
**IMPORTANT:** All of the following steps will be done inside the master realm

- Create a new client, 'bank-api', and also create a new role for it, called 'service' <br /><br />
![image](https://user-images.githubusercontent.com/11256106/226293087-e4f80267-6826-4194-b959-f3fa1286ba92.png)
![image](https://user-images.githubusercontent.com/11256106/226293183-89974d79-4913-4fdd-ab24-6fa94ca2f74b.png)
![image](https://user-images.githubusercontent.com/11256106/227913281-bd1a2f5d-4518-4482-a84d-58bc8937a578.png)
![image](https://user-images.githubusercontent.com/11256106/227913610-0c6a9aae-bcc7-4533-bb60-c6008237bc43.png)
![image](https://user-images.githubusercontent.com/11256106/227913708-bd1d824b-2201-4701-ae20-2924f4cb1448.png)
![image](https://user-images.githubusercontent.com/11256106/227913788-1f795826-c75e-4ad1-b5b2-78444f9cfddd.png)


- Create the second client, named 'people-api', and also create a new role for it, called 'service' <br /><br />
![image](https://user-images.githubusercontent.com/11256106/226293894-0413bff0-52af-4b6c-b80e-579a5fa24cb7.png)
![image](https://user-images.githubusercontent.com/11256106/226293183-89974d79-4913-4fdd-ab24-6fa94ca2f74b.png)
![image](https://user-images.githubusercontent.com/11256106/227914321-739e7df3-9489-4a30-97fa-15ff737ff7f6.png)
![image](https://user-images.githubusercontent.com/11256106/227914529-bca19615-d5f0-43ea-91f1-084915b7da9f.png)
![image](https://user-images.githubusercontent.com/11256106/227914599-faf55329-f8e1-41cc-b21c-7369e7af055c.png)
![image](https://user-images.githubusercontent.com/11256106/227913788-1f795826-c75e-4ad1-b5b2-78444f9cfddd.png)

- Under **Realm roles**, create a new role named '**service**'<br /><br />
![image](https://user-images.githubusercontent.com/11256106/226295008-9b9c5c33-eee3-4885-a504-dbc2f948647f.png)
![image](https://user-images.githubusercontent.com/11256106/226295105-8874e92b-7de4-4761-8eb6-e5401696e7a5.png)

- For the new created realm role, assign the previously created client roles
![image](https://user-images.githubusercontent.com/11256106/227915125-2b91a231-6726-4364-83b1-21502f7c0ac6.png)
![image](https://user-images.githubusercontent.com/11256106/227915281-790fce19-6f17-4b79-8fdd-cfb0051d9336.png)
![image](https://user-images.githubusercontent.com/11256106/227915618-a2da0ae6-7a05-4726-a3f0-1877acd70b33.png)

- Create a new user & assign the new created realm role & a password (set Temporary password option to Off, so that you won't be forced to change it later)<br /><br />
![image](https://user-images.githubusercontent.com/11256106/226295952-7bbb348a-f1fe-489b-b75e-7db01362ca20.png)
![image](https://user-images.githubusercontent.com/11256106/226296664-6a20e3ae-e0c1-4134-8d42-58ce3f021788.png)
![image](https://user-images.githubusercontent.com/11256106/226296880-24faed6a-3e68-42b6-8546-45bcb5a9412d.png)
![image](https://user-images.githubusercontent.com/11256106/226986797-c37ea628-03b5-425e-a302-972e9e548b13.png)
![image](https://user-images.githubusercontent.com/11256106/226986998-af13a8a8-eb72-4d56-ab34-237027745001.png)
![image](https://user-images.githubusercontent.com/11256106/226987185-9fd928f9-63e7-4d23-b59c-db5fb334f138.png)

- Close the docker container