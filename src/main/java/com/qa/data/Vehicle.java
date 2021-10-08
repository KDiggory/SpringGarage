package com.qa.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	
	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
	private Integer id;
	
	private String type;
	
	private Integer numOfWheels;
	
	private Integer weight;
	
	
	@ManyToOne
	private Garage garage; 
	
	
	public Vehicle(Integer id, String type, Integer numOfWheels, Integer weight) {
		super();
		this.id = id;
		this.type = type;
		this.numOfWheels = numOfWheels;
		this.weight = weight;
		
	}
	public Vehicle() { // REQUIRED default constructor
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getNumOfWheels() {
		return numOfWheels;
	}
	public void setNumOfWheels(Integer numOfWheels) {
		this.numOfWheels = numOfWheels;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Garage getGarage() {
		return garage;
	}
	public void setGarage(Garage garage) {
		this.garage = garage;
	}
	

}
