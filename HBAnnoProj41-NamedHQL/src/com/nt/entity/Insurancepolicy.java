package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

// Generated May 20, 2019 5:03:09 PM by Hibernate Tools 5.2.3.Final

@Entity
@NamedQuery(name="GET_POLICIES_BY_COMP",query="from Insurancepolicy where company=:comp")
@NamedQuery(name="UPD_POLICY_BY_NAME",query="update Insurancepolicy set initialamount=initialamount+:amt where policyname=:name")
public class Insurancepolicy implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int policyid;
	private String policyname;
	private Long tenure;
	private String company;
	private float initialamount;

	public Insurancepolicy() {
		System.out.println("InsurancePolicy:0-param constructor");
	}

	public Insurancepolicy(int policyid) {
		this.policyid = policyid;
	}

	public Insurancepolicy(int policyid, String policyname, Long tenure, String company, float initialamount) {
		this.policyid = policyid;
		this.policyname = policyname;
		this.tenure = tenure;
		this.company = company;
		this.initialamount = initialamount;
	}

	public int getPolicyid() {
		return this.policyid;
	}

	public void setPolicyid(int policyid) {
		this.policyid = policyid;
	}

	public String getPolicyname() {
		return this.policyname;
	}

	public void setPolicyname(String policyname) {
		this.policyname = policyname;
	}

	public Long getTenure() {
		return this.tenure;
	}

	public void setTenure(Long tenure) {
		this.tenure = tenure;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public float getInitialamount() {
		return this.initialamount;
	}

	public void setInitialamount(float initialamount) {
		this.initialamount = initialamount;
	}

	@Override
	public String toString() {
		return "Insurancepolicy [policyid=" + policyid + ", policyname=" + policyname + ", tenure=" + tenure
				+ ", company=" + company + ", initialamount=" + initialamount + "]";
	}
	
	

}
