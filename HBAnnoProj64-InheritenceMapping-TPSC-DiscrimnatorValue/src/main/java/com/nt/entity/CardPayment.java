package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="INH_CARDPAYMENT3")
@PrimaryKeyJoinColumn(name="TX_ID",referencedColumnName="TXID")
@DiscriminatorValue("CARD")
@Getter
@Setter
public class CardPayment extends Payment {
	@Column(length=16)
	@Type(type="long")
	private long cardNo;
	@Column(length=10)
	@Type(type="string")
	private String cardType;
	
	@Column(length=3)
	@Type(type="int")
	private int cvvNo;

	@Override
	public String toString() {
		return super.toString()+"==CardPayment [cardNo=" + cardNo + ", cardType=" + cardType + ", cvvNo=" + cvvNo + "]";
	}
}
