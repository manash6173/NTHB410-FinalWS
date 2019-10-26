package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class GeneratorsTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Employee emp=null;
		String idVal=null;
		//get Session 
		ses=HibernateUtil.getSession();
		//prpeare object
		emp=new Employee();
		 emp.setEname("rajesh");
		emp.setDesg("CLERK"); emp.setSalary(9000);
		try {
			tx=ses.beginTransaction();
			idVal=(String) ses.save(emp);
			System.out.println("Generated id values::"+idVal);
			flag=true;
		}
		catch(Exception e) {
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
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
