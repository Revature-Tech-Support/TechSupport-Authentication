# TechSupport-Authentication
Repository for the authentication feature in the application.


## Client Specifications:
- Test Driven Development (TDD)


## Goal:
User registration and login services that includes a simple authentication check.


## User Stories:
### IT Support Professional
- As a IT Support Professional
- I want authentication
- So that I can create an account and/or login to an existing account

### User
- As a User
- I want authentication
- So that I can create an account and/or login to an existing account


## Technology:
- Java 11
- Docker
- Spring Boot
- Spring Webflux
- Spring Data
- Cassandra
- Karate
- BCrypt


## Getting Started
- To get started, simply clone the repository:

`git clone https://github.com/Revature-Tech-Support/TechSupport-Authentication.git`

- As well as cloning the gateway and eureka server

`git clone https://github.com/Revature-Tech-Support/TechSupport-Gateway.git`

- To run the repositories, you'll also need to have a Docker container with Cassandra running.
- Open the projects in your IDE, and start up the Eureka and Gateway services. Then all you have to do is run the AuthenicationApp to get the service running.
- Alternatively, you can cd into the repository folder on your computer and run ```mvn spring-boot:run``` in the command line.


## Endpoints
- POST `localhost:8080/user`
  - Takes POST requests with JSON in the request body. JSON should have keys "username", "password", and "isTechAgent". 
  - This will create a new user in the Cassandra database with a unique userID. 
  - If the creation is successful, the service will then return status "200" along with a JSON response body consisting of the new user's "userID", "username" and "isTechAgent". 
  - If a user with the same username is already in the database, then the program returns an empty body response and does not create a new user. 
  - Passwords are encrypted before being inserted into the database.

- POST `localhost:8080/user/login`
  - Takes POST requests with JSON in the request body. JSON should have keys "username" and "password". 
  - The microservice will then find a user with the same username in the database and check if the provided password is a match with the encrypted one in the database.
  - If the passwords match, the service returns status "200" along with a JSON response body consisting of the new user's "userID", "username" and "isTechAgent".
  - If the passwords do not match or there is no user with that username, the service returns status "200" and an empty body response.
