package com.nt.test;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class ToolsTest {

	public static void main(String[] args) {
		Session ses=null;
		Employee emp=null,emp1=null;
		//get Session 
		ses=HibernateUtil.getSession();
		System.out.println("session created....");
		 try {
			 Thread.sleep(40000);
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
       System.out.println("End of App");			
	}//main
}//class
