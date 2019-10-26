package com.nt.test;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class UpdateObjectTest1 {

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
		prod.setPid(1001); prod.setPrice(40); prod.setPname("tonedmilk1"); 
		 prod.setQty(1);
		prod.setIsExpired(true);
		try {
		//begin Transaction
			tx=ses.beginTransaction();
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
	}//main
}//class
