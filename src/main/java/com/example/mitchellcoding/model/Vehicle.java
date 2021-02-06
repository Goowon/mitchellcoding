package com.example.mitchellcoding.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Vehicle {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long year;

    @Column(nullable = false)
    private String make;

    @Column(nullable = false)
    private String model;

    public Vehicle() {}

    public Vehicle(Long year, String make, String model) {
        this.year = year;
        this.make = make;
        this.model = model;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }
     
    public void setModel(String model) {
        this.model = model;
    }

    public String toString() {
        return "Vehicle with year - "+year+" make - "+make+" model - "+model;
    }
}
