package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Employee implements Serializable {
	private int eno;
	private String ename;
	private  String desg;
	private  float salary;
	private int age1;
	
}
