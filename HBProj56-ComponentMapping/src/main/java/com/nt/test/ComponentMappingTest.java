package com.nt.test;

import com.nt.dao.PersonDetailsDAO;
import com.nt.dao.PersonDetailsDAOFactory;
import com.nt.utility.HibernateUtil;

public class ComponentMappingTest {

	public static void main(String[] args) {
		PersonDetailsDAO dao=null;
		// get DAO
		dao=PersonDetailsDAOFactory.getInstance();
		//invoke method
		dao.saveData();
		//dao.loadAllData();
		//dao.loadDataByStreet("RKstreet");
		
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}
}
