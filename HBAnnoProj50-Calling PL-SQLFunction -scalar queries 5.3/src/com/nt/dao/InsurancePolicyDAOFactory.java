package com.nt.dao;

public class InsurancePolicyDAOFactory {
	
	public static  InsurancePolicyDAO getInstance() {
		return new InsurancePolocyDAOImpl();
	}

}
