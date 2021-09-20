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
- To get started simply clone the repository:

`git clone https://github.com/Revature-Tech-Support/TechSupport-Authentication.git`

- As well as cloning the gateway and eureka server

`git clone https://github.com/Revature-Tech-Support/TechSupport-Gateway.git`

- To run you'll also need to have a docker container with Cassandra running.
- Open the projects in IntelliJ, and start up the eureka and gateway services. Then all you have to do is run the AuthenicationApp to get the service running.


## Endpoints
### localhost:8080/user
- Takes POST requests with JSON in the request body. JSON should have keys "username", "password", and "isTechAgent". 
- This will cause the microservice to create a new user in the cassandra database with a unique userID. 
- The service will then return status 200 along with a JSON response body consisting of the new user's "userID", "username" and "isTechAgent". 
- If a user with the same username is already in the database, then the program returns an empty body response and does not create a new user. 
- Passwords are encrypted before being put into the database.

### localhost:8080/user/login
- Takes GET requests with JSON in the request body. JSON should have keys "username" and "password". 
- The microservice will then find a user with the same username in the database and check if the provided password is a match with the encrypted one in the database.
- If the passwords match, the service return status 200 along with a JSON response body consisting of the new user's "userID", "username" and "isTechAgent".
- If the passwords do not match or there is no user with that user name, the service return status 200 and an empty body response.
