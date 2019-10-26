package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;
import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Table(name="INH_PAYMENT3")
@Inheritance(strategy=InheritanceType.JOINED)
@Data
@DiscriminatorColumn(name="PAYMENT_MODE",discriminatorType=DiscriminatorType.STRING,length=10)
@Polymorphism(type=PolymorphismType.EXPLICIT)
public abstract class Payment implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length=15)
	@Type(type="long")
	private long txId;
	
	@Column(length=10)
	@Type(type="float")
	private float amount;
	
	@Column(length=10)
	@Type(type="string")
	private String location;
	
	

}
