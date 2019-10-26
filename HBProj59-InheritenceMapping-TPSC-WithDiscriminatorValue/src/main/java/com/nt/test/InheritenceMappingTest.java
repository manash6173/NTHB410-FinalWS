package com.nt.test;

import com.nt.dao.InheritenceDAO;
import com.nt.dao.InheritenceDAOFactory;
import com.nt.utility.HibernateUtil;

public class InheritenceMappingTest {

	public static void main(String[] args) {
		InheritenceDAO dao=null;
		//get DAO
		dao=InheritenceDAOFactory.getInstance();
		//save data
		//dao.saveData();
		dao.loadData();
		
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
