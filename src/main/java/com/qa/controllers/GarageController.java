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

import com.qa.data.Garage;
import com.qa.service.GarageService;

@RestController
public class GarageController {
	
private GarageService service;

	
	public GarageController(GarageService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getGarageById/{id}")
	public Optional<Garage> getByIndex(@PathVariable Integer id) {
		return this.service.getByIndex(id);
		
	}
	
	@GetMapping("/getAllGarageIds")
	public List<Garage> getAllIds() {
		service.getAllIds().forEach(n -> System.out.println(n));
		return this.service.getAllIds();
	}
	
	@PostMapping("/createGarage") // this needs to assign a garage id to a vehicle
	public ResponseEntity<Garage> createGarage(@RequestBody Garage garage) {
	Garage responseBody = this.service.createGarage(garage);
	ResponseEntity<Garage> response = new ResponseEntity<Garage>(responseBody, HttpStatus.CREATED);
	return response;
	}
	
	
	
	@PutMapping("/updateGarageId/{id}")
	public ResponseEntity<Garage> updateVehicle(@RequestBody Garage garage, @PathVariable Integer id) {
		Garage responseBody = this.service.updateId(garage, id);
		return new ResponseEntity<Garage>(responseBody, HttpStatus.ACCEPTED);
		// need to pass in id and garage id also put repo into garage service. 
	}
	
	@DeleteMapping("/removeGarageId/{id}")
	public ResponseEntity<Garage> deleteVehicle(@PathVariable Integer id) {
		this.service.deleteId(id, null);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}

}
