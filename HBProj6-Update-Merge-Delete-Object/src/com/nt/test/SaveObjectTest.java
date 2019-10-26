package com.nt.test;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		Product prod=null;
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare object
		prod=new Product();
		prod.setPid(1036); prod.setPname("light");
		prod.setPrice(10); 
		try {
		//begin Transaction
			tx=ses.beginTransaction();
			idVal=(int) ses.save(prod);
			flag=true;
		}//try
		catch(Exception se) {
			se.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Objet is saved");
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved");
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
