package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {
	@Id
	/*@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1") */
	/*@GenericGenerator(name="gen1",strategy="identity")
	@GeneratedValue(generator="gen1") */
	/*@GenericGenerator(name="gen1",strategy="sequence")
	@GeneratedValue(generator="gen1") */
	/*@GenericGenerator(name="gen1",strategy="sequence", 
	                   parameters=@Parameter(name = "sequence_name", value = "eid_seq2"))
	@GeneratedValue(generator="gen1") */
	@GenericGenerator(name="gen1",strategy="seqhilo",
	                  parameters= {@Parameter(name="sequence",value="EID_SEQ2"),
	                		       @Parameter(name="max_lo",value="5")
	                               })
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
