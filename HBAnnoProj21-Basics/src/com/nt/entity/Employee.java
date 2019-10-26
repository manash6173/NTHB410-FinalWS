package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.hibernate.type.TrueFalseType;



@Entity()
@Table(name="EMPLOYEE")
//@DynamicInsert(value=true)
//@Proxy(lazy=false)
@Proxy(lazy=true,proxyClass=IEmp.class)
public final class Employee implements Serializable,IEmp {
	private int eno;
	private String ename;
	private  String desg;
	private  float salary;
	
	public Employee() {
		System.out.println("Employee: 0-param constructor");
	}
	
	@Id
	@Column(name="EID",length=10)
	@Type(type="int")
	public int getEno() {
		System.out.println("Employee.getEno()");
		return eno;
	}
	public void setEno(int eno) {
		System.out.println("Employee.setEno(-)");
		this.eno = eno;
	}
	
	
	//@Column(name="ENAME",length=15)
	@Type(type="string")
	public String getEname() {
		System.out.println("Employee.getEname()");
		return ename;
	}
	public void setEname(String ename) {
		System.out.println("Employee.setEname()");
		this.ename = ename;
	}
	
	//@Column(name="DESG",length=15)
	@Type(type="string")
	public String getDesg() {
		System.out.println("Employee.getDesg()");
		return desg;
	}
	public void setDesg(String desg) {
		System.out.println("Employee.setDesg()");
		this.desg = desg;
	}
	
	//@Column(name="SALARY",length=10,precision=2)
	@Type(type="float")
	@Transient
	public float getSalary() {
		System.out.println("Employee.getSalary()");
		return salary;
	}
	public void setSalary(float salary) {
		System.out.println("Employee.setSalary()");
		this.salary = salary;
	}

}
