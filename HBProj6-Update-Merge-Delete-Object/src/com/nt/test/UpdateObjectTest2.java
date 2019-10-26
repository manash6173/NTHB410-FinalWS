package com.nt.test;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class UpdateObjectTest2 {

	public static void main(String[] args) {
		Session ses=null;
		Product prod=null;
		Transaction tx=null;
		boolean flag=false;
		
		//get Session
		ses=HibernateUtil.getSession();
		
		//Load object
		prod=ses.get(Product.class,1001);
		if(prod==null) {
			System.out.println("Record not found");
			return;
		}
		else {
			
			System.out.println(prod);
		  try {
		//begin Transaction
			tx=ses.beginTransaction();
			prod.setPrice(110);
			ses.update(prod);
			flag=true;
		 
		}//try
		catch(Exception se) {
			se.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Objet is updated");
			}
			else {
				tx.rollback();
				System.out.println("Object is not updated/found");
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
		}//else
	}//main
}//class
