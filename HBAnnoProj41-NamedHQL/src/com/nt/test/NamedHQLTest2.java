package com.nt.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Insurancepolicy;
import com.nt.utility.HibernateUtil;

public class NamedHQLTest2 {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		Transaction tx=null;
		boolean flag=false;
		int count=0;
		//get Session 
		ses=HibernateUtil.getSession();
		try {
		  tx=ses.beginTransaction();	
		//access Named HQL Query
		query=ses.getNamedQuery("UPD_POLICY_BY_NAME");
		//get Access to Named HQL Query
		query.setParameter("amt",100.0f);
		query.setParameter("name","JA");
		 count=query.executeUpdate();
		flag=true;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("no.of records updated::"+count);
			}
			else {
				tx.rollback();
			}
		
		
		//close Session,SessionFactory
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
		}//finally
	}
}
