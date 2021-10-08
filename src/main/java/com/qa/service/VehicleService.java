package com.qa.service;

import java.lang.annotation.Annotation;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import com.qa.data.Vehicle;

import com.qa.repo.VehicleRepo;

@Service
@Primary
public class VehicleService{
	
	public VehicleRepo repo;
//	private Vehicle vehicle;
	
//	private Garage garage;

	
	

	public VehicleService(VehicleRepo repo) {
		super();
		this.repo = repo;
	}
	public Optional<Vehicle> getVehicleById(Integer id) {
		return this.repo.findById(id);
	}

	public List<Vehicle> getAllVehicles() {
		return this.repo.findAll();
	}

	public Vehicle createVehicle(Vehicle vehicle) {
		System.out.println("Created Vehicle: " + vehicle);
		return this.repo.save(vehicle);  
	}

	public Vehicle updateVehicle(Vehicle vehicle, Integer id) {
		Vehicle toUpdate = this.repo.findById(id).get();
		toUpdate.setNumOfWheels(vehicle.getNumOfWheels());
		toUpdate.setType(vehicle.getType());
		toUpdate.setWeight(vehicle.getWeight()); 
		return this.repo.save(toUpdate);
	}

	public void deleteVehicle(Integer id, Object object) {
		this.repo.deleteById(id);
		
	}

	
	public VehicleRepo getRepo() {
		return repo;
	}

	public void setRepo(VehicleRepo repo) {
		this.repo = repo;
	}

	public Class<? extends Annotation> annotationType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String value() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
