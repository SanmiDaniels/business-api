package com.sdssd.businessapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdssd.businessapi.model.Business;
import com.sdssd.businessapi.repository.BusinessRepository;

@Service
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	private BusinessRepository businessRepo;

	@Override
	public Optional<Business> findByRC(String rc) {

		Business business = businessRepo.findByRCNumber(rc);

	//	return Optional.of(business);
		return Optional.ofNullable(business);
	}

	@Override
	public boolean businessExistsByName(String name) {

		var business = businessRepo.findByName(name.toUpperCase());

		if (business != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean rcAndNameMatches(String rc, String name) {

		var business = businessRepo.findByRcAndName(rc, name.toUpperCase());

		if (business != null)
			return true;
		else
			return false;

	}

}
