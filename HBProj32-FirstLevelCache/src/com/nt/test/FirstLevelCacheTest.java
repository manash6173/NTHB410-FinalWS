package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class FirstLevelCacheTest {

	public static void main(String[] args) {
		Session ses=null;
		Employee emp=null,emp1=null;
		//get Session 
		ses=HibernateUtil.getSession();
		try {
		//Load object
		emp=ses.get(Employee.class,4);
		System.out.println(emp);
		System.out.println("..........");
		emp1=ses.get(Employee.class, 4);
		System.out.println(emp1);
		System.out.println("...........");
		ses.evict(emp);
		emp1=ses.get(Employee.class, 4);
		System.out.println(emp1);
		System.out.println("................");
		emp1=ses.get(Employee.class, 4);
		System.out.println(emp1);
		ses.clear();
		emp1=ses.get(Employee.class, 4);
		System.out.println(emp1);
		
			
			
		}
		catch(Exception e) {
			
		}
		finally {
			
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
