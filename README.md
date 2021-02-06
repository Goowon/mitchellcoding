# Mitchell Coding Challenge

## How to Run

in the complete directory, run `./mvnw spring-boot:run` in your terminal. The port is 8080.

localhost:8080

The different endpoints I have are:
- GET /
    returns a list of all vehicles.
- GET /{id}
    returns a vehicle with that Id if it exists.
- GET /year/{year}
    returns a list of vehicles with that year.
- GET /make/{make}
    returns a list of vehicles with that make.
- GET /model/{model}
    returns a list of vehicles with that model.
- POST / with a body
    returns 201 if it was successfully created and returns the created Vehicle.
- PUT /{id} with a body
    updates the vehicle with id in both body and path. fails otherwise.
- DELETE /{id}
    deleted the vehicle if it exists.

## Design

I decided to use Spring Boot to build this project as it has many packages available due to how widely supported it is. Specifically, I used Spring-Data for the persistence with H2 database. I also used JUnit for the testing but ended up not finishing due to learning an older iteration.


### Vehicle.java
This is the model class which is the Entity that is stored into the database. It also defines the fields which are make, model, and year.


### VehicleController.java
This class has all of the API endpoints exposed and connects the API to the repository functionality. I have Get, Put, Post, and Delete routes as well as corresponding exceptions for when things go wrong. I have not added any validation but it would go in this class.

### Exceptions
I created three exceptions called InvalidEntry, VehicleIdMismatch, and VehicleNotFound. Respectively, these are for when a vehicle body does not pass validation, when we try to update a vehicle but the Id does not match the body, and when a vehicle that we attempt to update/delete is not in the database. 

### VehicleRepository.java
The repository then interacts with the database using my Vehicle model.


