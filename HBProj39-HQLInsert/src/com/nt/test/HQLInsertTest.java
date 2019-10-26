package com.nt.test;

import java.sql.SQLException;

import com.nt.dao.TransferEmployeeDAO;
import com.nt.dao.TransferEmployeesFactory;
import com.nt.utility.HibernateUtil;

public class HQLInsertTest {

	public static void main(String[] args) {
		TransferEmployeeDAO dao=null;
		int count=0;
		//get DAO
		dao=TransferEmployeesFactory.getInstance();
		//use DAO
		count=dao.trasferEmployeesAsNGOs(40000, 100000);
		System.out.println(count+" no.of emps are transfered");
		
         //close sessionfactory
		HibernateUtil.closeSessionFactory();
	}
}
