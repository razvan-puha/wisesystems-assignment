## Keycloack configuration

- Run the following command in your terminal: ```docker compose up``` (this will create all the containers for the services, but we will use only the keycloak for now)
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


- Create the second client, named 'people-api', and configure it like in the screenshots <br /><br />
![image](https://user-images.githubusercontent.com/11256106/226293894-0413bff0-52af-4b6c-b80e-579a5fa24cb7.png)
![image](https://user-images.githubusercontent.com/11256106/228242341-0b7d2b40-afe3-48ff-b147-1c7013dc1e45.png)
![image](https://user-images.githubusercontent.com/11256106/227914321-739e7df3-9489-4a30-97fa-15ff737ff7f6.png)

- For 'people-api' client, add a new role, called 'service' <br /><br />
![image](https://user-images.githubusercontent.com/11256106/228243498-0a05ef92-ae36-459e-bc1f-934258736a35.png)
![image](https://user-images.githubusercontent.com/11256106/228243645-06ab3d5b-3c43-47f7-b434-616f6048b1bc.png)
![image](https://user-images.githubusercontent.com/11256106/227913788-1f795826-c75e-4ad1-b5b2-78444f9cfddd.png)

- For the same client as above, assign the new created role to the service account <br /><br />
![image](https://user-images.githubusercontent.com/11256106/228244067-c92532e8-1086-4440-8fe2-a8fa1afbaa77.png)
![image](https://user-images.githubusercontent.com/11256106/228244222-1842dea2-f24e-47ec-b38d-a1bb22004748.png)
![image](https://user-images.githubusercontent.com/11256106/228244354-3dd6aadc-7159-415f-be17-2c4841afd253.png)

- Again, for 'people-api' client, go under 'Credentials' & copy the generated client secret & paste it in ```docker-compose.yml```, under ```service1.environment.FEIGN_CLIENT_SECRET``` <br /><br />
![image](https://user-images.githubusercontent.com/11256106/228244881-b6b43ed5-aea8-4cb4-8a78-7ab6757da748.png)
![image](https://user-images.githubusercontent.com/11256106/228245368-45270477-6b30-4de8-aeb3-703ca503636a.png)
![image](https://user-images.githubusercontent.com/11256106/228245621-d34937cc-6714-490d-9127-a173f97d6895.png)

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

- Close the docker compose command to shut down the containers (we need to do this because we've modified the ```docker-compose.yml```; at the next start it will fetch the new env values)
