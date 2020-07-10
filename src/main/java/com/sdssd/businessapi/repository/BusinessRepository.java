package com.sdssd.businessapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdssd.businessapi.model.Business;

@Repository
public interface BusinessRepository extends JpaRepository<Business, UUID> {

	
	
	
	
}