package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class SaveOrUpdateObjectTest {
	public static void main(String[] args) {
		Session ses=null;
		Product prod=null;
		Transaction tx=null;
		boolean flag=false;
		//get SEssion
		ses=HibernateUtil.getSession();
		//prepar object
		prod=new Product();
		prod.setPid(1006);
		prod.setPname("table");
		prod.setPrice(900);
		prod.setQty(10);
		prod.setIsExpired(false);
		try {
		  //begin Tx
		  tx=ses.beginTransaction();
			ses.saveOrUpdate(prod);
		    flag=true;
		}//try
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object is saved/updated");
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved/updated");
			}
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
		
	}//main
}//class
