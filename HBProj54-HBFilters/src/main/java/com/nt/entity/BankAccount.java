package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class BankAccount implements Serializable {
	private int acno;
	private String hodlerName;
	private  float balance;
	private  String status;

}
