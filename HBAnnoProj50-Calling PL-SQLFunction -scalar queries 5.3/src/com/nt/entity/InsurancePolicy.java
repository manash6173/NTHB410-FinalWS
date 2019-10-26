package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class InsurancePolicy implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int policyId;
	private String policyName;
	private int tenure;
	private String company;
	private float initialAmount;
	

}
