package com.nt.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
//@ToString
public class PhoneNumber {
	private long phone;
	private String numberType;
	private String provider;
	
	public PhoneNumber() {
	 System.out.println("PhoneNumber:0-param constructor");
	}

	@Override
	public String toString() {
		return "PhoneNumber [phone=" + phone + ", numberType=" + numberType + ", provider=" + provider + "]";
	}
	
	

}
