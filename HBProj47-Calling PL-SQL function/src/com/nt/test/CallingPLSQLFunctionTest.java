package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class CallingPLSQLFunctionTest {

	public static void main(String[] args) {
		Session ses=null; 
		Query query=null;
		List<InsurancePolicy> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
		//get Access to Named Query
		query=ses.getNamedQuery("CALL_FX");
		//set query param values
		query.setParameter(0,200 );
		query.setParameter(1,300);
		//call PL/SQL function
		list=query.list();
		//process the results
		list.forEach(ip->{
			System.out.println(ip);
		});
		
		
		
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close jdbc objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}//main
}//class
