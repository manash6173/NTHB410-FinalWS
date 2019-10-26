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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;
import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Data
@Polymorphism(type=PolymorphismType.EXPLICIT)
public abstract class Payment implements Serializable {
	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
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
