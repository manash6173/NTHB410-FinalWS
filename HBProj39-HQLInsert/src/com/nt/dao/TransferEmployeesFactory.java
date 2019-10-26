package com.nt.dao;

public class TransferEmployeesFactory {
	
	public static TransferEmployeeDAO getInstance() {
		return new TransferEmployeeDAOImpl();
	}

}
