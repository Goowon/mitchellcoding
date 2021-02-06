# Mitchell Coding Challenge

## Design

I decided to use Spring Boot to build this project as it has many packages available due to how widely supported it is. Specifically, I used Spring-Data for the persistence with H2 database. I also used JUnit for the testing but ended up not finishing due to learning an older iteration.


### Vehicle.java
This is the model class which is the Entity that is stored into the database. It also defines the fields which are make, model, and year.


### VehicleController.java
This class has all of the API endpoints exposed and connects the API to the repository functionality. I have Get, Put, Post, and Delete routes as well as corresponding exceptions for when things go wrong. I have not added any validation but it would go in this class.

### Exceptions
I created three exceptions called InvalidEntry, VehicleIdMismatch, and VehicleNotFound. Respectively, these are for when a vehicle body does not pass validation, when we try to delete or update a vehicle but the Id does not match the body, and when a vehicle that we attempt to update/delete is not in the database. 

### VehicleRepository.java
The repository then interacts with the database using my Vehicle model.
