package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

import lombok.Data;

@Entity
@Data
@NamedNativeQuery(name="CALL_FX",
                  query="{?=call fx_get_Policies_by_tenure(?,?) }",
                  callable=true,
                  resultClass=InsurancePolicy.class) 
public class InsurancePolicy implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int policyId;
	private String policyName;
	private String company;
	private int tenure;
	private float initialamount;

}
