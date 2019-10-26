package com.nt.dao;

import java.util.List;

public interface InsurancePolicyDAO {
	public  List<Object[]> getPoliciesByCompany(String company);

}
