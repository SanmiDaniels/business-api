package com.sdssd.businessapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sdssd.businessapi.model.Business;
import com.sdssd.businessapi.service.BusinessService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1/business")
public class BusinessController {

	@Autowired
	private BusinessService businessService;
	
	@GetMapping("/{rc}")
	@ApiOperation( 
		    value = "Finds a business by RC number", 
		    notes = "Though the RC value is seemingly a number, a string is used"
		    		+ " here to accommodates values with characters mixed with numbers", 
		    response = Business.class
		)
	public ResponseEntity<?> getBusinessByRC(@ApiParam(value ="RC number", required = true) @PathVariable String rc){
	
		Optional<Business> business = businessService.findByRC(rc);
		
		if(business.isPresent()) {
			return new ResponseEntity<>(business.get(), HttpStatus.OK);
		} else return new ResponseEntity<>("Business not found", HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/matches")
	@ApiOperation( 
		    value = "Checks if the business name and RC number matches to an exact business",  
		    response = boolean.class
		)
	public ResponseEntity<?> checkIfDetailsMatch(@ApiParam(value ="RC number", required = true) @RequestParam String rcnumber,
			@ApiParam(value ="Name of the business", required = true) @RequestParam String name){
		
		boolean match = businessService.rcAndNameMatches(rcnumber, name);
		
		if(match) {
			return new ResponseEntity<>(match, HttpStatus.OK);	
		} else return new ResponseEntity<>(match, HttpStatus.OK);
		
	}
	
	@GetMapping("/exists")
	@ApiOperation( 
		    value = "Checks if a particular business exists by name",  
		    response = boolean.class
		)
	public ResponseEntity<?> businessExists(@ApiParam(value ="Name of the business", required = true) @RequestParam String name){
		
		boolean exists = businessService.businessExistsByName(name);
		
		if(exists) {
			return new ResponseEntity<>(exists, HttpStatus.OK);	
		} else return new ResponseEntity<>(exists, HttpStatus.OK);		
		
	}
	
	
	
	
	
}