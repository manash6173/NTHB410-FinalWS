package com.nt.test;

import java.util.Arrays;

import org.hibernate.Session;

import com.nt.entity.IInsurancePolicy;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		IInsurancePolicy policy=null;
		//get Session
		ses=HibernateUtil.getSession();
		//Load object using ses.load(-,-) method
		try {
			policy=ses.load(IInsurancePolicy.class,1001);
			System.out.println(policy.getClass()+"  "+policy.getClass().getSuperclass()+"  "+Arrays.toString(policy.getClass().getInterfaces()));
	   		System.out.println(policy.getPolicyId()+" "+policy.getPolicyName()+" "+policy.getTenure()+"  "+policy.getCompany()+" "+policy.getInitialAmount());
			
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
