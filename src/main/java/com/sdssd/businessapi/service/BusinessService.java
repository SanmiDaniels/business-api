package com.sdssd.businessapi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sdssd.businessapi.model.Business;

@Service
public interface BusinessService {


	Optional<Business> findByRC(String rc);
	
	boolean businessExistsByName(String name);
	
	boolean rcAndNameMatches(String rc, String name);
	
}
