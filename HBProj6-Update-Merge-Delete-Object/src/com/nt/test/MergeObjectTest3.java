package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class MergeObjectTest3 {

	public static void main(String[] args) {
		Session ses=null;
		Product prod=null,prod1=null;
		Transaction tx=null;
		boolean flag=false;
		
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Object
		prod=ses.get(Product.class,9011);
		
		prod1=new Product();
		prod1.setPid(9011); prod1.setPname("spl-C-sofa");
		prod1.setPrice(5000); prod1.setQty(80);
		prod1.setIsExpired(false);
		
		  try {
		//begin Transaction
			tx=ses.beginTransaction();
			 prod=(Product) ses.merge(prod1);
			 System.out.println(prod1);
			flag=true;
		 
		}//try
		catch(Exception se) {
			se.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object is updated/inserted");
			}
			else {
				tx.rollback();
				System.out.println("Object is not updated/inserted");
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
