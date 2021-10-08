package com.qa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.data.Garage;



@Repository
public interface GarageRepo extends JpaRepository<Garage, Integer> {

	List<Garage> findByName(String name);

	//Optional<Garage> findById (Integer id);
//	
//	
//	List<Garage> findByAddress(String address);
	

}