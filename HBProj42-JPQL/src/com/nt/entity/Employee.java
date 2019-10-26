package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="EMPLOYEE")
@Data
@NamedQuery(name="DELETE_EMPS_BY_DESG",
           query="delete from Employee where desg=:job")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eno;
	private String ename;
	private String desg;
	private float salary;

}
