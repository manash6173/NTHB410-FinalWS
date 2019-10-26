package com.nt.entity;

import lombok.Data;

@Data
public class PersonDetails {
	private int pid;
	private String pname;
	private  byte age;
	private AddressDetails addrs;

}
