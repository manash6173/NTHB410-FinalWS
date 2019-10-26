package com.nt.test;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class DBTableRowToObjectSync {

	public static void main(String[] args) {
		Session ses=null;
		Product prod=null;
		Transaction tx=null;
		
		//get Session
		ses=HibernateUtil.getSession();
		try {
		 // Load object
		 prod=ses.get(Product.class,1001);
		 System.out.println(prod);
		   Thread.sleep(30000); //modify DB table rows
		   ses.refresh(prod); //performs sync b/w db table row to object
		  System.out.println(prod);
		}//try
		catch(Exception se) {
			se.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
