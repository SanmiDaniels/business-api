package com.sdssd.businessapi.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "business")
public class Business {

    @Id
    @JsonIgnore
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    
    
    private String rcnumber;
    
    private String companyname;
    
    private String address;
    
    private String dateOfReg;

    
    public Business() {
	
	}

	public Business(String rcnumber, String companyname, String address, String dateOfReg) {
		this.rcnumber = rcnumber;
		this.companyname = companyname;
		this.address = address;
		this.dateOfReg = dateOfReg;
	}



	public String getRcnumber() {
		return rcnumber;
	}

	public void setRcnumber(String rcnumber) {
		this.rcnumber = rcnumber;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateOfReg() {
		return dateOfReg;
	}

	public void setDateOfReg(String dateOfReg) {
		this.dateOfReg = dateOfReg;
	}
	
}
