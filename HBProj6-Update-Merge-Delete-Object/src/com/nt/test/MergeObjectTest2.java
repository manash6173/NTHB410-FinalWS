package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class MergeObjectTest2 {

	public static void main(String[] args) {
		Session ses=null;
		Product prod=null,prod1=null,prod2=null;
		Transaction tx=null;
		boolean flag=false;
		
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Object
		prod=new Product();
		prod.setPid(9011); prod.setPname("w-sofa");
		prod.setPrice(8000); prod.setQty(100);
		prod.setIsExpired(false);
		prod1=new Product();
		prod1.setPid(9011); prod1.setPname("C-sofa");
		prod1.setPrice(2000); prod1.setQty(10);
		prod1.setIsExpired(false);
		
		  try {
		//begin Transaction
			tx=ses.beginTransaction();
			 ses.save(prod);
			 //ses.update(prod1);
			 prod2=(Product) ses.merge(prod1);
			 System.out.println(prod2);
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
