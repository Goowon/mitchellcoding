package com.example.mitchellcoding.repository;

import com.example.mitchellcoding.model.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
    List<Vehicle> findByYear(Long year);
    
    List<Vehicle> findByMake(String make);

    List<Vehicle> findByModel(String model);
}