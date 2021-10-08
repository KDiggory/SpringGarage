package com.qa.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.data.Vehicle;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {
	
	Optional<Vehicle> findById (Integer id);
	
//	List<Vehicle> findByType(String type);
//	
//	List<Vehicle> findByNumOfWheels(Integer wheels);
//	
//	List<Vehicle> findbyWeight(Integer weight);
//	
//	List<Vehicle> findByGarageId(Integer garageId);
	// something in here stops it from running - not sure what
	
	
}