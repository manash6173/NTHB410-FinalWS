package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("CHEQUE")
@Getter
@Setter
@Polymorphism(type=PolymorphismType.EXPLICIT)
public class ChequePayment extends Payment {
	@Column(length=7)
	@Type(type="int")
	private int chequeNo;
	
	@Column(length=10)
	@Type(type="string")
	private String chequeType;
	
	@Column(length=10)
	@Type(type="string")
	private String bankName;

	@Override
	public String toString() {
		return super.toString()+"==ChequePayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + ", bankName=" + bankName + "]";
	}
	
	

	
}
