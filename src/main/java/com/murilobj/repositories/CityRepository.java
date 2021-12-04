package com.murilobj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.murilobj.domain.City;

@Repository
public interface CityRepository  extends JpaRepository<City, Integer> {


	
}
