package com.nt.test;

import com.nt.dao.TransferDAO;
import com.nt.dao.TransferDAOFactory;
import com.nt.utility.MySQLHibernateUtil;
import com.nt.utility.OracleHibernateUtil;

public class InteractingWithTwoDBsTest {

	public static void main(String[] args) {
		TransferDAO dao=null;
		//get DAO
		dao=TransferDAOFactory.getInstance();
		//invoke method
		System.out.println("Record Transfered??"+dao.transferEmployee(7089));
		
		//close SEssion factory
		OracleHibernateUtil.closeSessionFactory();
		MySQLHibernateUtil.closeSessionFactory();
	}
}
