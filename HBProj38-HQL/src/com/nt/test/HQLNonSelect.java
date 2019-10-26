package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.utility.HibernateUtil;

public class HQLNonSelect {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		Transaction tx=null;
        boolean flag=false;
        int count=0;
		//get Session 
		ses=HibernateUtil.getSession();
		//prepare Query object
		query=ses.createQuery("delete from Insurancepolicy where tenure>=:min and tenure<=:max");
		//set query param values
		query.setParameter("min",10L);
		query.setParameter("max",200L);
		try {
		  tx=ses.beginTransaction();
		  count=query.executeUpdate();
		  flag=true;
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println(count+" no.of objs are deleted");
			}
			else {
				tx.rollback();
				System.out.println("records not found to delete");
			}
			//close close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
