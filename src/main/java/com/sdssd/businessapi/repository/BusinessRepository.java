package com.sdssd.businessapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.sdssd.businessapi.model.Business;

@Repository
@RepositoryRestResource(exported = false)
public interface BusinessRepository extends JpaRepository<Business, UUID> {

    @Query(value = "select * from business where rcnumber = :rc", nativeQuery = true)
	Business findByRCNumber(@Param("rc") String rc);
	
    @Query(value = "select * from business where rcnumber = :rc && companyname = :name", nativeQuery = true)
	Business findByRcAndName(@Param("rc") String rc, @Param("name") String name);
	
    @Query(value = "select * from business where companyname = :name", nativeQuery = true)
    Business findByName(@Param("name") String name);
    
}