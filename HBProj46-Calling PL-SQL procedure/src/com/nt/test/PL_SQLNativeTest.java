package com.nt.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class PL_SQLNativeTest {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		 List<Employee> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			//get Access to Named Query i.e NamedNativeSQL
			query= ses.getNamedQuery("CALL_PRO");
			//set values to query params
			query.setParameter(0,1001);
			query.setParameter(1, 7000);
			//exeute the Query
			list=query.list();
			//proess the result
			list.forEach(emp->{
				System.out.println(emp);
			});
		}//try
	 catch(Exception e) {
		 e.printStackTrace();
	 }
		finally {
			//close jdbc objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}//main
}//
