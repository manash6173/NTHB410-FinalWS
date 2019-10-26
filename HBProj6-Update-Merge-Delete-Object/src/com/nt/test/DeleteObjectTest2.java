package com.nt.test;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class DeleteObjectTest2 {

	public static void main(String[] args) {
		Session ses=null;
		Product prod=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		 //get Object
		prod=ses.get(Product.class,1020);
		if(prod==null) {
			System.out.println("record not found");
			return;
		}
		else {
			 //displa the record
			System.out.println(prod);
		 try {
			 
		   //begin Transaction
			tx=ses.beginTransaction();
			  ses.delete(prod);
			flag=true;
		  }//try
		catch(Exception se) {
			flag=false;
			se.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object deleted");
			}
			else {
				tx.rollback();
				System.out.println("Object not deleted");
			}
			//close HB objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
		}//else	
	}//main
}//class
