package com.nt.test;

import com.nt.dao.AirtelCallerTuneDAO;
import com.nt.dao.AirtelCallerTuneDAOFactory;
import com.nt.utility.HibernateUtil;

public class VersioningTest {

	public static void main(String[] args) {
		AirtelCallerTuneDAO dao=null;
		//get DAO
		dao=AirtelCallerTuneDAOFactory.getInstance();
		//invoke methods
		//dao.saveData();
		dao.loadAndModifyData();
		
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
		

	}

}
