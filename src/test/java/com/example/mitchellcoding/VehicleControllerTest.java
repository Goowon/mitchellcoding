package com.example.mitchellcoding;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import com.example.mitchellcoding.model.Vehicle;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;


@SpringBootTest
public class VehicleControllerTest {
    
    private static final String API_ROOT = "http://localhost:8080/";

    private Vehicle createRandomVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setYear((long)(Math.random() * (2020 - 1950 + 1) + 1950));
        vehicle.setMake(randomAlphabetic(10));
        vehicle.setModel(randomAlphabetic(10));
        return vehicle;
    }

    private String createVehicleAsUri(Vehicle vehicle) {
        Response response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(vehicle)
            .post(API_ROOT);
        return API_ROOT + "/" + response.jsonPath().get("id");
    }

    @Test
    public void whenGetAllVehicles_thenOK() {
        Response response = RestAssured.get(API_ROOT);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Test
    public void whenGetVehicleByYear_thenOK() {
        Vehicle vehicle = createRandomVehicle();
        createVehicleAsUri(vehicle); 
        Response response = RestAssured.get(API_ROOT + "/year/" + vehicle.getYear());

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertTrue(response.as(List.class).size() > 0);
    }

}