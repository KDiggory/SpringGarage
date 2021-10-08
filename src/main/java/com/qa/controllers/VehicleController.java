package com.qa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.data.Vehicle;
import com.qa.service.VehicleService;

@RestController
public class VehicleController {
	
	private VehicleService service;
	
	public VehicleController(VehicleService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getVehicleById/{id}")
	public Optional<Vehicle> getVehicleByIndex(@PathVariable Integer id) {
		return this.service.getVehicleById(id);
		
	}
	
	
	@GetMapping("/getAllVehicles")
	public List<Vehicle> getAllVehicles() {
		service.getAllVehicles().forEach(n -> System.out.println(n));
		return this.service.getAllVehicles();
	}
	
	@PostMapping("/createVehicle")
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
	Vehicle responseBody = this.service.createVehicle(vehicle);
	ResponseEntity<Vehicle> response = new ResponseEntity<Vehicle>(responseBody, HttpStatus.CREATED);
	return response;
	}
	
	
	@PutMapping("/updateVehicle/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle, @PathVariable Integer id) {
		Vehicle responseBody = this.service.updateVehicle(vehicle, id);
		return new ResponseEntity<Vehicle>(responseBody, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/removeVehicle/{id}")
	public ResponseEntity<Vehicle> deleteVehicle(@PathVariable Integer id) {
		this.service.deleteVehicle(id, null);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	

}
