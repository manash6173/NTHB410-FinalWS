package com.nt.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable {
	private int eno;
	private String ename;
	private  String desg;
	private  float salary;
	

}
