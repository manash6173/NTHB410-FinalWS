package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {
	@Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
/*	@SequenceGenerator(name="gen1",sequenceName="EID_JPA_SEQ",initialValue=500,allocationSize=10)
	@GeneratedValue(generator="gen1") */
	
	/*@TableGenerator(name="gen1",table="ID_TAB",
	                pkColumnName="ID_PK",pkColumnValue="VAL",
	                initialValue=100,allocationSize=5,
 	                valueColumnName="ID_VAL") 
	  
    @GeneratedValue(generator="gen1",strategy=GenerationType.TABLE) */
	
	//@GeneratedValue(strategy=GenerationType.TABLE)
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EID",length=10)
	@Type(type="int")
	private int eno;
	
	@Basic(fetch=FetchType.LAZY,optional=true)
	private String ename;
	@Basic
	private  String desg;
	@Basic
	private  float salary;
	
	
}
