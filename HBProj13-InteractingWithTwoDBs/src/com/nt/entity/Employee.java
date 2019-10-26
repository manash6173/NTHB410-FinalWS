package com.nt.entity;

import java.io.Serializable;

public class Employee implements Serializable {
	private int eno;
	private String ename;
	private  String desg;
	private  float salary;
	
	public Employee() {
		System.out.println("Employee: 0-param constructor");
	}
	
	public int getEno() {
		System.out.println("Employee.getEno()");
		return eno;
	}
	public void setEno(int eno) {
		System.out.println("Employee.setEno(-)");
		this.eno = eno;
	}
	public String getEname() {
		System.out.println("Employee.getEname()");
		return ename;
	}
	public void setEname(String ename) {
		System.out.println("Employee.setEname()");
		this.ename = ename;
	}
	public String getDesg() {
		System.out.println("Employee.getDesg()");
		return desg;
	}
	public void setDesg(String desg) {
		System.out.println("Employee.setDesg()");
		this.desg = desg;
	}
	public float getSalary() {
		System.out.println("Employee.getSalary()");
		return salary;
	}
	public void setSalary(float salary) {
		System.out.println("Employee.setSalary()");
		this.salary = salary;
	}

}
