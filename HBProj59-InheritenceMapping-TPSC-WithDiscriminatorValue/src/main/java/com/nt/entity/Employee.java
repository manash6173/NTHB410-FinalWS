package com.nt.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee extends Person {
	private String desg;
	private float salary;
	
	@Override
	public String toString() {
		return "Employee::"+super.toString()+" [desg=" + desg + ", salary=" + salary + "]";
	}
	

}
