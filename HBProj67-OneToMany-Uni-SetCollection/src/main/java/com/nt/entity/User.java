package com.nt.entity;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@ToString
public class User {
	private int userId;
	private String uname;
	private String addrs;
	private Set<PhoneNumber> phones;
	
	public User() {
		System.out.println("User:0-param constructor");
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", uname=" + uname + ", addrs=" + addrs + "]";
	}
	
	
	

}
