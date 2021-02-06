package com.example.mitchellcoding;

import com.example.mitchellcoding.model.*;
import com.example.mitchellcoding.repository.*;
import com.example.mitchellcoding.exception.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RestController
public class VehicleController {

	@Autowired 
	private VehicleRepository vehicleRepository;

	@GetMapping
	public Iterable findAll() {
		return vehicleRepository.findAll();
	}

	@GetMapping("/{id}") 
	public Vehicle findOne(@PathVariable Long id) {
		return vehicleRepository.findById(id)
			.orElseThrow(VehicleNotFoundException::new);
	}

	@GetMapping("/year/{vehicleYear}")
	public List findByYear(@PathVariable Long vehicleYear) {
		return vehicleRepository.findByYear(vehicleYear);
	}

	@GetMapping("/make/{vehicleMake}")
	public List findByMake(@PathVariable String vehicleMake) {
		return vehicleRepository.findByMake(vehicleMake);
	}

	@GetMapping("/model/{vehicleModel}")
	public List findByModel(@PathVariable String vehicleModel) {
		return vehicleRepository.findByModel(vehicleModel);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vehicle create(@RequestBody Vehicle vehicle) {
		// TODO: check if vehicle has all of its fields and check if the year is within range.
		System.out.println(vehicle);
		return vehicleRepository.save(vehicle);
	}

	@PutMapping("/{id}")
	public Vehicle updateVehicle(@RequestBody Vehicle vehicle, @PathVariable Long id) {
		if (vehicle.getId() != id) {
			throw new VehicleIdMismatchException();
		}
		vehicleRepository.findById(id)
			.orElseThrow(VehicleNotFoundException::new);
		//TODO: validate fields for update
		return vehicleRepository.save(vehicle);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		vehicleRepository.findById(id)
			.orElseThrow(VehicleNotFoundException::new);
		vehicleRepository.deleteById(id);
	}

}