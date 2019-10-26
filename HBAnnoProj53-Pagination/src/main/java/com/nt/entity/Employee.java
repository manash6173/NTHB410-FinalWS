package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eno;
	private String ename;
	private  String desg;
	private  float salary;
	

}
