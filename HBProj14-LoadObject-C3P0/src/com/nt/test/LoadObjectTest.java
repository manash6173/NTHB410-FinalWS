package com.nt.test;

import java.lang.reflect.Method;

import org.hibernate.Session;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		InsurancePolicy policy=null;
		//get Session
		ses=HibernateUtil.getSession();
		//Load object using ses.load(-,-) method
		try {
			policy=ses.load(InsurancePolicy.class,1001);
	   		// System.out.println(policy.getPolicyId()+" "+policy.getPolicyName()+" "+policy.getTenure()+"  "+policy.getCompany()+" "+policy.getInitialAmount());
			
		}//try
		catch(Exception e) {
			System.out.println("Object/record not found");
			e.printStackTrace();
		}
		finally {
			//close HB objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
		
	}//main
}//class
