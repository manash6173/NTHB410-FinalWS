package com.nt.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Customer extends Person {
	private String addrs;
	private  float billAmt;
	@Override
	public String toString() {
		return "Customer ::"+super.toString()+"[addrs=" + addrs + ", billAmt=" + billAmt + "]";
	}
	
	

}
