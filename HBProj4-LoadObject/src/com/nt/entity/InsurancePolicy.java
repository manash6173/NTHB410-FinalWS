package com.nt.entity;

import java.io.Serializable;

public final class InsurancePolicy implements Serializable{
	private int  policyId;
	private String  policyName;
	private int tenure;
	private String company;
	private float initialAmount;
	
	public InsurancePolicy() {
		System.out.println("InsurancePolicy::0-param constructor");
	}
	
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String  getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public  int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public float getInitialAmount() {
		return initialAmount;
	}
	public void setInitialAmount(float initialAmount) {
		this.initialAmount = initialAmount;
	}
	

}
