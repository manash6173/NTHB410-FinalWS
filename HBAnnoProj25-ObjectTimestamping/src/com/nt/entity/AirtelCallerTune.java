package com.nt.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;



@Entity
@Table(name="AIRTEL_CALLERTUNE2")
@Data
public class AirtelCallerTune implements Serializable {
	@Id
	@Column(name="CUSTID",length=10)
	@Type(type="int")
	private int custId;
	
	@Column(name="CUSTNAME",length=15)
	@Type(type="string")
	private String custName;
	
	@Column(name="MOBILENO",length=10)
	@Type(type="long")
	private long mobileNo;
	
	@Column(name="CALLERTUNE",length=10)
	@Type(type="string")
	private String callerTune;
	
	@Column(name="CHANGESCOUNT",length=10)
	@Type(type="int")
	@Version
	private int changesCount;
	
	@Column(name="SUBSCRIBEDDATE")
	@Type(type="timestamp")
	@CreationTimestamp
	private Timestamp  subscribedDate;
	
	@Column(name="LASTUPDATED")
	@Type(type="timestamp")
	@UpdateTimestamp
	private Timestamp  lastUpdated;
	

}
