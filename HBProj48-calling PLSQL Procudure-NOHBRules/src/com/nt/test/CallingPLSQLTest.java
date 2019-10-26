package com.nt.test;

import com.nt.dao.AuthDAO;
import com.nt.dao.AuthDAOFactory;
import com.nt.utility.HibernateUtil;

public class CallingPLSQLTest {

	public static void main(String[] args) {
		AuthDAO dao=null;
		//get DAO
		dao=AuthDAOFactory.getInstance();
		//invoke method
		System.out.println(dao.authenticate("raja","rani"));
		//close SEssion factory
		HibernateUtil.closeSessionFactory();
	}

}
