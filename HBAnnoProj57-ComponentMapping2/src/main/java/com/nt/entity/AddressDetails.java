package com.nt.entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class AddressDetails {
	private String houseNo;
	private String area;
	private String street;
	private  int pinCode;

}
