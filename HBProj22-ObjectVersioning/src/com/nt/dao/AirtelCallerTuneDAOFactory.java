package com.nt.dao;

public class AirtelCallerTuneDAOFactory {
	
	public static AirtelCallerTuneDAO getInstance() {
		return new AirtelCallerTuneDAOImpl();
	}

}
