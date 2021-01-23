package com.sdssd.businessapi.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "business")
@ApiModel(value = "Business", description = "A resource representation of a business registered with cac.gov.ng")
public class Business {

	@Id
	@Column(length = 500)
	@ApiModelProperty(value = "Business RC number assigned upon registartion", required = true)
	private String rcnumber;

	@Column(length = 500)
	@ApiModelProperty(value = "Name of the business/Company registered", required = true)
	private String companyname;

	@Column(length = 500)
	@ApiModelProperty(value = "Address of the business", required = true)
	private String address;

	@Column(length = 500)
	@ApiModelProperty(value = "Date at which business is formally registered. Format is yy-mm-dd", required = true)
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
