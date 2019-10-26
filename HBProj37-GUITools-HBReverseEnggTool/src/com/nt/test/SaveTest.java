package com.nt.test;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Insurancepolicy;
import com.nt.utility.HibernateUtil;

public class SaveTest {

	public static void main(String[] args) {
		Session ses=null;
		Insurancepolicy policy=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session 
		ses=HibernateUtil.getSession();
		//prepare object
		policy=new Insurancepolicy();
		policy.setPolicyname("JA");
		policy.setCompany("LIC");
		policy.setTenure(90L);
		policy.setInitialamount(new BigDecimal(100000));
		
		try {
		  //begin Tx
			tx=ses.beginTransaction();
			  ses.save(policy);
		   flag=true;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object is saved");
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
