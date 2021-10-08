package com.qa.service;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.data.Garage;

import com.qa.repo.GarageRepo;
//import exception.GarageNotFoundException;




@Service

public class GarageService {

	public GarageRepo repo;
	
	private Garage garage;
	
	public GarageService(GarageRepo repo) {
		super();
		this.repo = repo;
	}



	public List<Garage> getAllIds() {
		return this.repo.findAll();
		
	}

	public Optional<Garage> getByIndex(Integer id) {
		
		return this.repo.findById(id); //.orElseThrow(GarageNotFoundException::new);
	}

	public Garage updateId(Garage garage, Integer id) {
		Garage toUpdate = this.repo.findById(id).get();
		toUpdate.setName(garage.getName());
		toUpdate.setAddress(garage.getAddress());
		return this.repo.save(toUpdate);
	}

	public void deleteId(Integer id, Object object) {
		this.repo.deleteById(id);
		
	}


	public Garage createGarage(Garage garage) {
		System.out.println("CREATED Garage: " + garage);
		return this.repo.saveAndFlush(garage);  
		
	}

	public Object getGarage() {
		return garage;
	}

	public void setGarage(Garage garage) {
		this.garage = garage;
	}

	

}
