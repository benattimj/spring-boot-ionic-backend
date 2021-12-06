package com.murilobj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.murilobj.domain.Address;

@Repository
public interface AddressRepository  extends JpaRepository<Address, Integer> {


	
}
