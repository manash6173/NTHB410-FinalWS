package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class MergeObjectTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Product prod=null;
		Transaction tx=null;
		boolean flag=false;
		
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Object
		prod=new Product();
		prod.setPid(9001); prod.setPname("spl-sofa1");
		prod.setPrice(8000); prod.setQty(100);
		prod.setIsExpired(false);
		  try {
		//begin Transaction
			tx=ses.beginTransaction();
			ses.merge(prod);
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
